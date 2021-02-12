import model.Line;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineTest {

    @Test
    void testConstructor() {
        Line testLine = new Line("Green", 10, "(0,0)", "(10,10)");
        assertEquals("Green", testLine.getLineColour());
        assertEquals(10, testLine.getLineWidth());
        assertEquals("(0,0)", testLine.getLineStart());
        assertEquals("(10,10)", testLine.getLineEnd());


    }


}
