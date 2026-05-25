package lab8;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HTMLParser {
    private static final String URL = "https://urfu.ru/ru/news/";
    private static final String FILE_PATH = "lab8/news_data.txt";

    public static void main(String[] args) {
        List<String> newsData = fetchNewsWithRetry(3);
        if (newsData != null) {
            writeToFile(newsData);
            System.out.println("Данные успешно записаны в файл.");
        } else {
            System.out.println("Не удалось получить данные после нескольких попыток.");
        }
    }

    private static List<String> fetchNewsWithRetry(int maxRetries) {
        int attempts = 0;
        while (attempts < maxRetries) {
            try {
                System.out.println("Попытка подключения... (" + (attempts + 1) + ")");
                Document doc = Jsoup.connect(URL).get();
                return parseNews(doc);
            } catch (IOException e) {
                attempts++;
                System.out.println("Ошибка подключения: " + e.getMessage());
                if (attempts >= maxRetries) {
                    System.out.println("Превышено количество попыток подключения.");
                    return null;
                }
                try { Thread.sleep(2000); } catch (InterruptedException ie) {}
            }
        }
        return null;
    }

    private static List<String> parseNews(Document doc) {
        List<String> news = new ArrayList<>();
        // Ищем все ссылки на странице
        Elements links = doc.select("a[href*='/news/']"); 

        for (Element link : links) {
            String title = link.text().trim();
            String href = link.absUrl("href"); // Получаем полный URL
            if (!title.isEmpty()) { // Исключаем пустые заголовки
                news.add("Тема: " + title + "\nСсылка: " + href + "\n");
            }
        }
        return news;
    }

    private static void writeToFile(List<String> newsData) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            for (String news : newsData) {
                writer.write(news + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}