package org.klang.torn.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestClient;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    UserRepository userRepository;

    @Mock
    MoneyRepository moneyRepository;

    MoneyMapper moneyMapper = new MoneyMapper();

    @Mock
    RestClient restClient;

    UserService userService;

    @BeforeEach
    void setup() {
        userService = new UserService(userRepository, moneyRepository, moneyMapper, restClient);
    }

    @Test
    void addUser_withValidFields_returnsUserEntity() {
        //test setup
        BigInteger userId = BigInteger.ONE;
        String userApiKey = "userApiKey";
        when(userRepository.save(any())).thenReturn(new UserEntity(BigInteger.ONE, "userApiKey"));
        UserEntity expected = UserEntity.builder().userId(userId).userApiKey(userApiKey).build();

        //execute
        UserEntity result = userService.addUser(userId, userApiKey);

        //verify
        assertEquals(expected.userId, result.userId);
        assertEquals(expected.userApiKey, result.userApiKey);
    }

    @Test
    void addUser_withNullFields_throwsIllegalArgumentException() {
        //test setup
        BigInteger userId = null;
        String userApiKey = null;

        //execute & verify
        assertThrows(IllegalArgumentException.class, () -> userService.addUser(userId, userApiKey));
    }

    @Test
    void getUserApiKey() {
    }
}