package org.klang.torn.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.klang.torn.user.dto.MoneyDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RestClient restClient;
    private final String MONEY_URI = "/user/money";

    public UserEntity addUser(Long userId, String userApiKey) {
        return userRepository.save(UserEntity.builder().userId(userId).userApiKey(userApiKey).build());
    }

    public MoneyDTO getMoney(String userApiKey) {
        MoneyDTO money = null;
        try {
            money = restClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path(MONEY_URI)
                            .queryParam("key", userApiKey)
                            .build())
                    .retrieve()
                    .body(MoneyDTO.class);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        log.info("Money retrieved {}", money);
        return money;
    }

    public String getUserApiKey(Long userId) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        if(user != null) {
            return user.userApiKey;
        }
        return null;
    }
}
