import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DesignaFoodRatingSystem{


    static Map<String, String> foodCuisineMap = new HashMap<>();
    static Map<String, TreeMap<String, Integer>> cuisineRatingMap = new HashMap<>();

    public DesignaFoodRatingSystem(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            foodCuisineMap.put(foods[i], cuisines[i]);
            cuisineRatingMap.putIfAbsent(cuisines[i], new TreeMap<>());
            cuisineRatingMap.get(cuisines[i]).put(foods[i], ratings[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        if(!foodCuisineMap.containsKey(food)) return;
        String cuisine = foodCuisineMap.get(food);
        cuisineRatingMap.get(cuisine).remove(food);
        cuisineRatingMap.get(cuisine).put(food, newRating);
    }

    public String highestRated(String cuisine) {
        if(!cuisineRatingMap.containsKey(cuisine)) return "";
        TreeMap<String, Integer> foodRatings = cuisineRatingMap.get(cuisine);
        int maxRating = Integer.MIN_VALUE;
        String result = "";
        for(Map.Entry<String, Integer> entry : foodRatings.entrySet()) {
            if(entry.getValue() > maxRating) {
                maxRating = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String[] food = {"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"};
        String[] cuisines = {"korean", "japanese", "japanese", "greek", "japanese", "korean"};
        int[] ratings = {9, 12, 8, 15, 14, 7};

        DesignaFoodRatingSystem obj = new DesignaFoodRatingSystem(food, cuisines, ratings);
        System.out.println(obj.highestRated("korean")); // Output: "kimchi"
        System.out.println(obj.highestRated("japanese")); // Output: "ramen"
        obj.changeRating("sushi", 16);
        System.out.println(obj.highestRated("japanese")); // Output: "sushi"

    }
}