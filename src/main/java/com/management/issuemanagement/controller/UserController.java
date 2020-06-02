package com.management.issuemanagement.controller;

import com.management.issuemanagement.dto.UserDto;
import com.management.issuemanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {

        return ResponseEntity.ok(userService.save(userDto));
    }


    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable(value = "id", required = true) Long id, @RequestBody UserDto userDto){

        return ResponseEntity.ok(userService.update(id,userDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true)  Long id) {

        return ResponseEntity.ok(userService.delete(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable(value = "id", required = true)  Long id) {

        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll(){

        return ResponseEntity.ok(userService.getAll());
    }
}
