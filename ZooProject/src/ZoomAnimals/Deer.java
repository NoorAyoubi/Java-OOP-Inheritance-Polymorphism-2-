package ZoomAnimals;

public class Deer extends Walker {
    public Deer(String name, double weight, int gender, double runningSpeed, double tailLength) {
        super(name, weight, gender, runningSpeed, tailLength);
    }
    
    public Deer(Deer other) {
        super(other);
    }
    
    @Override
    public void converse() {
        System.out.println("Lailatilati");
    }
}