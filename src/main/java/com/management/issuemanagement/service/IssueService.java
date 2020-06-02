package com.management.issuemanagement.service;

import com.management.issuemanagement.dto.IssueDto;

import java.util.List;

public interface IssueService {

    IssueDto save(IssueDto issueDto);

    IssueDto update(Long id,IssueDto issueDto);

    Boolean delete(Long id);

    IssueDto getById(Long id);

    List<IssueDto> getAll();
}
