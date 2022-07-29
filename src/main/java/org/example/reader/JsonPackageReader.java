package org.example.reader;

import org.example.reader.impl.JsonPackageReaderImpl;

import java.util.Map;

public interface JsonPackageReader {

    JsonPackageReader INSTANCE = new JsonPackageReaderImpl();

    Map<String, String> read(String packages);

}
