package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinesTest {
    private Lines testLines;

    @Test
    void testConstructor() {
        Lines testLine = new Lines("Green", 10, "(0,0)", "(10,10)");
        assertEquals("Green", testLine.lineColour);
        assertEquals(10, testLine.lineWidth);
        assertEquals("(0,0)", testLine.lineStart);
        assertEquals("(10,10)", testLine.lineEnd);


    }


}
