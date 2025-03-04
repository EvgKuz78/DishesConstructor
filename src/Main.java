import java.util.ArrayList;
import  java.util.Random;
import java.util.Scanner;
public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;
    static Random random;
    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);
        random = new Random();

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    System.out.println("Выход из приложенения!");
                    return;
                default:
                    System.out.println("Такой команды нет!");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        if(dc.checkType(dishType)) {
            dc.addNewDish(dishType,dishName);
        } else {
            dc.addNewType(dishType);
            dc.addNewDish(dishType,dishName);
        }
        System.out.println(dc.dishesList);
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");
        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = Integer.parseInt(scanner.nextLine());

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");

        ArrayList<String> dishType = new ArrayList<>();//реализуйте ввод типов блюд
        while (true) {
            String nextItem = scanner.nextLine();
            if (nextItem.isEmpty()) {
                break;
            } else {
                if (!dc.checkType(nextItem)) {
                    System.out.println("Такого типа нет");
                } else {
                    dishType.add(nextItem); // добавление типа в массив типов блюд
                }
            }
            if (dishType.isEmpty()) {
                System.out.println("Тип блюда не выбран");
            } else {
                continue;
            }
        }
        for (int i = 0; i < numberOfCombos; i++) {
            System.out.println("Для набора Комбо №" + (i + 1) + " предлагаются следующие блюда:");
            for (int j = 0; j < dishType.size(); j++) {
                String type = dishType.get(j);
                int bound = dc.dishesList.get(type).size(); // получение размера категорий блюд из хэш-таблицы меню
                int chooseId = random.nextInt(bound); // получение рандомного числа в заданном диапазоне
                String dish = dc.dishesList.get(type).get(chooseId);
                System.out.print(dish + " ");
            }
            System.out.println();
        }

        // сгенерируйте комбинации блюд и выведите на экран

    }
}
