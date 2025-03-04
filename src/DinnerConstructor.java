
import java.util.ArrayList;
import java.util.HashMap;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishesList;
    //ArrayList<String> dishNames = new ArrayList<>();
    DinnerConstructor() {
        dishesList = new HashMap<>();
    }
    void addNewType(String dishType) {
        ArrayList<String> dishNames = new ArrayList<>();
        dishesList.put(dishType,dishNames);
    }
    void addNewDish(String dishType, String dishName) {
        ArrayList<String> dishNames = dishesList.get(dishType);
        dishNames.add(dishName);
    }
    boolean checkType(String dishType) {
        dishesList.containsKey(dishType);
        return true;
    }
}
