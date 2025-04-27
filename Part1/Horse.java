package Part1;

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
    private String breed = "Normal"; // Default breed
    private String imagePath = "Part2/images/Black.png"; // Default image path
    private String color = "Black";
    private String saddle = "Normal";
    private String shoe = "Normal";

    private int bonusSpeed = 0; // Default bonus speed
    private double bonusEndurance = 0; // Default bonus endurance
    
    
      
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
        if(Math.random() < 0.5){
            this.distanceTravelled = this.distanceTravelled + this.bonusSpeed;
        }
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
        if (this.confidence > 0.1)
        {
            this.confidence = this.confidence - 0.05;
        }
    }
    public void increaseConfidence()
    {
        if (this.confidence < 0.95)
        {
            this.confidence = this.confidence + 0.05;
        }

    }
    public void setBreed(String breed)
    {
        this.breed = breed;
        if (this.breed.equals("Friesian")) {
            setConfidence(this.confidence + 0.05); 
        } else if (this.breed.equals("Mustang")) {
             setConfidence(this.confidence + 0.02);
        }


    }
    public String getBreed()
    {
        return this.breed;

    }

    public void setSaddle(String saddle) {
        this.saddle = saddle;
    }

    public String getSaddle() {
        return this.saddle;
    }

    public void setShoe(String shoe) {
        this.shoe = shoe;
    }

    public String getShoe() {
        return this.shoe;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }
    public void setImagePath(String pcolor, String psaddle, String pshoe) 
    {
    
        this.imagePath =  "Part2/" +"images/"+ pcolor +psaddle+pshoe+ ".png";

    }
    public String getImagePath()
    {
        return this.imagePath;
    }

    public void recalculateBonuses() {
        // Reset bonuses before recalculating
        this.bonusSpeed = 0;
        this.bonusEndurance = 0.0;

        // Saddle bonuses
        if (this.saddle.equals("Brown")) {
            this.bonusSpeed++;
        } else if (this.saddle.equals("Red")) {
            this.bonusEndurance = bonusEndurance +  0.05; 
        }

        // Shoe bonuses
        if (this.shoe.equals("Silver")) {
            this.bonusSpeed++; // Silver shoe speed boost
        } else if (this.shoe.equals("Brown")) {
            this.bonusEndurance = bonusEndurance +  0.08;
        }
    }

    public int getBonusSpeed() {
        return this.bonusSpeed;
    }

    public double getBonusEndurance() {
        return this.bonusEndurance;
    }




    
}