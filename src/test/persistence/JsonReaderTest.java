package persistence;

import model.Image;
import model.Line;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Image img = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyImage() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyImage.json");
        try {
            Image img = reader.read();
            ArrayList<Line> emptyListOfLines = new ArrayList<Line>();
            assertEquals(emptyListOfLines, img.getLines());
            assertEquals(0, img.howManyLines());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralImage() {

        JsonReader reader = new JsonReader("./data/testReaderGeneralImage.json");
        Line line = new Line("green", 10, "(10,10)", "(10,10)");
        try {
            Image img = reader.read();
            assertEquals(1, img.getLines().size());
            assertEquals("green", img.getLines().get(0).getLineColour());
            assertEquals(10, img.getLines().get(0).getLineWidth());
            assertEquals("(10,10)", img.getLines().get(0).getLineStart());
            assertEquals("(10,10)", img.getLines().get(0).getLineEnd());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
