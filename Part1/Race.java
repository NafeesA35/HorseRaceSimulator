import java.util.concurrent.TimeUnit;

/**
 * A three-horse race, each horse running in its own lane
 * for a given distance
 * 
 * @author McRaceface
 * @version 1.0
 */
public class Race
{
    private int raceLength;
    private Horse lane1Horse;
    private Horse lane2Horse;
    private Horse lane3Horse;
    private Horse lane4Horse;
    private Horse lane5Horse;
    private final int MAX_LANES = 5;
    private final int MAX_DISTANCE = 30;
    private final int MIN_DISTANCE = 10;

    /**
     * Constructor for objects of class Race
     * Initially there are no horses in the lanes
     * 
     * @param distance the length of the racetrack (in metres/yards...)
     */
    public Race(int distance)
    {
        // If statements to ensure entered distance is not greater than the max distance or less than the min distance
        if (distance > MAX_DISTANCE)
        {
            raceLength = MAX_DISTANCE;
            System.out.println(" Your distance is too long, setting to max distance of " + MAX_DISTANCE + "m.");
            System.out.println();

        }else if(distance < MIN_DISTANCE)
        {
            raceLength = MIN_DISTANCE;
            System.out.println(" Your distance is too short, setting to min distance of " + MIN_DISTANCE + "m.");

        }else
        {
            raceLength = distance;
        }

        // initialise instance variables
        lane1Horse = null;
        lane2Horse = null;
        lane3Horse = null;
        lane4Horse = null;
        lane5Horse = null;
    }
    
    /**
     * Adds a horse to the race in a given lane
     * 
     * @param theHorse the horse to be added to the race
     * @param laneNumber the lane that the horse will be added to
     */
    public void addHorse(Horse theHorse, int laneNumber)
    {
        if (laneNumber == 1)
        {
            lane1Horse = theHorse;
        }
        else if (laneNumber == 2)
        {
            lane2Horse = theHorse;
        }
        else if (laneNumber == 3)
        {
            lane3Horse = theHorse;
        }
        else if (laneNumber == 4)
        {
            lane4Horse = theHorse;
        }
        else if (laneNumber == 5)
        {
            lane5Horse = theHorse;
        }
        else
        {
            System.out.println("Cannot add horse to lane " + laneNumber + " because there is no such lane");
        }
    }
    
    /**
     * Start the race
     * The horse are brought to the start and
     * then repeatedly moved forward until the 
     * race is finished
     */
    public void startRace()
    {
        //declare a local variable to tell us when the race is finished
        boolean finished = false;
        
        //reset all the lanes (all horses not fallen and back to 0). 
        if (lane1Horse != null) lane1Horse.goBackToStart();
        if (lane2Horse != null) lane2Horse.goBackToStart();
        if (lane3Horse != null) lane3Horse.goBackToStart();
        if (lane4Horse != null) lane4Horse.goBackToStart();
        if (lane5Horse != null) lane5Horse.goBackToStart();
                      
        while (!finished)
        {
            //move each horse that are not null
            
            if (lane1Horse != null) moveHorse(lane1Horse);
            if (lane2Horse != null) moveHorse(lane2Horse);
            if (lane3Horse != null) moveHorse(lane3Horse);
            if (lane4Horse != null) moveHorse(lane4Horse);
            if (lane5Horse != null) moveHorse(lane5Horse);
                        
            //print the race positions
            printRace();

            if(lane1Horse !=null && raceWonBy(lane1Horse))
            {
                finished = true;
                System.out.println( "And the winner is "+ lane1Horse.getName() +"!");
            }
            else if(lane2Horse !=null && raceWonBy(lane2Horse))
            {
                finished = true;
                System.out.println( "And the winner is "+ lane2Horse.getName() +"!");
            }
            else if(lane3Horse !=null && raceWonBy(lane3Horse))
            {
                finished = true;
                System.out.println( "And the winner is "+ lane3Horse.getName() +"!");
            }
            else if(lane4Horse !=null && raceWonBy(lane4Horse))
            {
                finished = true;
                System.out.println( "And the winner is "+ lane4Horse.getName() +"!");
            }
            else if(lane5Horse !=null && raceWonBy(lane5Horse))
            {
                finished = true;
                System.out.println( "And the winner is "+ lane5Horse.getName() +"!");
            }           
            else if (allFallen())
            {
                finished = true;
                System.out.println("All horses have fallen!");
            }
           
            //wait for 100 milliseconds
            try{ 
                TimeUnit.MILLISECONDS.sleep(100);
            }catch(Exception e){}
        }
    }
    
