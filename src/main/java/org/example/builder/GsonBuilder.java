package org.example.builder;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class GsonBuilder {

    private static Gson gson;


    private GsonBuilder() {
    }

    public static synchronized Gson getGetGson() {
        if (gson == null) {
             gson  = new com.google.gson.GsonBuilder().registerTypeAdapter(LocalDate.class, (JsonDeserializer<LocalDate>) (json, type, jsonDeserializationContext) -> {
                try{
                    return LocalDate.parse(json.getAsJsonPrimitive().getAsString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                } catch (DateTimeParseException e){
                    return LocalDate.parse(json.getAsJsonPrimitive().getAsString(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS"));
                }

            }).create();
        }
        return gson;
    }


}
