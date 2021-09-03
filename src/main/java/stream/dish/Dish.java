package stream.dish;

public class Dish {
    private String name;
    private boolean vegetarian;
    private int calories;
    private String type;

    public Dish() {}

    public Dish(String name, boolean vegeterian, int calories, String type) {
        this.name = name;
        this.vegetarian = vegeterian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", vegeterian=" + vegetarian +
                ", calories=" + calories +
                ", type='" + type + '\'' +
                '}';
    }
}
