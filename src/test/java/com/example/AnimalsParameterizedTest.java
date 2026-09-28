package com.example;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnimalsParameterizedTest {static Stream<Arguments> foodProvider() {
    return Stream.of(
            Arguments.of("Травоядное", List.of("Трава", "Различные растения")),
            Arguments.of("Хищник", List.of("Животные", "Птицы", "Рыба"))
    );
}

    @ParameterizedTest
    @MethodSource("foodProvider")
    void shouldReturnExpectedFoodForKind(String kind, List<String> expected) throws Exception {
        Animal animal = new Animal();

        List<String> actual = animal.getFood(kind);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Птица", "Рыба", "Насекомое"})
    void shouldThrowExceptionForUnknownKinds(String kind) {
        Animal animal = new Animal();

        assertThrows(Exception.class, () -> animal.getFood(kind));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Самец", "Самка"})
    void shouldSetCorrectManeForSex(String sex) throws Exception {
        Feline feline = Mockito.mock(Feline.class);

        Lion lion = new Lion(sex, feline);

        if ("Самец".equals(sex)) {
            assertTrue(lion.doesHaveMane());
        } else {
            assertFalse(lion.doesHaveMane());
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 5, 10})
    void shouldReturnSpecifiedKittensCount(int count) {
        Feline feline = new Feline();

        assertEquals(count, feline.getKittens(count));
    }
}
