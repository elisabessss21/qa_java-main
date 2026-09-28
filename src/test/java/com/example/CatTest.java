package com.example;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatTest {
    @Test
    void shouldReturnMeow() {
        Feline feline = Mockito.mock(Feline.class);
        Cat cat = new Cat(feline);

        String actual = cat.getSound();
        assertEquals("Мяу", actual);
    }

    @Test
    void shouldReturnPredatorFood() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expected);

        Cat cat = new Cat(feline);

        List<String> actual = cat.getFood();
        assertEquals(expected, actual);
    }
}
