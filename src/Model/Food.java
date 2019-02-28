package Model;

public class Food {

    private String name;
    private int kcals;
    private int protein;
    private int carbs;
    private int fat;
    private int sugar;

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
