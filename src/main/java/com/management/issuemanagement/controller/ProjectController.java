package com.management.issuemanagement.controller;

import com.management.issuemanagement.dto.ProjectDto;
import com.management.issuemanagement.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {
    
    private final ProjectService projectService;
    
    
    @PostMapping
    public ResponseEntity<ProjectDto> save(@RequestBody ProjectDto projectDto) {

        return ResponseEntity.ok(projectService.save(projectDto));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> update(@PathVariable(value = "id", required = true) Long id, @RequestBody ProjectDto projectDto){

        return ResponseEntity.ok(projectService.update(id,projectDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true)  Long id) {

        return ResponseEntity.ok(projectService.delete(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getById(@PathVariable(value = "id", required = true)  Long id) {

        return ResponseEntity.ok(projectService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProjectDto>> getAll(){

        return ResponseEntity.ok(projectService.getAll());
    }
}
