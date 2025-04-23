public class Main {
    public static void main(String[] args) {

        // Create a Horse object
        //█ ▄ ▀ ■ □ ▲ ▼ ► ◄ ○ ● ▌ ▐
        Race race = new Race(20);
        Horse horse = new Horse('■', "Opio", 0.8);
        Horse horse2 = new Horse('█', "Roach", 0.8);
        Horse horse3 = new Horse('░', "Pasta", 0.8);

        race.addHorse(horse, 1);
        race.addHorse(horse2, 2);
        race.addHorse(horse3, 3);
        race.startRace();
        
    }
}