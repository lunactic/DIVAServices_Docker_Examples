package ch.unifr.diuf.diva;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.util.Optional;

/**
 * Created by Marcel Würsch on 02.10.2014.
 * Updated by Marcel Würsch on 13.02.2015
 */
public class DivaServicesJsonHelper {
    private static final Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    private static final JsonParser parser = new JsonParser();

    /**
     * Translates a Java Object to JSON using GSON
     * For a full reference of GSON see: https://sites.google.com/site/gson/
     *
     * @param values The object to translate
     * @return The JSON representation of the input object
     */
    public static String toJson(Object values) {
        if (values instanceof Optional) {
            return gson.toJson(((Optional) values).get());
        }
        return gson.toJson(values);
    }


    public static String createImageOutputJson(String base64) {
        JsonObject result = new JsonObject();
        result.add("output", new JsonArray());
        result.add("image", new JsonPrimitive(base64));
        return gson.toJson(result);
    }

    /**
     * Reads a File containing JSON information and returns it
     *
     * @param path Path to the JSON file
     * @return The parsed JSON as String
     */
    public static Optional<JsonElement> readJsonFile(String path) {

        JsonParser parser = new JsonParser();
        JsonReader reader = null;
        try {
            reader = new JsonReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
            JsonElement jsonElement = parser.parse(reader);
            reader.close();
            return Optional.of(jsonElement);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            //If the file cannot be found return an Optional.empty()
            return Optional.empty();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public static String parseJsonString(String input) {
        return toJson(parser.parse(input));
    }


}

