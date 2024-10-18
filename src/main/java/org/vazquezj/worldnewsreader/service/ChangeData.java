package org.vazquezj.worldnewsreader.service;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ChangeData implements IChangeData{
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T changeData(String json, Class<T> newClass) {
        try {
            return objectMapper.readValue(json, newClass);
        } catch (Exception e) {
            throw new RuntimeException("Error converting JSON to object", e);
        }
    }
}