public class Main {
    public static void main(String[] args) {
        // Create a Horse object
        Race race = new Race(10);
        Horse horse = new Horse('A', "Opio", 0.3);
        Horse horse2 = new Horse('B', "Roach", 0.7);
        Horse horse3 = new Horse('C', "Pasta", 0.4);

        race.addHorse(horse, 1);
        race.addHorse(horse2, 2);
        race.addHorse(horse3, 3);
        race.startRace();
        
    }
}