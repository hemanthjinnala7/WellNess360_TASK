package com.example.spring_web.model;

import com.example.spring_web.domain.Task_Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="tasks")
@NoArgsConstructor
@AllArgsConstructor
public class Task_Model
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name="title",length = 100,nullable = false)
    private String title;

    @Column(name="description",length = 100,nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private Task_Status status;

    @Column(name = "created_at")
    private LocalDateTime created_at = LocalDateTime.now();


    @Column(name = "updated_at", nullable = true, updatable = true)
    private LocalDateTime updated_at;

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    @Column(name = "due_date")
    private LocalDate dueDate = LocalDate.now().plusDays(10);

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Long getId() {
        return Id;
    }


    public void setId(Long id) {
        Id = id;
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

    public Task_Status getStatus() {
        return status;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public void setStatus(Task_Status status) {
        this.status = status;
    }


}
