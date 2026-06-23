package ZoomAnimals;

public class Snake extends Reptile {
    public Snake(String name, double weight, int gender, double length) {
        super(name, weight, gender, length);
    }
    
    public Snake(Snake other) {
        super(other);
    }
    
    @Override
    public void converse() {
        System.out.println("Tssssssss");
    }
}