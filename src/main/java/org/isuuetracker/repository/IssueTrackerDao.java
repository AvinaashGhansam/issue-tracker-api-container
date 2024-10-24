package org.isuuetracker.repository;

import org.isuuetracker.IssueTracker;

import java.util.List;
import java.util.Optional;

public interface IssueTrackerDao {
    List<IssueTracker>selectAllIssues();
    Optional<IssueTracker>selectIssueById(Integer id);
    void insertIssue(IssueTracker issueTracker);
    void deleteIssueById(Integer id);
    boolean existsIssueById(Integer id);
    void updateIssue(IssueTracker updateIssueTracker);


}
