package ZoomAnimals;

public abstract class Walker extends Animal {
    private double runningSpeed;
    private double tailLength;

    public Walker(String name, double weight, int gender, 
                 double runningSpeed, double tailLength) {
        super(name, weight, gender);
        this.runningSpeed = Math.max(runningSpeed, 0);
        this.tailLength = Math.max(tailLength, 0);
    }

    // ✅ Copy constructor
    public Walker(Walker other) {
        super(other.name, other.weight, other.gender);
        this.runningSpeed = other.runningSpeed;
        this.tailLength = other.tailLength;
    }

    public double getRunningSpeed() { return runningSpeed; }
    public double getTailLength() { return tailLength; }

    @Override
    public void goOut() {
        System.out.println("out strolling");
    }
}
