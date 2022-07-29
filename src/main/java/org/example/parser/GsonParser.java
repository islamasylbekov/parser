package org.example.parser;

import org.example.models.json.JsomModel;
import org.example.parser.impl.GsonParserImpl;

import java.util.List;
import java.util.Map;

public interface GsonParser {

     GsonParserImpl INSTANCE = new GsonParserImpl();

     List<JsomModel> parse(Map<String, String> path);

}
