package com.example;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineTest {
    Feline feline = new Feline();

    @Test
    void shouldEatMeat() throws Exception {
        List<String> actual = feline.eatMeat();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnFelineFamily() {
        String actual = feline.getFamily();
        assertEquals("Кошачьи", actual);
    }

    @Test
    void shouldReturnOneKittenByDefault() {
        int actual = feline.getKittens();
        assertEquals(1, actual);
    }

    @Test
    void shouldReturnSpecifiedKittensCount() {
        int actual = feline.getKittens(5);
        assertEquals(5, actual);
    }
}
