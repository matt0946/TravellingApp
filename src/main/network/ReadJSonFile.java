package network;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

// reference: https://www.youtube.com/watch?v=6IGl4Tf2VVI
// URL: https://api.exchangerate-api.com/v4/latest/CAD

public class ReadJSonFile {
    public static JSONArray rates;

    // MODIFIES: o, rates
    // EFFECTS: reads from the JSON file and adds appropriate values to the rates list
    public void readJSonFile() {
        String first = "./lib/CAD.json";
        try {
            String contents = new String((Files.readAllBytes(Paths.get(first))));
            JSONObject o = new JSONObject(contents);
            String base = "CAD";
            String timeLastUpdated = "1573603805";
            System.out.println("Base is: " + base + "\n");
            System.out.println("Time last updated is: " + timeLastUpdated + "\n");

            System.out.println("Current exchange rates from " + base + ":");
            rates = o.getJSONArray("rates");
            for (int i = 0; i < rates.length(); i++) {
                System.out.println(" " + rates.get(i));
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ReadJSonFile readJSonFile = new ReadJSonFile();
        readJSonFile.readJSonFile();
    }
}
