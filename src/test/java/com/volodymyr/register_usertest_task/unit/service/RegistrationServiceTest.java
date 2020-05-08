package com.volodymyr.register_usertest_task.unit.service;


import com.volodymyr.register_usertest_task.model.dto.UserDto;
import com.volodymyr.register_usertest_task.model.entity.User;
import com.volodymyr.register_usertest_task.repository.UserRepository;
import com.volodymyr.register_usertest_task.service.RegistrationService;
import com.volodymyr.register_usertest_task.service.impl.RegistrationServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationServiceTest {

    private RegistrationService registrationService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private ModelMapper modelMapper;
    @Mock
    private PasswordEncoder passwordEncoder;
    private UserDto userDto;

    @Before
    public void init() {
        registrationService = new RegistrationServiceImpl(userRepository, passwordEncoder, modelMapper);
        userDto = UserDto.builder()
                .username("test@gmail.com")
                .password("ads@WADS21SAXs")
                .build();
    }

    @Test
    public void registerUserAlreadyExists() {
        when(userRepository.findByUsername(anyString()))
                .thenReturn(of(User.builder().build()));
        assertFalse(registrationService.registerUser(userDto));
        verify(userRepository, times(0)).save(any(User.class));
    }

    @Test
    public void registerUserTest() {
        when(userRepository.findByUsername(anyString()))
                .thenReturn(empty());
        when(modelMapper.map(any(), any()))
                .thenReturn(User.builder()
                        .username(userDto.getUsername())
                        .password(userDto.getPassword())
                        .build());
        when(passwordEncoder.encode(anyString()))
                .thenReturn("ENCODED");
        assertTrue(registrationService.registerUser(userDto));
        verify(userRepository, times(1)).save(any(User.class));
        verify(passwordEncoder, times(1)).encode(anyString());
    }
}
