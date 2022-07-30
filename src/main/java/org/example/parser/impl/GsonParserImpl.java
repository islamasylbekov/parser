package org.example.parser.impl;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import org.example.builder.GsonBuilder;
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

            JsomModel jsomModel = GsonBuilder.getGetGson().fromJson(path.get(x), JsomModel.class);
            modelList.add(jsomModel);
        });
        return modelList;
    }
}
