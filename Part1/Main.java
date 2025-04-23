public class Main {
    public static void main(String[] args) {

        // Create a Horse object
        //█ ▄ ▀ ■ □ ▲ ▼ ► ◄ ○ ● ▌ ▐
        Race race = new Race(22);
        Horse horse = new Horse('■', "Opio", 0.5);
        Horse horse2 = new Horse('█', "Roach", 0.2);
        Horse horse3 = new Horse('░', "Pasta", 0.8);
        Horse horse4 = new Horse('░', "Khat", 0.8);
        Horse horse5 = new Horse('░', "Ty", 0.8);

        race.addHorse(horse, 1);
        race.addHorse(horse2, 2);
        race.addHorse(horse3, 3);
        race.addHorse(horse4, 4);
        race.addHorse(horse5, 5);
        race.startRace();
        
    }
}