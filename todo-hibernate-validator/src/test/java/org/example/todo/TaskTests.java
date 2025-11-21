package org.example.todo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.ConstraintViolation;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskTests {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    void validTaskShouldHaveNoViolations() {
        Task task = new Task();
        task.setName("Do something important");

        Set<ConstraintViolation<Task>> violations = validator.validate(task);
        assertTrue(violations.isEmpty());
    }
    @Test
    void shortNameShouldProduceViolation() {
        Task task = new Task();
        task.setName("ab");

        Set<ConstraintViolation<Task>> violations = validator.validate(task);
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("name")));
    }
}