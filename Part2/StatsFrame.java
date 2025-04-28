package Part2;
import javax.swing.*;
import Part1.Horse;

public class StatsFrame extends JFrame
{
    public StatsFrame(Horse[] horses, int numberOfHorses) {
        //Set up the JFrame
        super("Horse Race Sim");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(800, 600);
        this.setResizable(false);
        double winRatio = 0.0;
        double fallRatio = 0.0;
        double speed = 0.0;
        // Iterate through the selected horses and display their stats
        for(int i = 0; i < numberOfHorses; i++) {
            if(horses[i] != null) {
                fallRatio = (double) horses[i].getTotalFalls() / (double)horses[i].getTotalRaces();
                fallRatio = roundToTwoDecimalPlaces(fallRatio);
                winRatio = (double) horses[i].getTotalWins() / (double)horses[i].getTotalRaces();
                winRatio = roundToTwoDecimalPlaces(winRatio);
                speed = (double) horses[i].getTotalDistance() / (double)horses[i].getTime();
                speed = roundToTwoDecimalPlaces(speed);
                JLabel horseLabel = createLabel("Horse Name: " + horses[i].getName() + " Total Falls: " + horses[i].getTotalFalls() + " Total Distance: " + horses[i].getTotalDistance() + " Total Wins: " + horses[i].getTotalWins() + " Win Ratio : "+winRatio  + " Fall ratio: "+fallRatio + " Average Speed : "+ speed, 20, (20 + (i * 30)), 800, 30 );
                this.add(horseLabel);
            }
        }
        
    }
    // Simple lable creation methid
    public JLabel createLabel(String text, int x, int y , int width, int height) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setVisible(true);
        return label;
    }

    // Round doubles to prevent abnormally narge decimal points
    private double roundToTwoDecimalPlaces(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
    
}
