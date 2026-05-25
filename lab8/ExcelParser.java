package lab8;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelParser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean success = false;
        
        while (!success) {
            try {
                System.out.print("Введите путь к Excel файлу: ");
                String filePath = scanner.nextLine();
                
                System.out.print("Введите имя листа (Enter для Лист1): ");
                String sheetName = scanner.nextLine();
                if (sheetName.isEmpty()) {
                    sheetName = "Лист1";
                }
                
                readExcelFile(filePath, sheetName);
                success = true;
                
            } catch (IOException e) {
                System.err.println("ОШИБКА: Файл не найден или недоступен.");
                System.err.println("Рекомендация: Проверьте путь к файлу и убедитесь, что файл существует.");
                System.err.println("Детали: " + e.getMessage());
                
                System.out.print("Попробовать снова? (да/нет): ");
                if (!scanner.nextLine().equalsIgnoreCase("да")) {
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.err.println("ОШИБКА: " + e.getMessage());
                System.err.println("Рекомендация: Проверьте имя листа - оно должно точно совпадать.");
                
                System.out.print("Попробовать снова? (да/нет): ");
                if (!scanner.nextLine().equalsIgnoreCase("да")) {
                    break;
                }
            } catch (Exception e) {
                System.err.println("НЕИЗВЕСТНАЯ ОШИБКА: " + e.getMessage());
                System.err.println("Рекомендация: Проверьте формат файла (должен быть .xlsx)");
                break;
            }
        }
        
        scanner.close();
    }
    
    public static void readExcelFile(String filePath, String sheetName) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {
            
            Sheet sheet = workbook.getSheet(sheetName);
            
            if (sheet == null) {
                throw new IllegalArgumentException("Лист '" + sheetName + "' не найден. Доступные листы: " + 
                    String.join(", ", workbook.getSheetName(0), workbook.getSheetName(1)));
            }
            
            System.out.println("\n=== Содержимое листа '" + sheetName + "' ===\n");
            
            for (Row row : sheet) {
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        default:
                            System.out.print(cell.toString() + "\t");
                    }
                }
                System.out.println();
            }
        }
    }
}