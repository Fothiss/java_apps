package lab8;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;

public class ShoppingListManager {
    private static final String FILE_PATH = "lab8/shopping.xml";

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

    private static void displayShoppingList() {
        try {
            Document doc = loadDocument();
            NodeList nodeList = doc.getElementsByTagName("product");
            
            System.out.println("\nСписок покупок:");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                System.out.println("- " + element.getElementsByTagName("name").item(0).getTextContent() +
                        ": " + element.getElementsByTagName("quantity").item(0).getTextContent() +
                        " " + element.getElementsByTagName("unit").item(0).getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addProduct(Scanner scanner) {
        try {
            Document doc = loadDocument();
            Element root = doc.getDocumentElement();
            
            Element product = doc.createElement("product");
            
            Element name = doc.createElement("name");
            System.out.print("Введите название продукта: ");
            name.appendChild(doc.createTextNode(scanner.nextLine()));
            product.appendChild(name);
            
            Element quantity = doc.createElement("quantity");
            System.out.print("Введите количество: ");
            quantity.appendChild(doc.createTextNode(scanner.nextLine()));
            product.appendChild(quantity);
            
            Element unit = doc.createElement("unit");
            System.out.print("Введите единицу измерения: ");
            unit.appendChild(doc.createTextNode(scanner.nextLine()));
            product.appendChild(unit);
            
            root.appendChild(product);
            saveDocument(doc);
            System.out.println("Продукт добавлен!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void searchByProductName(Scanner scanner) {
        try {
            Document doc = loadDocument();
            NodeList nodeList = doc.getElementsByTagName("product");
            
            System.out.print("Введите название продукта для поиска: ");
            String searchName = scanner.nextLine().toLowerCase();
            
            System.out.println("\nНайденные продукты:");
            boolean found = false;
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                String name = element.getElementsByTagName("name").item(0).getTextContent().toLowerCase();
                
                if (name.contains(searchName)) {
                    System.out.println("- " + element.getElementsByTagName("name").item(0).getTextContent() +
                            ": " + element.getElementsByTagName("quantity").item(0).getTextContent() +
                            " " + element.getElementsByTagName("unit").item(0).getTextContent());
                    found = true;
                }
            }
            if (!found) System.out.println("Продукты не найдены.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deleteProduct(Scanner scanner) {
        try {
            Document doc = loadDocument();
            NodeList nodeList = doc.getElementsByTagName("product");
            
            System.out.print("Введите название продукта для удаления: ");
            String deleteName = scanner.nextLine().toLowerCase();
            
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                String name = element.getElementsByTagName("name").item(0).getTextContent().toLowerCase();
                
                if (name.equals(deleteName)) {
                    element.getParentNode().removeChild(element);
                    saveDocument(doc);
                    System.out.println("Продукт удален!");
                    return;
                }
            }
            System.out.println("Продукт не найден.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Document loadDocument() throws Exception {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            createEmptyFile();
        }
        
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        doc.getDocumentElement().normalize();
        return doc;
    }

    private static void saveDocument(Document doc) throws Exception {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(javax.xml.transform.OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(javax.xml.transform.OutputKeys.STANDALONE, "yes");
        transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(FILE_PATH));
        transformer.transform(source, result);
    }

    private static void createEmptyFile() throws Exception {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();
        
        Element root = doc.createElement("shopping_list");
        doc.appendChild(root);
        
        saveDocument(doc);
    }
}