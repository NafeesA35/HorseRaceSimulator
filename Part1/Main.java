package Part1;
import Part2.Gui;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Ready horses for the GUI.
        Horse horse = new Horse('$', "Opio", 0.5);
        Horse horse2 = new Horse('%', "Roach", 0.5);
        Horse horse3 = new Horse('+', "Pasta", 0.5);
        Horse horse4 = new Horse('@', "Khat", 0.5);
        Horse horse5 = new Horse('#', "Ty", 0.5);
        Horse[] horses = {horse, horse2, horse3, horse4, horse5};

        System.out.println("Are you accessing the terminal version? (Y)/(Yes) . Please note that any other input will run the GUI version.");
        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine();
        if(response.toLowerCase().equals("y") || response.toLowerCase().equals("yes")){
            int distance = inputInt("Enter the race distance between 10 and 25 Inclusive" , 10, 25);
            Race race = new Race(distance);
            int numberOfHorses = inputInt("How many horses do you want to race? (2-5) : ", 2, 5);
            for (int i = 0; i < numberOfHorses; i++) {
                race.addHorse(horses[i], i + 1);
                horses[i].setName(inputString("Enter a name for the horse "));
                horses[i].setConfidence(inputDouble("A confidence value between > ", 0, 1));
            }
            int raceTime = inputInt("How many times do you want the race to run? (1-5) : ", 1, 5);
            for (int i =0; i < raceTime; i++){
                race.startRace();
            }
        }else{
            // Start the GUI version.
            Gui.startRaceGui(horses);
        }



    }

    public static int inputInt(String message, int min, int max) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        int input = 0;
        while (!valid) {
            try {
                input = scanner.nextInt();
                if (input < min || input > max) {
                    System.out.println("Input must be between " + min + " and " + max);
                } else {
                    valid = true;
                }
            } catch (Exception e) {
                System.out.println("You input MUST be an integer");
                scanner.next(); 
            }
        }
        return input;
    }

    public static double inputDouble(String message, double min, double max) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        double input = 0;
        while (!valid) {
            try {
                input = scanner.nextDouble();
                if (input <= min || input >= max) {
                    System.out.println("Input must be between " + min + " and " + max);
                } else {
                    valid = true;
                }
            } catch (Exception e) {
                System.out.println("You input MUST be a number");
                scanner.next(); 
            }
        }
        return input;
    }

    public static String inputString(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

}