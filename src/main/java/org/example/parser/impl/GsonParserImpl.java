package org.example.parser.impl;

import org.example.builder.GsonBuilder;
import org.example.models.json.JsomModel;
import org.example.parser.GsonParser;

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
