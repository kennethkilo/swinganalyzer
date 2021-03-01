package persistence;

import org.json.JSONObject;

public interface Writable {
    //Taken from JsonSerializationDemo CPSC210 demo code
    //EFFECTS: returns this as JSON object
    JSONObject toJson();
}
