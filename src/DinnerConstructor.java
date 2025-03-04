
import java.util.ArrayList;
import java.util.HashMap;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishesList;

    //ArrayList<String> dishNames = new ArrayList<>();
    DinnerConstructor() {
        dishesList = new HashMap<>();
    }

    void addNewDish(String dishType, String dishName) {
        if (dishesList.containsKey(dishType)) {
            ArrayList<String> dishNames = dishesList.get(dishType);
            dishNames.add(dishName);
        } else {
            ArrayList<String> dishNames = dishesList.get(dishType);
            dishesList.put(dishType,  dishNames.add(dishName));
        }
        System.out.println(dishesList);
    }
    boolean checkType(String dishType) {
        return dishesList.containsKey(dishType);
    }
}
