package com.volodymyr.register_usertest_task.service;

import com.volodymyr.register_usertest_task.model.dto.UserDto;

public interface RegistrationService {
    boolean registerUser(UserDto userDto);
}
