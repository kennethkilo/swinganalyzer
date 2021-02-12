package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Image {
    static ArrayList<Lines> lines;
    //name of image to tell the images apart

    // EFFECTS: Initializes the Image with an empty list of Lines
    public Image() {
        lines = new ArrayList<>();

    }

    // getter
    public ArrayList<Lines> getLines() {
        return this.lines;
    }

    // setter
    public void setLines(ArrayList<Lines> setLines) {
        this.lines = setLines;
    }

    // EFFECTS: Return true if the Image has no Lines on it
    public boolean emptyImage() {
        if (lines.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    // EFFECTS: Returns how many Lines there are
    public String howManyLines() {
        int lineCount = this.lines.size();
        return "There are " + String.valueOf(lineCount) + " lines on the drawing";
    }

    //MODIFIES: this
    //EFFECTS: Removes all lines on Image
    public Image clearLines() {
        this.lines = new ArrayList<>();
        return this;
    }

    //REQUIRES: non-empty Image
    //MODIFIES: this
    //EFFECTS: Removes Line specified in array
    public Image deleteSpecificLine(int lineIndex) {
        this.lines.remove(lineIndex);
        return this;
    }

    //REQUIRES: non-empty Image
    //MODIFIES: this
    //EFFECTS: Removes the last Line
    public Image deleteLastLine() {
        this.lines.remove(this.lines.size() - 1);
        return this;
    }

    //MODIFIES:this
    //EFFECTS: Adds the line to the image
    public Image addLine(Lines lineToAdd) {
        this.lines.add(lineToAdd);
        return this;
    }
}
