package com.management.issuemanagement.service;

import com.management.issuemanagement.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto save(UserDto userDto);

    UserDto update(Long id,UserDto userDto);

    Boolean delete(Long id);

    UserDto getById(Long id);

    List<UserDto> getAll();
}
