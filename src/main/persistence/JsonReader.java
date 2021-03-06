package persistence;

import model.Image;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import model.Line;
import org.json.*;

public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Image read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseImage(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses Image from JSON object and returns it
    private Image parseImage(JSONObject jsonObject) {
        Image img = new Image();
        addLines(img, jsonObject);
        return img;
    }

    // MODIFIES: wr
    // EFFECTS: parses thingies from JSON object and adds them to workroom
    private void addLines(Image img, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("lines");
        for (Object json : jsonArray) {
            JSONObject nextLine = (JSONObject) json;
            addLine(img, nextLine);
        }
    }

    // MODIFIES: wr
    // EFFECTS: parses thingy from JSON object and adds it to workroom
    private void addLine(Image img, JSONObject jsonObject) {
        String colour = jsonObject.getString("colour");
        int width = jsonObject.getInt("width");
        String start = jsonObject.getString("start");
        String end = jsonObject.getString("end");
        Line line = new Line(colour,width,start,end);
        img.addLine(line);
    }
}
