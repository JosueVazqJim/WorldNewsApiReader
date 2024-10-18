package org.vazquezj.worldnewsreader.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true) //ignoramos los atributos que no se encuentren en la clase


public record TopNews(@JsonAlias("news") List<NewItem> news) {}
