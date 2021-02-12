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
        assertEquals(0,testImage.getLines().size());

    }

    @Test
    void testEmptyImage() {
        assertTrue(testImage.emptyImage());
        Line testLine1 = new Line("Green", 10, "(0,0)","(10,10)");
        ArrayList<Line> testLineArray = new ArrayList<>();
        testLineArray.add(testLine1);
        testImage.setLines(testLineArray);
        assertFalse(testImage.emptyImage());

    }

    @Test
    void testHowManyLines() {
        assertEquals("There are 0 lines on the drawing",testImage.howManyLines());
        testImage.addLine(
                new Line("Green", 10, "(0,0)","(10,10)"));
        assertEquals("There are 1 lines on the drawing",testImage.howManyLines());
        testImage.addLine(
                new Line("Green", 10, "(0,0)","(10,10)"));
        assertEquals("There are 2 lines on the drawing",testImage.howManyLines());
    }

    @Test
    void testClearLines() {
        testImage.clearLines();
        assertEquals(new ArrayList<Line>(),testImage.getLines());
        testImage.addLine(
                new Line("Red", 10, "(0,0)","(10,10)"));
        testImage.addLine(
                new Line("Green", 10, "(0,0)","(10,10)"));
        testImage.clearLines();
        assertEquals(new ArrayList<Line>(),testImage.getLines());
    }

    @Test
    void testDeleteSpecificLine() {
        testImage.addLine(
                new Line("Green", 10, "(0,0)","(10,10)"));
        testImage.deleteSpecificLine(0);
        assertTrue(testImage.getLines().isEmpty());
        testImage.addLine(
                new Line("Green", 10, "(0,0)","(10,10)"));
        testImage.addLine(
                new Line("Red", 10, "(0,0)","(10,10)"));
        testImage.deleteSpecificLine(1);
        assertFalse(testImage.getLines().isEmpty());
        testImage.deleteSpecificLine(0);
        assertTrue(testImage.getLines().isEmpty());
        testImage.addLine(
                new Line("Red", 10, "(0,0)","(10,10)"));
        testImage.deleteSpecificLine(5);
        assertEquals(1,testImage.getLines().size());
    }

    @Test
    void testDeleteLastLine() {
        testImage.addLine(
                new Line("Green", 10, "(0,0)","(10,10)"));
        testImage.addLine(
                new Line("Red", 10, "(0,0)","(10,10)"));
        testImage.deleteLastLine();
        assertEquals(1, testImage.getLines().size());
        testImage.deleteLastLine();
        assertEquals(0, testImage.getLines().size());

    }

    @Test
    void testAddLine() {
        testImage.addLine(
                new Line("Green", 10, "(0,0)","(10,10)"));
        assertEquals(1, testImage.getLines().size());
        testImage.addLine(
                new Line("Green", 10, "(0,0)","(10,10)"));
        assertEquals(2, testImage.getLines().size());
        testImage.addLine(
                new Line("Red", 10, "(0,0)","(10,10)"));
        assertEquals(3, testImage.getLines().size());

    }

}
