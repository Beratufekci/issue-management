package com.management.issuemanagement.dto;

import com.management.issuemanagement.entity.IssueStatus;
import com.management.issuemanagement.entity.PriorityType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IssueDto {

    private Long id;
    private String description;
    private Date date;
    private String detail;
    private IssueStatus issueStatus;
    private UserDto assignee;
    private UserDto reporter;
    private ProjectDto project;
    private PriorityType priorityType;
}
