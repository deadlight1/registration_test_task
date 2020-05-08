package com.volodymyr.register_usertest_task.service.impl;

import com.volodymyr.register_usertest_task.model.dto.UserDto;
import com.volodymyr.register_usertest_task.model.entity.User;
import com.volodymyr.register_usertest_task.model.enums.Authority;
import com.volodymyr.register_usertest_task.repository.UserRepository;
import com.volodymyr.register_usertest_task.service.RegistrationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

import static com.volodymyr.register_usertest_task.model.enums.Authority.USER;

@Slf4j
@Service
@AllArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper mapper;

    @Override
    public boolean registerUser(UserDto userDto) {
        if (userRepository.findByUsername(userDto.getUsername()).isPresent())
            return false;
        User user = mapper.map(userDto, User.class);
        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        user.setEnabled(true);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setPassword(encodedPassword);
        user.setAuthorities(new HashSet<Authority>() {{
            add(USER);
        }});
        userRepository.save(user);
        return true;
    }
}
