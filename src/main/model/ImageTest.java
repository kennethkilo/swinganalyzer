package model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ImageTest {
    private Image testImage;

    @BeforeEach
    void runBefore() {
        testImage = new Image();
    }

    @Test
    void testConstructor() {
        assertEquals(0,testImage.lines.size());

    }

    @Test
    void testEmptyImage() {
        assertTrue(testImage.emptyImage());
        testImage.addLine(
                new Lines("Green", 10, "(0,0)","(10,10)"));
        assertFalse(testImage.emptyImage());

    }

    @Test
    void testHowManyLines() {
        assertEquals("There are 0 lines on the drawing",testImage.howManyLines());
        testImage.addLine(
                new Lines("Green", 10, "(0,0)","(10,10)"));
        assertEquals("There are 1 lines on the drawing",testImage.howManyLines());
        testImage.addLine(
                new Lines("Green", 10, "(0,0)","(10,10)"));
        assertEquals("There are 2 lines on the drawing",testImage.howManyLines());
    }

    @Test
    void testClearLines() {
        testImage.clearLines();
        assertEquals(new ArrayList<Lines>(),testImage.lines);
        testImage.addLine(
                new Lines("Red", 10, "(0,0)","(10,10)"));
        testImage.addLine(
                new Lines("Green", 10, "(0,0)","(10,10)"));
        testImage.clearLines();
        assertEquals(new ArrayList<Lines>(),testImage.lines);
    }

    @Test
    void testDeleteSpecificLine() {
        testImage.addLine(
                new Lines("Green", 10, "(0,0)","(10,10)"));
        testImage.deleteSpecificLine(0);
        assertTrue(testImage.lines.isEmpty());
        testImage.addLine(
                new Lines("Green", 10, "(0,0)","(10,10)"));
        testImage.addLine(
                new Lines("Red", 10, "(0,0)","(10,10)"));
        testImage.deleteSpecificLine(1);
        assertFalse(testImage.lines.isEmpty());
        testImage.deleteSpecificLine(0);
        assertTrue(testImage.lines.isEmpty());
    }

}
