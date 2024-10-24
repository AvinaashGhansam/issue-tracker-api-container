package org.isuuetracker.controller;

import org.isuuetracker.IssueTracker;
import org.isuuetracker.dto.RegisterNewIssueRequest;
import org.isuuetracker.service.IssueTrackerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/issues")
public class IssueTrackerController {
    private final IssueTrackerService issueTrackerService;
    public IssueTrackerController(IssueTrackerService issueTrackerService) {
        this.issueTrackerService = issueTrackerService;
    }

    @GetMapping
    public List<IssueTracker>getAllIssues() {
        return issueTrackerService.getAllIssues();
    }

    @PostMapping
    public void addNewIssue(@RequestBody RegisterNewIssueRequest registerNewIssueRequest) {
        issueTrackerService.addIssue(registerNewIssueRequest);
    }
}