    /**
     * Randomly make a horse move forward or fall depending
     * on its confidence rating
     * A fallen horse cannot move
     * 
     * @param theHorse the horse to be moved
     */
    private void moveHorse(Horse theHorse)
    {
        //if the horse has fallen it cannot move, 
        //so only run if it has not fallen
        if  (!theHorse.hasFallen())
        {
            //the probability that the horse will move forward depends on the confidence;
            if (Math.random() < theHorse.getConfidence())
            {
               theHorse.moveForward();
            }
            
            //the probability that the horse will fall is very small (max is 0.1)
            //but will also will depends exponentially on confidence 
            //so if you double the confidence, the probability that it will fall is *2
            if (Math.random() < (0.1*theHorse.getConfidence()*theHorse.getConfidence()))
            {

                theHorse.fall();

            }
        }
    }
        
    /** 
     * Determines if a horse has won the race
     *
     * @param theHorse The horse we are testing
     * @return true if the horse has won, false otherwise.
     */
    private boolean raceWonBy(Horse theHorse)
    {
        if (theHorse.getDistanceTravelled() == raceLength)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /***
     * Print the race on the terminal
     */
    private void printRace()
    {
        System.out.print('\u000C');  //clear the terminal window
        
        multiplePrint('=',raceLength+3); //top edge of track
        System.out.println();
        
        if (lane1Horse != null) {
            printLane(lane1Horse);
            System.out.println();
        }
        
        if (lane2Horse != null) {
            printLane(lane2Horse);
            System.out.println();
        }
        
        if (lane3Horse != null) {
            printLane(lane3Horse);
            System.out.println();
        }
        
        if (lane4Horse != null) {
            printLane(lane4Horse);
            System.out.println();
        }
        
        if (lane5Horse != null) {
            printLane(lane5Horse);
            System.out.println();
        }
        
        multiplePrint('=',raceLength+3); //bottom edge of track
        System.out.println();    
    }
    
    /**
     * print a horse's lane during the race
     * for example
     * |           X                      |
     * to show how far the horse has run
     */
    private void printLane(Horse theHorse)
    {
        //calculate how many spaces are needed before
        //and after the horse
        int spacesBefore = theHorse.getDistanceTravelled();
        int spacesAfter = raceLength - theHorse.getDistanceTravelled();
        
        //print a | for the beginning of the lane
        System.out.print('|');
        
        //print the spaces before the horse
        multiplePrint(' ',spacesBefore);
        
        //if the horse has fallen then print dead
        //else print the horse's symbol
        if(theHorse.hasFallen())
        {
            System.out.print('X');
        }
        else
        {
            System.out.print(theHorse.getSymbol());
        }
        
        //print the spaces after the horse
        multiplePrint(' ',spacesAfter);
        
        //print the | for the end of the track
        System.out.print('|');

        for(int i = 0; i < 5; i++)
        {
            System.out.print(' ');
        }

        System.out.print(theHorse.getName() + " (Current Confidence: "+ theHorse.getConfidence()+") " +" (Distance Travelled: "+ theHorse.getDistanceTravelled()+") ");

    }
        
    
    /***
     * print a character a given number of times.
     * e.g. printmany('x',5) will print: xxxxx
     * 
     * @param aChar the character to Print
     */
    private void multiplePrint(char aChar, int times)
    {
        int i = 0;
        while (i < times)
        {
            System.out.print(aChar);
            i = i + 1;
        }
    }

    private boolean allFallen()
    {
        Horse[] horses = {lane1Horse, lane2Horse, lane3Horse, lane4Horse, lane5Horse};
        for (Horse horse : horses)
        {
            if (horse != null && !horse.hasFallen())
            {
                return false; // At least one horse is not fallen
            }

        }
        return true; // All horses have fallen


    }


}