package org.vazquezj.worldnewsreader.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) //ignoramos los atributos que no se encuentren en la clase


public record NewItem(@JsonAlias("id") Integer id,
                      @JsonAlias("title") String title,
                      @JsonAlias("summary") String summary,
                      @JsonAlias("url") String url,
                      @JsonAlias("authors") String[] authors,
                      @JsonAlias("image") String image,
                      @JsonAlias("sentiment") Double sentiment, // Sentiment es opcional
                      @JsonAlias("publish_date") String date){
}
