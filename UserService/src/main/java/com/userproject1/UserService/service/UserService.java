package com.userproject1.UserService.service;

import com.userproject1.UserService.dto.ResponseDto;
import com.userproject1.UserService.entity.User;

public interface UserService {
    User saveUser(User user);

    ResponseDto getUser(Long userId);
}
