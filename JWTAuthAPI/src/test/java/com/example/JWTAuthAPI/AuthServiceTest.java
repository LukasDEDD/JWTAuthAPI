package com.example.JWTAuthAPI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class AuthServiceTest {

  @Autowired
  private AuthService authService;

  @Autowired
  private UserService userService;

  @Test
  void testRegister() {
    RegisterRequest request = new RegisterRequest();
    request.setFirstname("Lukas");
    request.setLastname("Simek");
    request.setEmail("lukas@test.com");
    request.setPassword("heslo123");
    request.setRole(Role.USER);

    AuthResponse response = authService.register(request);

    assertNotNull(response.getToken());
  }

  @Test
  void testLogin() {

    UserEntity user = new UserEntity();
    user.setFirstname("Test");
    user.setLastname("User");
    user.setEmail("login@test.com");
    user.setPassword("$2a$10$abcdefghijklmnopqrstuv"); // fake hash
    user.setRole(Role.USER);
    userService.save(user);

    LoginRequest request = new LoginRequest();
    request.setEmail("login@test.com");
    request.setPassword("heslo123");

    assertThrows(RuntimeException.class, () -> {
      authService.login(request);
    });
  }
}

