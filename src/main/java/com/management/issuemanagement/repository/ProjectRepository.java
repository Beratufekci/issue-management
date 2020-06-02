package com.management.issuemanagement.repository;

import com.management.issuemanagement.dto.ProjectDto;
import com.management.issuemanagement.entity.Project;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {

    List<Project> getByProjectCodeContains(String projectCode);

    List<Project> getByProjectCode(String projectCode);

    List<Project> findAll(Sort sort);
}
