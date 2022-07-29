package org.example.reader.impl;

import org.example.reader.JsonPackageReader;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class JsonPackageReaderImpl implements JsonPackageReader {
    @Override
    public Map<String, String> read(String packages) {
        Map<String,String> jsons = new HashMap<>();
        try{
            File file = new File(packages);
            for (File i: Objects.requireNonNull(file.listFiles())) {
                BufferedReader reader = new BufferedReader(new FileReader(i));
                String line = "";
                StringBuilder result = new StringBuilder();
                while ((line = reader.readLine()) != null){
                    result.append(line);
                }
                jsons.put(i.getName(), result.toString());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return jsons;
    }
}
