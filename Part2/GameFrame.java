// Import
package Part2;

import Part1.Horse;
import Part1.Race;
import javax.swing.*;

public class GameFrame extends JFrame
{
    HorsePanel horsePanel, horsePanel2, horsePanel3, horsePanel4, horsePanel5;
    Horse[] horses = new Horse[5];
    JButton restartButton;
    JButton statsButton;
    int raceDistance = 0;
    int numberOfHorses;

    public GameFrame(Horse[] horses , Race race , int numberOfHorses) {
        // Set up the JFrame
        this.numberOfHorses = numberOfHorses;
        this.raceDistance = race.getRaceLength();
        this.horses = horses;


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(800, 600);
        this.setResizable(false);
        // Reset the horses to start position before race begins
        for (Horse horse : horses) {
            if (horse != null) {
                horse.goBackToStart();
                
            }
        }

        // Only add the horse panels that are needed i.e the number of horses selected by user.
        if (numberOfHorses >= 1) {
            horsePanel = new HorsePanel(0 ,30, horses[0], race, this);
            this.add(horsePanel);
            JLabel horsesLabel = new JLabel("Horse name: " + horsePanel.horse.getName() + ", Confidence: " + Race.roundToTwoDecimalPlaces(horsePanel.horse.getConfidence()) + ", Breed: " + horsePanel.horse.getBreed());
            horsesLabel.setBounds(150, 8, 400, 30);
            this.add(horsesLabel);
        }
        if (numberOfHorses >= 2) {
            horsePanel2 = new HorsePanel(0 ,100, horses[1], race, this);
            this.add(horsePanel2);
            JLabel horsesLabel2 = new JLabel("Horse name: " + horsePanel2.horse.getName() + ", Confidence: " + Race.roundToTwoDecimalPlaces(horsePanel2.horse.getConfidence()) + ", Breed: " + horsePanel2.horse.getBreed());
            horsesLabel2.setBounds(150, 78, 400, 30);
            this.add(horsesLabel2);
        }
        if (numberOfHorses >= 3) {
            horsePanel3 = new HorsePanel(0 ,170, horses[2], race, this);
            this.add(horsePanel3);
            JLabel horsesLabel3 = new JLabel("Horse name: " + horsePanel3.horse.getName() + ", Confidence: " + Race.roundToTwoDecimalPlaces(horsePanel3.horse.getConfidence()) + ", Breed: " + horsePanel3.horse.getBreed());
            horsesLabel3.setBounds(150, 148, 400, 30);
            this.add(horsesLabel3);
        }
        if (numberOfHorses >= 4) {
            horsePanel4 = new HorsePanel(0 ,240, horses[3], race, this);
            this.add(horsePanel4);
            JLabel horsesLabel4 = new JLabel("Horse name: " + horsePanel4.horse.getName() + ", Confidence: " + Race.roundToTwoDecimalPlaces(horsePanel4.horse.getConfidence()) + ", Breed: " + horsePanel4.horse.getBreed());
            horsesLabel4.setBounds(150, 218, 400, 30);
            this.add(horsesLabel4);
        }
        if (numberOfHorses >= 5) {
            horsePanel5 = new HorsePanel(0 ,310, horses[4], race, this);
            this.add(horsePanel5);
            JLabel horsesLabel5 = new JLabel("Horse name: " + horsePanel5.horse.getName() + ", Confidence: " + Race.roundToTwoDecimalPlaces(horsePanel5.horse.getConfidence()) + ", Breed: " + horsePanel5.horse.getBreed());
            horsesLabel5.setBounds(150, 288, 400, 30);
            this.add(horsesLabel5);
        }

        // RESTART BUTTON 
        restartButton = new JButton("Restart Race");
        restartButton.setBounds(650, 520, 120, 30);
        // Lambda function to handle click
        restartButton.addActionListener(e -> {
            // dispose this window and start another race.
            new GameFrame(horses , race, this.numberOfHorses).setVisible(true);
            dispose();
        });
        add(restartButton);
        restartButton.setEnabled(false);

        // STATS BUTTON {is able to display cumulative stats}
        statsButton = new JButton("Stats");
        statsButton.setBounds(650, 480, 120, 30);
        // Lambda function to handle click
        statsButton.addActionListener(e -> {
            // dispose this and move onto the stats frame
            new StatsFrame(horses , numberOfHorses).setVisible(true);
            dispose();
        });
        add(statsButton);
        statsButton.setEnabled(false);

        setVisible(true);
        
    }

