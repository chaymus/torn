package org.klang.torn.user;

import org.klang.torn.user.dto.MoneyResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserEntity> createUser(@RequestParam Long userId, @RequestParam String userApiKey) {
        return ResponseEntity.ok(userService.addUser(userId, userApiKey));
    }


    @GetMapping("/money")
    public ResponseEntity<MoneyResponseDTO> getMoney(@RequestParam Long userId) {
        String userApiKey = userService.getUserApiKey(userId);
        return ResponseEntity.ok(userService.getMoney(userId, userApiKey));
    }
}
