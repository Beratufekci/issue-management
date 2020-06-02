package com.management.issuemanagement.service.impl;

import com.management.issuemanagement.dto.UserDto;
import com.management.issuemanagement.entity.User;
import com.management.issuemanagement.repository.UserRepository;
import com.management.issuemanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDto save(UserDto userDto) {

        User user = modelMapper.map(userDto, User.class);

        userRepository.save(user);

        userDto.setId(user.getId());

        return userDto;
    }

    @Override
    public UserDto update(Long id, UserDto userDto) {


        Optional<User> user = userRepository.findById(id);

        User updatedUser = user.map(u->{

            u.setName(userDto.getName());
            u.setSurname(userDto.getSurname());
            u.setEmail(userDto.getEmail());

            return u;

        }).orElseThrow(IllegalArgumentException::new);

        userRepository.save(updatedUser);

        return modelMapper.map(updatedUser,UserDto.class);
    }

    @Override
    public Boolean delete(Long id) {

        if(id == null){
            throw new IllegalArgumentException("id cannot be null");
        }

        User user = userRepository.getOne(id);

        if(user == null){
            throw new IllegalArgumentException("User is null");
        }

        userRepository.deleteById(id);

        return Boolean.TRUE;

    }

    @Override
    public UserDto getById(Long id) {

        if(id == null){
            throw new IllegalArgumentException("id cannot be null");
        }

        User user = userRepository.getOne(id);

        return modelMapper.map(user,UserDto.class);
    }

    @Override
    public List<UserDto> getAll() {

        List<User> userList = userRepository.findAll();

        return  Arrays.asList(modelMapper.map(userList,UserDto[].class));

    }
    
}
