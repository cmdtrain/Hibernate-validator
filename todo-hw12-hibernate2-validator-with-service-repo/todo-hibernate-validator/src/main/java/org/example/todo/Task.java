package org.example.todo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 3, max = 200)
    @Column(name = "name", nullable = false, length = 200)
    private String name;
    @Size(max = 255)
    @Column(name = "priority", length = 255)
    private String priority;
    @ManyToOne
    @JoinColumn(name = "todo_id")
    private ToDo todo;
    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public ToDo getTodo() {
        return todo;
    }

    public void setTodo(ToDo todo) {
        this.todo = todo;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}