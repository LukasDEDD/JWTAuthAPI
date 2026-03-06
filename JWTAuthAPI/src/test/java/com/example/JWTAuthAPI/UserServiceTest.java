package com.example.JWTAuthAPI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UserServiceTest {

  @Autowired
  private UserService userService;

  @Test
  void testSaveUser() {
    UserEntity user = new UserEntity();
    user.setFirstname("Test");
    user.setLastname("User");
    user.setEmail("test@example.com");
    user.setPassword("password");
    user.setRole(Role.USER);

    userService.save(user);

    UserEntity found = userService.findByEmail("test@example.com");

    assertNotNull(found);
    assertEquals("test@example.com", found.getEmail());
  }
}
