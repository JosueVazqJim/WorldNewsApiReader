package org.vazquezj.worldnewsreader.main;

import org.vazquezj.worldnewsreader.models.New;
import org.vazquezj.worldnewsreader.models.SearchResponse;
import org.vazquezj.worldnewsreader.models.TopNewsResponse;
import org.vazquezj.worldnewsreader.service.ChangeData;
import org.vazquezj.worldnewsreader.service.ConnectionAPI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class NewsMenu {
    private final ConnectionAPI connectionAPI;
    private final ChangeData changeData = new ChangeData();

    public NewsMenu(ConnectionAPI connectionAPI) {
        this.connectionAPI = connectionAPI;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("==== Menú de Búsqueda de Noticias ====");
            System.out.println("1. Buscar noticias por palabras clave");
            System.out.println("2. Ver top news");
            System.out.println("3. Buscar noticia por ID");
            System.out.println("4. Estadísticas de noticias por fecha, categoría y país");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            option = scanner.nextInt();
            scanner.nextLine();  // Consumir nueva línea

            switch (option) {
                case 1:
                    searchByKeywords(scanner);
                    break;
                case 2:
                    displayTopNews(scanner);
                    break;
                case 3:
                    searchById(scanner);
                    break;
                case 4:
                    getStatsFromDateCategoryCountry(scanner);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (option != 0);
    }

    private void searchByKeywords(Scanner scanner) {
        System.out.println("==== Búsqueda de Noticias por Palabras Clave ====");
        String keywords;
        do {
            System.out.print("Ingrese las palabras clave: ");
            keywords = scanner.nextLine();

            if (keywords.split(" ").length >= 1) {
                break;
            } else {
                System.out.println("Por favor, ingrese al menos 3 palabras clave.");
            }
        } while (true);

        System.out.print("Ingrese el país (ej. US, MX) o ingrese 0 para omitir: ");
        var country = scanner.nextLine();

        System.out.print("Ingrese el idioma (ej. en, es) o ingrese 0 para omitir: ");
        var language = scanner.nextLine();

        System.out.print("Ingrese la fecha (YYYY-MM-DD) o ingrese 0 para omitir: ");
        var date = scanner.nextLine();

        if (language.equals("0")) {
            language = "en";
        }
        if (date.equals("0")) {
            LocalDate localDate = LocalDate.now();//For reference
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            date = localDate.format(formatter);;
        }
        if (country.equals("0")) {
            country = "us";
        }

        String jsonResponse = connectionAPI.getNewsByKeyWords(keywords, country, language, date);

        var data = changeData.changeData(jsonResponse, SearchResponse.class);

        List<New> lista = data.news().stream()
                .map(New::new)
                .toList();

        lista.forEach(System.out::println);
    }

    private void displayTopNews(Scanner scanner) {
        System.out.println("==== Top News ====");
        System.out.println("Ingrese el país (ej. US, MX) o ingrese 0 para omitir: ");
        var country = scanner.nextLine();

        System.out.println("Ingrese el idioma (ej. en, es) o ingrese 0 para omitir: ");
        var language = scanner.nextLine();

        if (language.equals("0")) {
            language = "en";
        }
        if (country.equals("0")) {
            country = "us";
        }
        // Aquí puedes implementar la lógica para mostrar las top news
        String jsonResponse = connectionAPI.topNews(country, language);

        var data = changeData.changeData(jsonResponse, TopNewsResponse.class);
		List<New> lista = data.top_news().stream()
				.limit(5)
				.flatMap(t -> t.news().stream())
				.limit(5)
				.map(newItem -> new New(newItem))
				.toList();

        lista.forEach(System.out::println);
    }

    private void searchById(Scanner scanner) {
        System.out.println("==== Búsqueda de Noticia por ID ====");
        System.out.print("Ingrese el ID de la noticia: ");
        String id = scanner.nextLine();

        String jsonResponse = connectionAPI.searchByID(id);
        var data = changeData.changeData(jsonResponse, SearchResponse.class);

        List<New> lista = data.news().stream()
                .map(New::new)
                .toList();

        lista.forEach(System.out::println);
    }

    public void getStatsFromDateCategoryCountry(Scanner scanner) {
        System.out.println("==== Estadísticas de Noticias ====");
        System.out.print("Ingrese la categoría (ej. politics, sports): ");
        var category = scanner.nextLine();

        System.out.print("Ingrese el país (ej. US, MX) o ingrese 0 para omitir: ");
        var country = scanner.nextLine();

        System.out.print("Ingrese la fecha (YYYY-MM-DD) o ingrese 0 para omitir: ");
        var date = scanner.nextLine();

        if (date.equals("0")) {
            LocalDate localDate = LocalDate.now();//For reference
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            date = localDate.format(formatter);;
        }
        if (country.equals("0")) {
            country = "us";
        }

        String jsonResponse = connectionAPI.searchByCategory(category, country, date);

        var data = changeData.changeData(jsonResponse, SearchResponse.class);

        List<New> lista = data.news().stream()
                .map(New::new)
                .toList();

        DoubleSummaryStatistics basicStats = Stats.getBasicsStats(lista);
        Map<String, Double> distribution = Stats.distrition(lista);

        System.out.println("===== Estadísticas Básicas =====");
        System.out.println("Sentimiento promedio: " + basicStats.getAverage());
        System.out.println("Sentimiento máximo: " + basicStats.getMax());
        System.out.println("Sentimiento mínimo: " + basicStats.getMin());

        System.out.println("===== Distribución de Sentimientos =====");
        distribution.forEach((k, v) -> System.out.println(k + ": " + v));


        lista.forEach(System.out::println);
    }
}
