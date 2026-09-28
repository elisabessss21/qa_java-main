package com.example;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LionTest {@Test
void shouldThrowExceptionForInvalidSex() {
    Feline feline = Mockito.mock(Feline.class);

    assertThrows(Exception.class, () -> new Lion("Другое", feline));
}

    @Test
    void shouldReturnOneKitten() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Mockito.when(feline.getKittens()).thenReturn(1);

        Lion lion = new Lion("Самец", feline);

        assertEquals(1, lion.getKittens());
    }

    @Test
    void shouldReturnPredatorFood() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);

        Lion lion = new Lion("Самец", feline);

        assertEquals(expected, lion.getFood());
    }
}
