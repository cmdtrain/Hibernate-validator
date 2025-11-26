package org.example.todo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoCollaboratorTests {

    @Test
    void collaboratorLinksUserAndTodo() {
        User user = new User();
        ToDo toDo = new ToDo();
        TodoCollaborator link = new TodoCollaborator();
        link.setCollaborator(user);
        link.setTodo(toDo);
        assertEquals(user, link.getCollaborator());
        assertEquals(toDo, link.getTodo());
    }
}