package org.vazquezj.worldnewsreader.main;

import org.vazquezj.worldnewsreader.models.New;
import org.vazquezj.worldnewsreader.models.NewItem;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stats {
    public static DoubleSummaryStatistics getBasicsStats(List<New> items) {
        DoubleSummaryStatistics stats = items.stream()
                .collect(Collectors.summarizingDouble(New::getSentiment));
        return stats;
    }

    public static Map<String, Double> distrition(List<New> items) {
        long sentimentMoinsZero = items.stream()
                .filter(i -> i.getSentiment() < 0)
                .count();

        long sentimentPlusZero = items.stream()
                .filter(i -> i.getSentiment() >= 0)
                .count();

        Map<String, Double> distribution = Map.of(
                "Negative", (double) sentimentMoinsZero,
                "Positive", (double) sentimentPlusZero
        );
        return distribution;
    }
}
