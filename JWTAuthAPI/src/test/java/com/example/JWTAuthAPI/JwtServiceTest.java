package com.example.JWTAuthAPI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class JwtServiceTest {

  @Autowired
  private JwtService jwtService;

  @Test
  void testGenerateToken() {
    UserEntity user = new UserEntity();
    user.setEmail("test@example.com");
    user.setRole(Role.USER);

    String token = jwtService.generateToken(user);

    assertNotNull(token);
    assertTrue(token.length() > 10);
  }
}

