package com.management.issuemanagement.service.impl;
import com.management.issuemanagement.dto.ProjectDto;
import com.management.issuemanagement.entity.Project;
import com.management.issuemanagement.repository.ProjectRepository;
import com.management.issuemanagement.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    @Override
    public ProjectDto save(ProjectDto projectDto) {

        Project project = modelMapper.map(projectDto, Project.class);

        projectRepository.save(project);

        projectDto.setId(project.getId());

        return projectDto;
    }

    @Override
    public ProjectDto update(Long id, ProjectDto projectDto) {

        Optional<Project> project = projectRepository.findById(id);

        Project updatedProject = project.map(p ->{
            p.setProjectCode(projectDto.getProjectCode());
            p.setProjectName(projectDto.getProjectName());

            return p;

        }).orElseThrow(IllegalArgumentException::new);

        projectRepository.save(updatedProject);

        return modelMapper.map(updatedProject,ProjectDto.class);

    }

    @Override
    public Boolean delete(Long id) {

        if(id == null){
            throw new IllegalArgumentException("id cannot be null");
        }

        Project project = projectRepository.getOne(id);

        if(project == null){
            throw new IllegalArgumentException("project is null");
        }

        projectRepository.deleteById(id);

        return Boolean.TRUE;
    }

    @Override
    public ProjectDto getById(Long id) {

        if(id == null){
            throw new IllegalArgumentException("id cannot be null");
        }

        Project project = projectRepository.getOne(id);

        return modelMapper.map(project,ProjectDto.class);
    }

    @Override
    public List<ProjectDto> getAll() {

        List<Project> projectList = projectRepository.findAll();

        return  Arrays.asList(modelMapper.map(projectList,ProjectDto[].class));

    }

}
