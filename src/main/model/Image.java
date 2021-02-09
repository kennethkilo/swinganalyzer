package model;

import java.util.ArrayList;
import java.util.List;

public class Image {
    private ArrayList<Lines> lines;

    // EFFECTS: Initializes the Image with an empty list of Lines
    public Image() {
        lines = new ArrayList<Lines>();

    }

    // getter


    // setter


    // EFFECTS: Return true if the Image has no Lines on it


    // EFFECTS: Returns how many Lines there are on the drawing and their coordinates


    //MODIFIES: this
    //EFFECTS: Removes all lines on Image


    //REQUIRES: non-empty Image
    //MODIFIES: this
    //EFFECTS: Removes the last Line or Line specified in array
}
