package com.management.issuemanagement.service.impl;

import com.management.issuemanagement.dto.IssueDto;
import com.management.issuemanagement.entity.Issue;
import com.management.issuemanagement.entity.Project;
import com.management.issuemanagement.entity.User;
import com.management.issuemanagement.repository.IssueRepository;
import com.management.issuemanagement.service.IssueService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;

    @Override
    public IssueDto save(IssueDto issueDto) {

        Issue issue = modelMapper.map(issueDto, Issue.class);

        issueRepository.save(issue);

        issueDto.setId(issue.getId());

        return issueDto;
    }

    @Override
    public IssueDto update(Long id, IssueDto issueDto) {


        Optional<Issue> issue = issueRepository.findById(id);

        Issue updatedIssue = issue.map(i ->{
            i.setAssignee(modelMapper.map(issueDto.getAssignee(), User.class));
            i.setDescription(issueDto.getDescription());
            i.setDetail(issueDto.getDetail());
            i.setDate(issueDto.getDate());
            i.setIssueStatus(issueDto.getIssueStatus());
            i.setPriorityType(issueDto.getPriorityType());
            i.setProject(modelMapper.map(issueDto.getProject(), Project.class));
            i.setReporter(modelMapper.map(issueDto.getReporter(), User.class));

            return i;

        }).orElseThrow(IllegalArgumentException::new);

        issueRepository.save(updatedIssue);

        return modelMapper.map(updatedIssue,IssueDto.class);
    }

    @Override
    public Boolean delete(Long id) {

        if(id == null){
            throw new IllegalArgumentException("id cannot be null");
        }

        Issue issue = issueRepository.getOne(id);

        if(issue == null){
            throw new IllegalArgumentException("issue is null");
        }

        issueRepository.deleteById(id);

        return Boolean.TRUE;

    }

    @Override
    public IssueDto getById(Long id) {

        if(id == null){
            throw new IllegalArgumentException("id cannot be null");
        }

        Issue issue = issueRepository.getOne(id);

        return modelMapper.map(issue,IssueDto.class);
    }

    @Override
    public List<IssueDto> getAll() {

        List<Issue> issueList = issueRepository.findAll();

        return  Arrays.asList(modelMapper.map(issueList,IssueDto[].class));

    }
}
