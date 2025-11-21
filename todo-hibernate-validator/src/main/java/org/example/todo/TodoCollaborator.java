package org.example.todo;

import javax.persistence.*;

@Entity
@Table(name = "todo_collaborator")
@IdClass(TodoCollaboratorId.class)
public class TodoCollaborator {

    @Id
    @ManyToOne
    @JoinColumn(name = "todo_id")
    private ToDo todo;
    @Id
    @ManyToOne
    @JoinColumn(name = "collaborator_id")
    private User collaborator;

    public TodoCollaborator() {
    }

    public ToDo getTodo() {
        return todo;
    }

    public void setTodo(ToDo todo) {
        this.todo = todo;
    }
    public User getCollaborator() {
        return collaborator;
    }

    public void setCollaborator(User collaborator) {
        this.collaborator = collaborator;
    }
}