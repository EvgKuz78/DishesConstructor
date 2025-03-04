import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishesList;
    Random random;

    DinnerConstructor() {
        dishesList = new HashMap<>();
        random = new Random();
    }

    ArrayList<ArrayList<String>> generateDishCombos(ArrayList<String> dishType, int numberOfCombos) {
        ArrayList<ArrayList<String>> dishCombos = new ArrayList<>();
        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> combo = new ArrayList<>();
            for (int j = 0; j < dishType.size(); j++) {
                String type = dishType.get(j);
                int bound = dishesList.get(type).size(); // получение размера категорий блюд из хэш-таблицы меню
                int chooseId = random.nextInt(bound); // получение рандомного числа в заданном диапазоне
                String dish = dishesList.get(type).get(chooseId);
                combo.add(dish);
            }
            dishCombos.add(combo);
        }
        return dishCombos;
    }

    void addNewDish(String dishType, String dishName) {
        if (dishesList.containsKey(dishType)) {
            ArrayList<String> dishNames = dishesList.get(dishType);
            dishNames.add(dishName);
        } else {
            ArrayList<String> dishNames = new ArrayList<>();
            dishNames.add(dishName);
            dishesList.put(dishType, dishNames);
        }
        System.out.println(dishesList);
    }

    boolean checkType(String dishType) {
        return dishesList.containsKey(dishType);
    }

}