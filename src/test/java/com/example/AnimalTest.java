package com.example;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AnimalTest {
    Animal animal = new Animal();

    @Test
    void shouldReturnNonEmptyFamily() {
        String family = animal.getFamily();

        assertNotNull(family);
        assertFalse(family.isEmpty());
    }
}
