package model;

public class Line {
    private final int lineWidth;
    private final String lineColour;
    private final String lineStart;
    private final String lineEnd;

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
}
