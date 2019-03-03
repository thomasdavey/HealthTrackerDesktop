package Model;

public class Food {

    private String name;
    private int kcals;
    private int protein;
    private int carbs;
    private int fat;
    private int sugar;

    public Food(String name, int kcals, int protein, int carbs, int fat, int sugar){
        this.name = name;
        this.kcals = kcals;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
        this.sugar = sugar;
    }

    public String getName() {
        return name;
    }

    public int getKcals() {
        return kcals;
    }

    public int getProtein() {
        return protein;
    }

    public int getCarbs() {
        return carbs;
    }

    public int getFat() {
        return fat;
    }

    public int getSugar() {
        return sugar;
    }

    @Override
    public String toString(){
        return name;
    }
}
