package org.isuuetracker.repository;

import org.isuuetracker.IssueTracker;
import org.isuuetracker.Status;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class IssueTrackerRowMapper implements RowMapper<IssueTracker> {
    @Override
    public IssueTracker mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new IssueTracker(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getDate("createdAt"),
                rs.getDate("updatedAt"),
                Status.valueOf(rs.getString("status").toUpperCase()));
    }
}


