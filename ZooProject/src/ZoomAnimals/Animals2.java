package ZoomAnimals;

public class Animals2 {
    public static void main(String[] args) {
        Animal[] animals = {
            new Elephant("Dumbo", 5000, 0, 25, 1.5),
            new Deer("Bambi", 150, 1, 60, 0.3),
            new Snake("Kaa", 15, 0, 4.5),
            new Crocodile("Tick-Tock", 300, 0, 3.2)
        };

        for (Animal animal : animals) {
            System.out.println("--- " + animal.getName() + " ---");
            animal.goOut();
            animal.converse();
            animal.getBack();
            System.out.println();
        }
    }
}