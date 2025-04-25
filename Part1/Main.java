package Part1;

import Part2.Gui;


public class Main {
    public static void main(String[] args) {


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
        Gui gui = new Gui();
        gui.startRaceGui(horses, 20 );
        
    }

}