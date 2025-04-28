package Part1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        int distance = inputInt("Enter the race distance between 10 and 25 :");
        Race race = new Race(distance);
        Horse horse = new Horse('■', "Opio", 0.5);
        Horse horse2 = new Horse('█', "Roach", 0.5);
        Horse horse3 = new Horse('░', "Pasta", 0.5);
        Horse horse4 = new Horse('░', "Khat", 0.5);
        Horse horse5 = new Horse('░', "Ty", 0.5);
        Horse[] horses = {horse, horse2, horse3, horse4, horse5};

        race.addHorse(horse, 1);
        race.addHorse(horse2, 2);
        race.addHorse(horse3, 3);
        race.addHorse(horse4, 4);
        race.addHorse(horse5, 5);

        int raceTime = inputInt("How many times do you want the race to run? (1-5) : ");
        if(raceTime < 1) {
            System.out.println("Number less than 1 is not allowed. Defaulting to 1.");
            raceTime = 1;
        }else if(raceTime > 5) {
            System.out.println("Number greater than 5 is not allowed. Setting to 5.");
            raceTime = 5;
        }

        for (int i =0; i < raceTime; i++){
            race.startRace();
        }
 



        /* 
        new GuiFrame(horses);

        */


        /* 
        GuiFrame gui = new GuiFrame();

        */



    }

    public static int inputInt(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        int input = 0;
        while (!valid) {
            try {
                input = scanner.nextInt();
                valid = true;
            } catch (Exception e) {
                System.out.println("You input MUST be an integer");
                scanner.next(); 
            }
        }
        return input;
    }

}