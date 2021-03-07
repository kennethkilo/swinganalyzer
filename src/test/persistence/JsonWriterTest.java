package persistence;

import model.Image;
import model.Line;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest {
    @Test
    void testWriterInvalidFile() {
        try {
            Image img = new Image();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyImage() {
        try {
            Image img = new Image();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyImage.json");
            writer.open();
            writer.write(img);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyImage.json");
            img = reader.read();
            assertEquals(0, img.howManyLines());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralImage() {
        try {
            Image img = new Image();
            img.addLine(new Line("green", 10, "(10,10)", "(10,10)"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralImage.json");
            writer.open();
            writer.write(img);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralImage.json");
            img = reader.read();
            assertEquals(1, img.howManyLines());
            assertEquals("green", img.getLines().get(0).getLineColour());
            assertEquals(10, img.getLines().get(0).getLineWidth());
            assertEquals("(10,10)", img.getLines().get(0).getLineStart());
            assertEquals("(10,10)", img.getLines().get(0).getLineEnd());


        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
