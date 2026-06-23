package ZoomAnimals;

public abstract class Animal {
    protected String name;
    protected double weight;
    protected int gender; // 0=male, 1=female

    public Animal(String name, double weight, int gender) {
        this.name = name;
        this.weight = Math.max(weight, 0);
        this.gender = (gender == 0 || gender == 1) ? gender : 0;
    }

    // Getters
    public String getName() { return name; }
    public double getWeight() { return weight; }
    public int getGender() { return gender; }

    // Abstract methods
    public abstract void goOut();
    public abstract void converse();
    
    public void getBack() {
        System.out.println(name + " is getting back.");
    }
}