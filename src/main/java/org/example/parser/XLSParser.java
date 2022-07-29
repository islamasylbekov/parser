package org.example.parser;

import org.example.models.xls.XLSModel;
import org.example.parser.impl.XLSParserImpl;

import java.util.List;

public interface XLSParser {

    XLSParser INSTANCE = new XLSParserImpl();

    List<XLSModel> parse(String path);
}
