package fr.umlv.javainside;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTest {
    Point point;

    @Test
    public void shouldGetPointWithXCorrect(){
        point = new Point(3, 5);
        assertEquals(3, point.x());
    }

    @Test
    public void shouldGetPointWithYCorrect(){
        point = new Point(3, 5);
        assertEquals(5, point.y());
    }
}
