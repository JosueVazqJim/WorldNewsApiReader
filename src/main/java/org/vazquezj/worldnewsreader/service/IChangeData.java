package org.vazquezj.worldnewsreader.service;

public interface IChangeData {
    <T> T changeData(String json, Class<T> newClass);
}
