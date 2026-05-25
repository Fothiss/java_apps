package lab8;

import java.io.FileWriter;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ShoppingListJSON {
    private static final String FILE_PATH = "lab8/shopping_list.json";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Показать список покупок");
            System.out.println("2. Добавить продукт");
            System.out.println("3. Поиск по названию");
            System.out.println("4. Удалить продукт");
            System.out.println("5. Выход");
            System.out.print("Выберите действие: ");
            
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> displayShoppingList();
                case 2 -> addProduct(scanner);
                case 3 -> searchByProductName(scanner);
                case 4 -> deleteProduct(scanner);
                case 5 -> System.out.println("Выход...");
                default -> System.out.println("Неверный выбор");
            }
        } while (choice != 5);
    }

    @SuppressWarnings("unchecked")
    private static void displayShoppingList() {
        try {
            JSONArray products = loadProducts();
            System.out.println("\nСписок покупок:");
            for (Object obj : products) {
                JSONObject product = (JSONObject) obj;
                System.out.println("- " + product.get("name") + ": " + 
                        product.get("quantity") + " " + product.get("unit"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private static void addProduct(Scanner scanner) {
        try {
            JSONArray products = loadProducts();
            JSONObject product = new JSONObject();
            
            System.out.print("Введите название продукта: ");
            product.put("name", scanner.nextLine());
            
            System.out.print("Введите количество: ");
            product.put("quantity", scanner.nextLine());
            
            System.out.print("Введите единицу измерения: ");
            product.put("unit", scanner.nextLine());
            
            products.add(product);
            saveProducts(products);
            System.out.println("Продукт добавлен!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void searchByProductName(Scanner scanner) {
        try {
            JSONArray products = loadProducts();
            System.out.print("Введите название продукта для поиска: ");
            String searchName = scanner.nextLine().toLowerCase();
            
            System.out.println("\nНайденные продукты:");
            boolean found = false;
            for (Object obj : products) {
                JSONObject product = (JSONObject) obj;
                String name = ((String) product.get("name")).toLowerCase();
                
                if (name.contains(searchName)) {
                    System.out.println("- " + product.get("name") + ": " + 
                            product.get("quantity") + " " + product.get("unit"));
                    found = true;
                }
            }
            if (!found) System.out.println("Продукты не найдены.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private static void deleteProduct(Scanner scanner) {
        try {
            JSONArray products = loadProducts();
            System.out.print("Введите название продукта для удаления: ");
            String deleteName = scanner.nextLine();
            
            Iterator iterator = products.iterator();
            boolean removed = false;
            while (iterator.hasNext()) {
                JSONObject product = (JSONObject) iterator.next();
                if (deleteName.equals(product.get("name"))) {
                    iterator.remove();
                    removed = true;
                    break;
                }
            }
            
            if (removed) {
                saveProducts(products);
                System.out.println("Продукт удален!");
            } else {
                System.out.println("Продукт не найден.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static JSONArray loadProducts() throws Exception {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(FILE_PATH));
            JSONObject jsonObject = (JSONObject) obj;
            return (JSONArray) jsonObject.get("products");
        } catch (Exception e) {
            JSONArray array = new JSONArray();
            JSONObject wrapper = new JSONObject();
            wrapper.put("products", array);
            saveToFile(wrapper);
            return array;
        }
    }

    private static void saveProducts(JSONArray products) throws Exception {
        JSONObject wrapper = new JSONObject();
        wrapper.put("products", products);
        saveToFile(wrapper);
    }

    private static void saveToFile(JSONObject jsonObject) throws Exception {
        try (FileWriter file = new FileWriter(FILE_PATH)) {
            file.write(jsonObject.toJSONString());
        }
    }
}
