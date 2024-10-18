package org.vazquezj.worldnewsreader.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class New {
    private int id;
    private String summary;
    private String url;
    private String image;
    private String[] authors;
    private LocalDateTime releaseDate;
    private double sentiment;

    public New(NewItem newItem) {
        this.id = newItem.id();
        this.summary = newItem.summary();
        this.url = newItem.url();
        this.image = newItem.image();
        this.authors = newItem.authors();
        try {
            this.releaseDate = LocalDateTime.parse(newItem.date(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        } catch (Exception e) {
            this.releaseDate = LocalDateTime.now();
        }
        try {
            this.sentiment = newItem.sentiment();
        } catch (NumberFormatException e) {
            this.sentiment = 0.0;
        }
    }

    public double getSentiment() {
        return sentiment;
    }

    @Override
    public String toString() {
        return "===========Details of the new: ==================" +
                "\nId: " + id +
                "\nSummary: " + summary +
                "\nUrl: " + url +
                "\nImage: " + image +
                "\nAuthors: " + Arrays.toString(authors) +
                "\nSentiment: " + sentiment +
                "\nRelease Date: " + releaseDate + "\n";
    }
}
