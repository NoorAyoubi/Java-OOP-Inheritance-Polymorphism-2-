package ZoomAnimals;

public class Crocodile extends Reptile {
    public Crocodile(String name, double weight, int gender, double length) {
        super(name, weight, gender, length);
    }
    
    public Crocodile(Crocodile other) {
        super(other);
    }
    
    @Override
    public void converse() {
        System.out.println("Whaaaaammmmmm");
    }
}