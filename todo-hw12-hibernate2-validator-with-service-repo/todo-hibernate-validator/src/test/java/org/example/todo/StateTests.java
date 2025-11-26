package org.example.todo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.ConstraintViolation;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StateTests {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void validStateShouldHaveNoViolations() {
        State state = new State();
        state.setName("In_progress-1");

        Set<ConstraintViolation<State>> violations = validator.validate(state);
        assertTrue(violations.isEmpty());
    }

    @Test
    void invalidCharactersShouldProduceViolation() {
        State state = new State();
        state.setName("Невалідна");

        Set<ConstraintViolation<State>> violations = validator.validate(state);
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("name")));
    }
}
