package org.isuuetracker.service;

import org.isuuetracker.IssueTracker;
import org.isuuetracker.Status;
import org.isuuetracker.dto.RegisterNewIssueRequest;
import org.isuuetracker.exceptions.ResourceNotFoundException;
import org.isuuetracker.repository.IssueTrackerDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class IssueTrackerService {
    private final IssueTrackerDao issueTrackerDao;

    public IssueTrackerService(@Qualifier("jdbc") IssueTrackerDao issueTrackerDao) {
        this.issueTrackerDao = issueTrackerDao;
    }
    public List<IssueTracker> getAllIssues() {
        return issueTrackerDao.selectAllIssues();
    }
    public IssueTracker getIssueById(Integer id) {
        return issueTrackerDao.selectIssueById(id).
                orElseThrow(
                        () -> new ResourceNotFoundException("issue with id[%s] not found".formatted(id)));
    }

    public void addIssue(RegisterNewIssueRequest registerNewIssueRequest) {
        issueTrackerDao.insertIssue(new IssueTracker(
                null,
                registerNewIssueRequest.title(),
                registerNewIssueRequest.description(),
                null,
                null,
                Status.OPEN
        ));
    }


}
