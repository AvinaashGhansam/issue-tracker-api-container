package org.isuuetracker.dto;

import org.isuuetracker.Status;

import java.util.Date;

public record RegisterNewIssueRequest(String title, String description) {
}
