import java.util.*;

class Food implements Comparable<Food> {
    public String foodName;
    public int foodRating;

    public Food(String name, int rating) {
        this.foodName = name;
        this.foodRating = rating;
    }

    @Override
    public int compareTo(Food other) {
        if (foodRating == other.foodRating) {
            return foodName.compareTo(other.foodName);
        }
        return -(foodRating - other.foodRating);
    }
}

class FoodRatings {
    private Map<String, Integer> foodRating;
    private Map<String, String> foodCuisine;
    public Map<String, PriorityQueue<Food>> cuisineFoodMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodRating = new HashMap<>();
        foodCuisine = new HashMap<>();
        cuisineFoodMap = new HashMap<>();
        for (int i = 0; i < foods.length; ++i) {
            foodRating.put(foods[i], ratings[i]);
            foodCuisine.put(foods[i], cuisines[i]);
            cuisineFoodMap.computeIfAbsent(cuisines[i], k -> new PriorityQueue<>()).add(
                    new Food(foods[i], ratings[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        foodRating.put(food, newRating);

        cuisineFoodMap.get(foodCuisine.get(food)).add(new Food(food, newRating));
    }

    public String highestRated(String cuisine) {
        Food highestRated = this.cuisineFoodMap.get(cuisine).peek();
        while (highestRated.foodRating != foodRating.get(highestRated.foodName)) {
            this.cuisineFoodMap.get(cuisine).poll();
            highestRated = this.cuisineFoodMap.get(cuisine).peek();
            
        }
        return highestRated.foodName;
    }
}

class Solution {
    public static void main(String[] args) {
        // FoodRatings foodRatings = new FoodRatings(
        // new String[] { "kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi" },
        // new String[] { "korean", "japanese", "japanese", "greek", "japanese",
        // "korean" },
        // new int[] { 9, 12, 8, 15, 14, 7 });

        // System.out.println(foodRatings.highestRated("korean"));
        // System.out.println(foodRatings.highestRated("japanese"));
        // foodRatings.changeRating("sushi", 16);
        // System.out.println(foodRatings.highestRated("japanese"));
        // foodRatings.changeRating("ramen", 16);
        // System.out.println(foodRatings.highestRated("japanese"));
        FoodRatings foodRatings = new FoodRatings(
                new String[] { "emgqdbo", "jmvfxjohq", "qnvseohnoe", "yhptazyko", "ocqmvmwjq" },
                new String[] { "snaxol", "snaxol", "snaxol", "fajbervsj", "fajbervsj" },
                new int[] { 2, 6, 18, 6, 5 });

        foodRatings.changeRating("qnvseohnoe", 11);
        System.out.println(foodRatings.highestRated("fajbervsj"));
        foodRatings.changeRating("emgqdbo", 3);
        foodRatings.changeRating("jmvfxjohq", 9);
        foodRatings.changeRating("emgqdbo", 14);
        System.out.println(foodRatings.highestRated("fajbervsj"));
        System.out.println(foodRatings.highestRated("snaxol"));
        printCuisineFoodMap(foodRatings.cuisineFoodMap);
    }

    public static void printCuisineFoodMap(Map<String, PriorityQueue<Food>> cuisineFoodMap) {
        System.out.println("Printing cuisineFoodMap:");
        for (Map.Entry<String, PriorityQueue<Food>> entry : cuisineFoodMap.entrySet()) {
            String cuisine = entry.getKey();
            PriorityQueue<Food> pq = entry.getValue();

            // Print the cuisine key
            System.out.println("Cuisine: " + cuisine);

            // Create a copy to print the elements in priority order without modifying the
            // original queue
            PriorityQueue<Food> copyPq = new PriorityQueue<>(pq);

            // Print all food items for the current cuisine in descending rating order
            while (!copyPq.isEmpty()) {
                Food food = copyPq.poll();
                System.out.println("  - " + food.foodName + " (Rating: " + food.foodRating + ")");
            }
            System.out.println(); // Add a newline for better formatting
        }
    }
}
