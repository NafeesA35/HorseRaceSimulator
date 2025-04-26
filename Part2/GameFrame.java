// Import
package Part2;

import Part1.Horse;
import javax.swing.*;

public class GameFrame extends JFrame
{
    HorsePanel horsePanel;
    Horse[] horses = new Horse[5];

    public GameFrame(Horse[] horses) {

    
        this.horses = horses;


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(800, 600);
        this.setResizable(false);

        horsePanel = new HorsePanel(0 ,30, horses[0]);
        HorsePanel horsePanel2 = new HorsePanel(0 ,100, horses[1]);
        HorsePanel horsePanel3 = new HorsePanel(0 ,170, horses[2]);
        HorsePanel horsePanel4 = new HorsePanel(0 ,240, horses[3]);
        HorsePanel horsePanel5 = new HorsePanel(0 ,310, horses[4]);


        this.add(horsePanel);
        this.add(horsePanel2);
        this.add(horsePanel3);
        this.add(horsePanel4);
        this.add(horsePanel5);



        JLabel horsesLabel = new JLabel("Horse name: " + horsePanel.horse.getName() + ", Confidence: " + horsePanel.horse.getConfidence() + ", Breed: " + horsePanel.horse.getBreed());
        horsesLabel.setBounds(150, 8, 300, 30);
        this.add(horsesLabel);
        JLabel horsesLabel2 = new JLabel("Horse name: " + horsePanel2.horse.getName() + ", Confidence: " + horsePanel2.horse.getConfidence() + ", Breed: " + horsePanel2.horse.getBreed());
        horsesLabel2.setBounds(150, 78, 300, 30);
        this.add(horsesLabel2);
        JLabel horsesLabel3 = new JLabel("Horse name: " + horsePanel3.horse.getName() + ", Confidence: " + horsePanel3.horse.getConfidence() + ", Breed: " + horsePanel3.horse.getBreed());
        horsesLabel3.setBounds(150, 148, 300, 30);
        this.add(horsesLabel3);
        JLabel horsesLabel4 = new JLabel("Horse name: " + horsePanel4.horse.getName() + ", Confidence: " + horsePanel4.horse.getConfidence() + ", Breed: " + horsePanel4.horse.getBreed());
        horsesLabel4.setBounds(150, 218, 300, 30);
        this.add(horsesLabel4);
        JLabel horsesLabel5 = new JLabel("Horse name: " + horsePanel5.horse.getName() + ", Confidence: " + horsePanel5.horse.getConfidence() + ", Breed: " + horsePanel5.horse.getBreed());
        horsesLabel5.setBounds(150, 288, 300, 30);
        this.add(horsesLabel5);





        this.setVisible(true);
        
    }
}



