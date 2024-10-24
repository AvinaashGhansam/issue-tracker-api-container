package org.isuuetracker.service;

import org.isuuetracker.IssueTracker;
import org.isuuetracker.Status;
import org.isuuetracker.repository.IssueTrackerDao;
import org.isuuetracker.repository.IssueTrackerRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jdbc")
public class IssueTrackerJDBCAccessService implements IssueTrackerDao {
    private final JdbcTemplate jdbcTemplate;
    private final IssueTrackerRowMapper issueTrackerRowMapper;

    public IssueTrackerJDBCAccessService(JdbcTemplate jdbcTemplate, IssueTrackerRowMapper issueTrackerRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.issueTrackerRowMapper = issueTrackerRowMapper;
    }

    @Override
    public List<IssueTracker> selectAllIssues() {
        String sql = """
                SELECT * FROM Issue;
                """;
        return jdbcTemplate.query(sql, issueTrackerRowMapper);
    }

    @Override
    public Optional<IssueTracker> selectIssueById(Integer id) {
        String sql = """
                SELECT * FROM Issue
                WHERE id = ?
                """;
        return jdbcTemplate.query(sql, issueTrackerRowMapper, id).stream().findFirst();
    }

    @Override
    public void insertIssue(IssueTracker issueTracker) {
        String sql = """
            INSERT INTO Issue (title, description)
            VALUES (?, ?)
            """;
        jdbcTemplate.update(
                sql,
                issueTracker.getTitle(),
                issueTracker.getDescription()
        );
    }

    @Override
    public void deleteIssueById(Integer id) {
        String sql = """
                DELETE FROM Issue WHERE id = ?
                """;
        jdbcTemplate.update(sql, id);

    }

    @Override
    public boolean existsIssueById(Integer id) {
        String sql = """
                SELECT count(id) FROM Issue WHERE id = ?
                """;
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id);

        return count != null && count > 0;
    }

    @Override
    public void updateIssue(IssueTracker updateIssueTracker) {

    }
}
