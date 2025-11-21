package org.example.todo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.ConstraintViolation;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTests {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    void validUserShouldHaveNoViolations() {
        User user = new User();
        user.setFirstName("Anna-Maria");
        user.setLastName("Kovalenko-Bynzar");
        user.setEmail("anna@example.com");
        user.setPassword("QwQw1234!");
        user.setRole("USER");

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertTrue(violations.isEmpty());
    }
    @Test
    void invalidEmailShouldProduceViolation() {
        User user = new User();
        user.setFirstName("Anna");
        user.setLastName("Kovalenko");
        user.setEmail("invalid_email");
        user.setPassword("QwQw1234!");

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertEquals(1, violations.stream().filter(v -> v.getPropertyPath().toString().equals("email")).count());
    }
    @Test
    void weakPasswordShouldProduceViolation() {
        User user = new User();
        user.setFirstName("Anna");
        user.setLastName("Kovalenko");
        user.setEmail("anna@example.com");
        user.setPassword("password");

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("password")));
    }
}