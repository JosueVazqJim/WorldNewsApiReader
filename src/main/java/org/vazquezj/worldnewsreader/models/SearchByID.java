package org.vazquezj.worldnewsreader.models;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record SearchByID(@JsonAlias("news" )List<NewItem> news) {
}
