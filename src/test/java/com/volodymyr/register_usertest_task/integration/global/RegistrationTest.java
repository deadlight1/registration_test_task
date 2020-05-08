package com.volodymyr.register_usertest_task.integration.global;

import com.volodymyr.register_usertest_task.integration.BaseIntegrationTest;
import com.volodymyr.register_usertest_task.model.dto.UserDto;
import com.volodymyr.register_usertest_task.model.entity.User;
import com.volodymyr.register_usertest_task.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static com.volodymyr.register_usertest_task.model.enums.Authority.USER;
import static org.junit.Assert.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RegistrationTest extends BaseIntegrationTest {


    @Autowired
    private UserRepository userRepository;

    @Test
    public void getRegistrationPage() throws Exception {
        mvc.perform(get("/registration"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void registerUser() throws Exception {
        UserDto userDto = UserDto.builder()
                .username("test@gmail.com")
                .password("ads@WADS21SAXs")
                .build();
        mvc.perform(post("/registration")
                .param("username", userDto.getUsername())
                .param("password", userDto.getPassword())
                .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andDo(print());
        Optional<User> userOptional = userRepository.findByUsername("test@gmail.com");
        assertTrue(userOptional.isPresent());
        User user = userOptional.get();
        assertTrue(user.getAuthorities().contains(USER));
        assertNotNull(user.getPassword());
        assertNotEquals(userDto.getPassword(), user.getPassword());
    }
}
