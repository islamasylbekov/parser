package org.example.parser.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import org.example.models.json.JsomModel;
import org.example.parser.GsonParser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GsonParserImpl implements GsonParser {
    @Override
    public List<JsomModel> parse(Map<String, String> path) {
        List<JsomModel> modelList = new ArrayList<>();
        path.keySet().forEach(x ->{
            Gson gson  = new GsonBuilder().registerTypeAdapter(LocalDate.class, (JsonDeserializer<LocalDate>) (json, type, jsonDeserializationContext) -> {
                try{
                    return LocalDate.parse(json.getAsJsonPrimitive().getAsString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                } catch (DateTimeParseException e){
                    return LocalDate.parse(json.getAsJsonPrimitive().getAsString(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS"));
                }

            }).create();
            JsomModel jsomModel = gson.fromJson(path.get(x), JsomModel.class);
            modelList.add(jsomModel);
        });
        return modelList;
    }
}
