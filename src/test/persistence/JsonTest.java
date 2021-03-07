package persistence;

import model.Line;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkLine(String colour, int width, String start, String end, Line line) {
        assertEquals(colour, line.getLineColour());
        assertEquals(width, line.getLineWidth());
        assertEquals(start, line.getLineStart());
        assertEquals(end, line.getLineEnd());
    }
}
