package ZoomAnimals;

public class Elephant extends Walker {

    public Elephant(String name, double weight, int gender, 
                    double runningSpeed, double tailLength) {
        super(name, weight, gender, runningSpeed, tailLength);
    }

    // Copy constructor
    public Elephant(Elephant other) {
        super(other.name, other.weight, other.gender, 
              other.getRunningSpeed(), other.getTailLength());
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void converse() {
        System.out.println("WUOOOOOOO");
    }

    @Override
    public String toString() {
        return "Elephant{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", gender=" + (gender == 0 ? "male" : "female") +
                ", runningSpeed=" + getRunningSpeed() +
                ", tailLength=" + getTailLength() +
                '}';
    }
}
