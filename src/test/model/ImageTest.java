package model;

import exceptions.EmptyImageException;
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
    void testHowManyLinesText() {
        assertEquals("There are 0 lines on the drawing",testImage.howManyLinesText());
        testImage.addLine(
                new Line("Green", 10, "(0,0)","(10,10)"));
        assertEquals("There are 1 lines on the drawing",testImage.howManyLinesText());
        testImage.addLine(
                new Line("Green", 10, "(0,0)","(10,10)"));
        assertEquals("There are 2 lines on the drawing",testImage.howManyLinesText());
    }

    @Test
    void testHowManyLines() {
        assertEquals(0,testImage.howManyLines());
        testImage.addLine(
                new Line("Green", 10, "(0,0)","(10,10)"));
        assertEquals(1,testImage.howManyLines());
        testImage.addLine(
                new Line("Green", 10, "(0,0)","(10,10)"));
        assertEquals(2,testImage.howManyLines());
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

    // PHASE 4 TASK 2 METHOD 1
    @Test
    void testDeleteSpecificLine() {
        testImage.addLine(
                new Line("Green", 10, "(0,0)","(10,10)"));
        try {
            testImage.deleteSpecificLine(0);
        } catch (EmptyImageException e) {
            fail("shouldn't have thrown this exception");
        }
        assertTrue(testImage.getLines().isEmpty());
        testImage.addLine(
                new Line("Green", 10, "(0,0)","(10,10)"));
        testImage.addLine(
                new Line("Red", 10, "(0,0)","(10,10)"));
        try {
            testImage.deleteSpecificLine(1);
        } catch (EmptyImageException e) {
            fail("shouldn't have thrown this exception");
        }
        assertFalse(testImage.getLines().isEmpty());
        try {
            testImage.deleteSpecificLine(0);
        } catch (EmptyImageException e) {
            fail("shouldn't have thrown this exception");
        }
        assertTrue(testImage.getLines().isEmpty());
        try {
            testImage.deleteSpecificLine(0);
            fail("Should have caught the EmptyImageException!"); //THIS IS THE CASE WHERE IT SHOULD HAVE BEEN CAUGHT
        } catch (EmptyImageException e) {
        }
        testImage.addLine(
                new Line("Red", 10, "(0,0)","(10,10)"));
        try {
            testImage.deleteSpecificLine(5);
            fail("shouldn't have thrown this exception"); //THIS IS THE CASE WHERE IT SHOULD HAVE BEEN CAUGHT
        } catch (EmptyImageException e) {
        }

        assertEquals(1,testImage.getLines().size());
    }

    // PHASE 4 TASK 2 METHOD 2
    @Test
    void testDeleteLastLine() {
        testImage.addLine(
                new Line("Green", 10, "(0,0)","(10,10)"));
        testImage.addLine(
                new Line("Red", 10, "(0,0)","(10,10)"));

        try {
            testImage.deleteLastLine();
        } catch (EmptyImageException e) {
            fail("shouldn't have thrown this exception");
        }
        assertEquals(1, testImage.getLines().size());
        try {
            testImage.deleteLastLine();
        } catch (EmptyImageException e) {
            fail("shouldn't have thrown this exception");
        }
        assertEquals(0, testImage.getLines().size());
        try {
            testImage.deleteLastLine();
            fail("Should have caught the EmptyImageException!"); //THIS IS THE CASE WHERE IT SHOULD HAVE BEEN CAUGHT
        } catch (EmptyImageException e) {
        }

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
