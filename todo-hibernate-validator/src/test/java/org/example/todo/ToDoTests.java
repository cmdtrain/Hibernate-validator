package org.example.todo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.ConstraintViolation;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ToDoTests {

    private Validator validator;
    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    void validTodoShouldHaveNoViolations() {
        ToDo toDo = new ToDo();
        toDo.setTitle("My todo");

        Set<ConstraintViolation<ToDo>> violations = validator.validate(toDo);
        assertTrue(violations.isEmpty());
    }

    @Test
    void blankTitleShouldProduceViolation() {
        ToDo toDo = new ToDo();
        toDo.setTitle("  ");

        Set<ConstraintViolation<ToDo>> violations = validator.validate(toDo);
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("title")));
    }
}