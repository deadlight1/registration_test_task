package com.volodymyr.register_usertest_task.service.impl;

import com.volodymyr.register_usertest_task.model.dto.UserDto;
import com.volodymyr.register_usertest_task.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return mapper.map(userRepository.findByUsername(username)
                        .orElseThrow(() -> new UsernameNotFoundException(username))
                , UserDto.class);
    }
}
