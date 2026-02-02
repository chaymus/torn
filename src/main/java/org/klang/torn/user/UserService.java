package org.klang.torn.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.klang.torn.user.dto.MoneyResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.math.BigInteger;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final MoneyRepository moneyRepository;
    private final MoneyMapper moneyMapper;
    private final RestClient restClient;
    private final String MONEY_URI = "/user/money";

    public UserEntity addUser(BigInteger userId, String userApiKey) {
        if(userId == null || userApiKey == null || userApiKey.trim().isEmpty()) {
            throw new IllegalArgumentException("invalid params for addUser call");
        }
        return userRepository.save(UserEntity.builder().userId(userId).userApiKey(userApiKey).build());
    }

    @Transactional
    public MoneyResponseDTO getMoney(BigInteger userId, String userApiKey) {
        MoneyResponseDTO money = null;
        MoneyEntity result = null;
        try {
            money = restClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path(MONEY_URI)
                            .queryParam("key", userApiKey)
                            .build())
                    .retrieve()
                    .body(MoneyResponseDTO.class);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        log.info("Money retrieved {}", money);
        if(money != null) {
            result = moneyRepository.save(moneyMapper.toEntity(userId, money));
        }

        assert result != null;
        return moneyMapper.toDTO(result);
    }

    public String getUserApiKey(BigInteger userId) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        if(user != null) {
            return user.userApiKey;
        }
        return null;
    }
}
