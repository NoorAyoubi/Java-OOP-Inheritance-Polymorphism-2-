package ZoomAnimals;

import java.util.Arrays;

public class TheZoo {
    public static void main(String[] args) {
    	// 1. Creating a Zoo array with 10 different animals
        Animal[] zoo = new Animal[10];
        
        zoo[0] = new Elephant("Dumbo", 5000, 0, 25, 1.5);
        zoo[1] = new Deer("Bambi", 150, 1, 60, 0.3);
        zoo[2] = new Snake("Kaa", 15, 0, 4.5);
        zoo[3] = new Crocodile("Tick-Tock", 300, 0, 3.2);
        zoo[4] = new Elephant("Jumbo", 6000, 0, 20, 1.8);
        zoo[5] = new Deer("Faline", 130, 1, 55, 0.25);
        zoo[6] = new Snake("Nagini", 12, 1, 3.8);
        zoo[7] = new Crocodile("Snappy", 280, 0, 2.9);
        zoo[8] = new Elephant("Manny", 5500, 0, 22, 1.6);
        zoo[9] = new Deer("Thumper", 140, 0, 58, 0.28);

     // 2. Animal care
        for (Animal animal : zoo) {
            animal.goOut();
            animal.converse();
            animal.getBack();
            System.out.println();
        }

     // 3. Finding the heaviest animal
        Animal heaviest = zoo[0];
        for (Animal animal : zoo) {
            if (animal.getWeight() > heaviest.getWeight()) {
                heaviest = animal;
            }
        }
        System.out.println("The heaviest animal in the zoo:");
        System.out.println(heaviest);
        System.out.println();

     // 4. Create a ZooElephants array with 5 elephants
        Elephant[] zooElephants = new Elephant[5];
        zooElephants[0] = new Elephant("Ella", 4800, 1, 24, 1.4);
        zooElephants[1] = new Elephant("Oscar", 5200, 0, 23, 1.7);
        zooElephants[2] = new Elephant("Tiny", 7000, 0, 18, 2.0);
        zooElephants[3] = new Elephant("Mia", 4600, 1, 26, 1.3);
        zooElephants[4] = new Elephant("Leo", 5300, 0, 22, 1.6);

     // 5. Create a copy of the array - HooElephants (loop 1)
        Elephant[] hooElephants = new Elephant[5];
        for (int i = 0; i < zooElephants.length; i++) {
            hooElephants[i] = new Elephant(zooElephants[i]);
        }

     // 6. Adding the letter H to the elephant names in HooElephants (loop 2)
        for (int i = 0; i < hooElephants.length; i++) {
            String currentName = hooElephants[i].getName();
            hooElephants[i].setName("H" + currentName);
        }

     // 7. Printing the original array (loop 3)
        System.out.println("Original Zoo Elephants:");
        for (Elephant elephant : zooElephants) {
            System.out.println(elephant);
        }
        System.out.println();

     // 8. Printing the array with updated names (loop 4)
        System.out.println("Hoo Zoo Elephants with H names:");
        for (Elephant elephant : hooElephants) {
            System.out.println(elephant);
        }
    }
}