    // If a horse wins, display the winner and update the stats of all horses.
    public void displayWinner(Horse winner){
        if (horsePanel != null) {horsePanel.timer.stop();  horsePanel.horse.incrementTotalDistance(horsePanel.horse.getDistanceTravelled()); horsePanel.horse.incrementTotalRaces();}
        if (horsePanel2 != null) {horsePanel2.timer.stop(); horsePanel2.horse.incrementTotalDistance(horsePanel2.horse.getDistanceTravelled()); horsePanel2.horse.incrementTotalRaces();}
        if (horsePanel3 != null) {horsePanel3.timer.stop(); horsePanel3.horse.incrementTotalDistance(horsePanel3.horse.getDistanceTravelled()); horsePanel3.horse.incrementTotalRaces();}
        if (horsePanel4 != null) {horsePanel4.timer.stop(); horsePanel4.horse.incrementTotalDistance(horsePanel4.horse.getDistanceTravelled()); horsePanel4.horse.incrementTotalRaces();}
        if (horsePanel5 != null) {horsePanel5.timer.stop(); horsePanel5.horse.incrementTotalDistance(horsePanel5.horse.getDistanceTravelled()); horsePanel5.horse.incrementTotalRaces();}
        winner.incrementTotalWins();
        JOptionPane.showMessageDialog(this, "The winner is: " + winner.getName());
        restartButton.setEnabled(true);
        statsButton.setEnabled(true);

    }

    // If all horses fall, display a message and update the stats of all horses.
    // This is called when all horses have fallen.
    public void displayLoss(){
        if (horsePanel != null) {horsePanel.timer.stop(); horsePanel.horse.incrementTotalDistance(horsePanel.horse.getDistanceTravelled()); horsePanel.horse.incrementTotalRaces();}
        if (horsePanel2 != null) {horsePanel2.timer.stop(); horsePanel2.horse.incrementTotalDistance(horsePanel2.horse.getDistanceTravelled()); horsePanel2.horse.incrementTotalRaces();}
        if (horsePanel3 != null) {horsePanel3.timer.stop(); horsePanel3.horse.incrementTotalDistance(horsePanel3.horse.getDistanceTravelled()); horsePanel3.horse.incrementTotalRaces();}
        if (horsePanel4 != null) {horsePanel4.timer.stop(); horsePanel4.horse.incrementTotalDistance(horsePanel4.horse.getDistanceTravelled()); horsePanel4.horse.incrementTotalRaces();}
        if (horsePanel5 != null) {horsePanel5.timer.stop(); horsePanel5.horse.incrementTotalDistance(horsePanel5.horse.getDistanceTravelled()); horsePanel5.horse.incrementTotalRaces();}
        JOptionPane.showMessageDialog(this, "All the horses have fallen. No winner.");
        restartButton.setEnabled(true);
        statsButton.setEnabled(true);

    }
    // Check if all horses have fallen.
    public boolean allFallen(){
        int fall = 0;
        if(horsePanel != null && horsePanel.horse.hasFallen()) fall++;
        if(horsePanel2 != null && horsePanel2.horse.hasFallen()) fall++;
        if(horsePanel3 != null && horsePanel3.horse.hasFallen()) fall++;
        if(horsePanel4 != null && horsePanel4.horse.hasFallen()) fall++;
        if(horsePanel5 != null && horsePanel5.horse.hasFallen()) fall++;
        if(this.numberOfHorses <= fall) return true;

        return false;

    }
    


}



