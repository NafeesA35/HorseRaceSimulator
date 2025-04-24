import java.util.Scanner;

/**
 * The horse class is a representation of a horse in the simulator, consisting of attributes such as name, symbol, confidence, distance travelled, and whether it has fallen.
 * 
 * @author Nafees Ahmed
 * @version (a version number or a date)
 */
public class Horse
{
    //Fields of class Horse
    private String name;
    private char symbol;
    private double confidence;
    private int distanceTravelled;
    private boolean hasFallen;
    
    
      
    //Constructor of class Horse
    /**
     * Constructor for objects of class Horse
     */
    public Horse(char horseSymbol, String horseName, double horseConfidence)
    {
        this.symbol = horseSymbol;
        this.name = horseName;
        verifyConfidence(horseConfidence);

    }
    
    
    
    //Other methods of class Horse
    // GETTERS - getConfidence, getDistanceTravelled, getName, getSymbol, hasFallen
    // SETTERS - setConfidence, setSymbol, goBackToStart, moveForward, fall
    public void fall()
    {   
        this.hasFallen = true;
    }
    public double getConfidence()
    {
        return this.confidence;
    }
    
    public int getDistanceTravelled()
    {
        return this.distanceTravelled;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public char getSymbol()
    {
        return this.symbol;
    }
    
    public void goBackToStart()
    {
        this.distanceTravelled = 0;
        // Allows the race to be repeated.
        this.hasFallen = false;
    }
    
    public boolean hasFallen()
    {
        return this.hasFallen;
    }

    public void moveForward()
    {
        this.distanceTravelled++;
    }

    public void setConfidence(double newConfidence)
    {
        this.confidence = newConfidence;
    }
    
    public void setSymbol(char newSymbol)
    {
        this.symbol = newSymbol;
    }

    
    private void verifyConfidence(double confidence)
    {
        boolean valid = false;
        Scanner scanner = new Scanner(System.in);
        double newConfidence = confidence;
        // Loop until a valid confidence value is entered
        while (!valid)
        {
            if (newConfidence >= 0 && newConfidence <= 1)
            {
                valid = true;
            }
            else
            {
                System.out.println("Please enter a number between 0 and 1: ");
                
                try
                {
                    newConfidence = scanner.nextDouble();
                }
                catch (Exception e)
                {
                    System.out.println("Invalid again!");
                    scanner.next(); // Clear the invalid input

                }
            }
        }
        setConfidence(newConfidence);
    }

    public void decreaseConfidence()
    {
        this.confidence = this.confidence - 0.05;
    }
    public void increaseConfidence()
    {
        this.confidence = this.confidence + 0.05;
    }
    
}