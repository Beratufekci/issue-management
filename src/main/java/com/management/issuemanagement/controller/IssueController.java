package com.management.issuemanagement.controller;

import com.management.issuemanagement.dto.IssueDto;
import com.management.issuemanagement.service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/issue")
@RequiredArgsConstructor
public class IssueController {

    private final IssueService issueService;


    @PostMapping
    public ResponseEntity<IssueDto> save(@RequestBody IssueDto issueDto) {

        return ResponseEntity.ok(issueService.save(issueDto));
    }


    @PutMapping("/{id}")
    public ResponseEntity<IssueDto> update(@PathVariable(value = "id", required = true) Long id, @RequestBody IssueDto issueDto){

        return ResponseEntity.ok(issueService.update(id,issueDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true)  Long id) {

        return ResponseEntity.ok(issueService.delete(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<IssueDto> getById(@PathVariable(value = "id", required = true)  Long id) {

        return ResponseEntity.ok(issueService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<IssueDto>> getAll(){

      return ResponseEntity.ok(issueService.getAll());
    }
}
