package com.management.issuemanagement.service;

import com.management.issuemanagement.dto.ProjectDto;

import java.util.List;

public interface ProjectService {

    ProjectDto save(ProjectDto projectDto);

    ProjectDto update(Long id,ProjectDto projectDto);

    Boolean delete(Long id);

    ProjectDto getById(Long id);

    List<ProjectDto> getAll();
}
