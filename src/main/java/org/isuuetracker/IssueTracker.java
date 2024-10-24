package org.isuuetracker;

import java.util.Date;
import java.util.Objects;


public class IssueTracker {

    private Integer id;
    private String title;
    private String description;
    private Date createdAt;
    private Date updatedAt;
    Status status;

    public IssueTracker() {}
    public IssueTracker(Integer id, String title, String description, Date createdAt, Date updatedAt, Status status ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IssueTracker that = (IssueTracker) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getTitle(), that.getTitle()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getCreatedAt(), that.getCreatedAt()) && Objects.equals(getUpdatedAt(), that.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getDescription(), getCreatedAt(), getUpdatedAt());
    }

}
