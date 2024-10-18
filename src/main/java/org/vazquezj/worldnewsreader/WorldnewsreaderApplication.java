package org.vazquezj.worldnewsreader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.vazquezj.worldnewsreader.main.NewsMenu;
import org.vazquezj.worldnewsreader.service.ConnectionAPI;

@SpringBootApplication
public class WorldnewsreaderApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WorldnewsreaderApplication.class, args);
	}

	@Override
	public void run(String... args) {
		ConnectionAPI connectionAPI = new ConnectionAPI();
		NewsMenu newsMenu = new NewsMenu(connectionAPI);
		newsMenu.showMenu();

	}
}
