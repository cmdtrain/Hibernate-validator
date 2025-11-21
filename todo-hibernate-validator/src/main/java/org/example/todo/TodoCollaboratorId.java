package org.example.todo;

import java.io.Serializable;
import java.util.Objects;

public class TodoCollaboratorId implements Serializable {

    private Long todo;
    private Long collaborator;

    public TodoCollaboratorId() {
    }

    public TodoCollaboratorId(Long todo, Long collaborator) {
        this.todo = todo;
        this.collaborator = collaborator;
    }

    public Long getTodo() {
        return todo;
    }
    public void setTodo(Long todo) {
        this.todo = todo;
    }
    public Long getCollaborator() {
        return collaborator;
    }
    public void setCollaborator(Long collaborator) {
        this.collaborator = collaborator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TodoCollaboratorId)) return false;
        TodoCollaboratorId that = (TodoCollaboratorId) o;
        return Objects.equals(todo, that.todo) && Objects.equals(collaborator, that.collaborator);
    }
    @Override
    public int hashCode() {
        return Objects.hash(todo, collaborator);
    }
}