package utn.frba.losjavaleros.helpers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonHelper {

    public static String toJson(Object obj) {
        try {
            ObjectMapper jsonWriter = new ObjectMapper();
            return jsonWriter.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            return "{\"error\":\"" + e.getLocalizedMessage() + "\"}";
        }
    }

    public static Object parse(String json, TypeReference<?> typeRef) throws IOException {
        if (json == null)
            return null;
        ObjectMapper reader = new ObjectMapper();
        Object obj = reader.readValue(json, typeRef);
        return obj;
    }

    public static Object parse(String json) throws IOException {
        if (json == null)
            return null;
        ObjectMapper reader = new ObjectMapper();
        Object obj;
        try {
            obj = reader.readValue(json, Map.class);
        } catch (Exception e1) {
            try {
                obj = reader.readValue(json, List.class);
            } catch (Exception e2) {
                obj = reader.readValue(json, String.class);
            }
        }
        return obj;
    }

    public static Object parse(String json, Class clazz) throws IOException {
        if (json == null)
            return null;
        ObjectMapper reader = new ObjectMapper();
        Object obj  = reader.readValue(json, clazz);
        return obj;
    }
}