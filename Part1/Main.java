package Part1;
import Part2.GuiFrame;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        //int distance = inputInt("Enter the race distance between 10 and 25 :");
        Race race = new Race(22);
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
        /* 
        for (int i =0   ; i < 3; i++){
            race.startRace();
        }
 

        */


        new GuiFrame(horses);




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
                System.out.println("You entered: " + input);
                valid = true;
            } catch (Exception e) {
                System.out.println("You input MUST be an integer between 10 and 25: ");
                scanner.next(); 
            }
        }
        return input;
    }

}