package ZoomAnimals;

public abstract class Reptile extends Animal {
    private double length; // Total length (meters)

    // Ordinary builder
    public Reptile(String name, double weight, int gender, double length) {
        super(name, weight, gender);
        this.length = (length >= 0) ? length : 0;
    }

    // Copy Builder
    public Reptile(Reptile other) {
        super(other.getName(), other.getWeight(), other.getGender());
        this.length = other.length;
    }

    // Gutters and Streams
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if (length >= 0) {
            this.length = length;
        }
    }

    // Updated toString method
    @Override
    public String toString() {
        return super.toString() + ", Length: " + length + " m";
    }

    // Updated equals method
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof Reptile)) return false;
        Reptile other = (Reptile) obj;
        return Double.compare(this.length, other.length) == 0;
    }

 // Customized hashCode method
    @Override
    public int hashCode() {
        return super.hashCode() + Double.hashCode(length);
    }

 // The goOut method remains as it was
    @Override
    public void goOut() {
        System.out.println("out crawling");
    }
}
