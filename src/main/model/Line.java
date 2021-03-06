package model;

import org.json.JSONObject;
import persistence.Writable;

public class Line implements Writable {
    private final int lineWidth;
    private final String lineColour;
    private final String lineStart;
    private final String lineEnd;

    // EFFECTS: constructor to create a Line with colour, width, start and end positions
    public Line(String lineColour, int lineWidth, String lineStart, String lineEnd) {
        this.lineColour = lineColour;
        this.lineWidth = lineWidth;
        this.lineStart = lineStart;
        this.lineEnd = lineEnd;
    }

    //getters

    public int getLineWidth() {
        return this.lineWidth;
    }

    public String getLineColour() {
        return this.lineColour;
    }

    public String getLineStart() {
        return this.lineStart;
    }

    public String getLineEnd() {
        return this.lineEnd;
    }

    //setters
    //specifically did not add setters because each line should be immutable once made (can only delete/add entire line)

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("colour", lineColour);
        json.put("width", lineWidth);
        json.put("start", lineStart);
        json.put("end", lineEnd);
        return json;
    }
}
