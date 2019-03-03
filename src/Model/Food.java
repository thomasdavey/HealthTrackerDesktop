package Model;

public class Food {

    private String name;
    private int kcals;
    private int protein;
    private int carbs;
    private int fat;

    public Food(String name, int kcals, int protein, int carbs, int fat){
        this.name = name;
        this.kcals = kcals;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKcals() {

        return kcals;
    }

    public void setKcals(int kcals) {
        this.kcals = kcals;
    }

    public int getProtein() {

        return protein;
    }


    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getCarbs() {

        return carbs;
    }

    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }


    public int getFat() {

        return fat;
    }


    public void setFat(int fat) {
        this.fat = fat;
    }

    @Override
    public String toString(){

        return name;
    }
}
