package Part2;

import Part1.Horse;
import Part1.Race;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/* 
public class Gui {

    public void startRaceGui(Horse[] horses, int raceLength) {
        // Create a JFrame for the GUI
        JFrame frame = new JFrame("Horse Race Sim");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);


        frame.add(addPanel(0, 50, 600, 50, Color.BLUE));
        frame.add(addPanel(0, 150, 600, 50, Color.RED));
        frame.add(addPanel(0, 250, 600, 50, Color.GREEN));
        frame.add(addPanel(0, 350, 600, 50, Color.YELLOW));
        frame.add(addPanel(0, 450, 600, 50, Color.ORANGE));

    }


    private JPanel addPanel(int x , int y, int width, int height, Color color) {
        
        ImageIcon imageIcon = new ImageIcon("Part2/horse.png");
        Image horseImage = imageIcon.getImage();

        System.out.println("Current working directory: " + System.getProperty("user.dir"));

        if (imageIcon.getIconWidth() <= 0) {
            System.out.println("Warning: Could not load horse.png image");
        }
        
        
        // Create a custom panel that draws the image
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw the image at position 10,10 within the panel
                g.drawImage(horseImage, 10, 0, null);
            }
        };
        
        
        panel.setLayout(new BorderLayout());
        panel.setBounds(x, y, width, height);
        panel.setVisible(true);
        panel.setBackground(color);
        return panel;
        
    }


	
}


class HorsePanel extends JPanel {
    private Image horseImage;
    Horse horse;

    
    public HorsePanel() {
        // Load the horse image
        ImageIcon imageIcon = new ImageIcon("Part2/horse.png");
        horseImage = imageIcon.getImage();
        
        if (horseImage == null) {
            System.out.println("Warning: Could not load horse.png image");
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the horse image at position 10,10 within the panel
        g.drawImage(horseImage, 10, 0, null);
    }

}

*/

public class GuiFrame extends JFrame implements ActionListener{

    
    private JComboBox<String> comboBox, horsesComboBox, horse1Breed , horse2Breed, horse3Breed, horse4Breed, horse5Breed , saddle1, saddle2, saddle3, saddle4, saddle5;
    private JComboBox<String> shoe1, shoe2, shoe3, shoe4, shoe5;
    private JComboBox<String> colour1, colour2, colour3, colour4, colour5;

    private JSlider distanceSlider;         
    private JButton submitButton;
    private JButton statsButton;
    private Horse[] horses; // Array to hold horse objects
    private String[] breeds = new String[5]; // Array to hold horse breeds  
    private int sliderValue = 10;    
    private Race race;
    private String[] horseColours = new String[5]; // Array to hold horse colours
    private String[] horseSaddles = new String[5]; // Array to hold horse saddles
    private String[] horseShoes = new String[5]; // Array to hold horse shoes

    public GuiFrame(Horse[] horses) {
        super("Horse Race Sim");
        this.race = race;
        this.horses = horses;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLayout(null);


        JLabel horsesLabel = new JLabel("Select number of horses:");
        horsesLabel.setBounds(50, 20, 200, 30);
        this.add(horsesLabel);
        
        String[] horseOptions = {"2", "3", "4", "5"};
        JComboBox<String> horsesComboBox = new JComboBox<>(horseOptions);
        horsesComboBox.setBounds(250, 20, 100, 30);
        this.horsesComboBox = horsesComboBox;
        this.add(horsesComboBox);
        this.setResizable(false);

        // END OF RADIO BUTTONS

        // START - Weather conditions
        String[] weatherConditions = {"Random", "Normal", "Icy", "Rainy"};
        comboBox = new JComboBox<>(weatherConditions); // Assign to instance variable
        this.add(comboBox);
        comboBox.setBounds(250, 50, 100, 30);

        JLabel weatherLabel = new JLabel("Select weather conditions:");
        weatherLabel.setBounds(50, 50, 200, 30);
        this.add(weatherLabel);
        this.setResizable(false);
        comboBox.setVisible(true);


        // END - Weather conditions

        // START - Distance slider
        distanceSlider = new JSlider(JSlider.HORIZONTAL, 10, 25, 10); // Assign to instance variable
        distanceSlider.setMajorTickSpacing(5);
        distanceSlider.setMinorTickSpacing(1);
        distanceSlider.setPaintTicks(true);
        distanceSlider.setPaintLabels(true);
        distanceSlider.setBounds(50, 150, 700, 50);
        this.add(distanceSlider);
        distanceSlider.setVisible(true);

        JLabel distanceLabel = createLabel("Select a race distance between 10 and 25 below:", 250, 100, 300, 30);
        this.add(distanceLabel);
        
        distanceLabel.setVisible(true);
        // END - Distance

        // Add the Submit button
        submitButton = new JButton("Submit");       
        submitButton.setBounds(300, 500, 100, 30);  //
        this.add(submitButton);                     
        submitButton.addActionListener(this);





        // EVERYTHING ABOUT HORSES BELOW

        JLabel horse1Label = createLabel("Horse 1: Opio :", 30, 250, 200, 30);
        this.add(horse1Label);
        horse1Label.setVisible(true);

        String[] breed = {"Arabian", "Mustang", "Friesian"};
        horse1Breed = new JComboBox<>(breed);
        horse1Breed.setBounds(180, 255, 80, 20);
        this.add(horse1Breed);



        JLabel horse2Label = createLabel("Horse 2: Roach :", 30, 280, 200, 30);
        this.add(horse2Label);
        horse2Label.setVisible(true);

        horse2Breed = new JComboBox<>(breed);
        horse2Breed.setBounds(180, 285, 80, 20);
        this.add(horse2Breed);
        horse2Breed.setVisible(true);

        

        JLabel horse3Label = createLabel("Horse 3: Pasta :", 30, 310, 200, 30);
        this.add(horse3Label);
        horse3Label.setVisible(true);

        horse3Breed = new JComboBox<>(breed);
        horse3Breed.setBounds(180, 315, 80, 20);
        this.add(horse3Breed);
        horse3Breed.setVisible(true);

        JLabel horse4Label = createLabel("Horse 4: Khat :", 30, 340, 200, 30);
        this.add(horse4Label);
        horse4Label.setVisible(true);

        horse4Breed = new JComboBox<>(breed);
        horse4Breed.setBounds(180, 345, 80, 20);
        this.add(horse4Breed);
        horse4Breed.setVisible(true);
        

        JLabel horse5Label = createLabel("Horse 5: Ty: ", 30, 370, 200, 30);
        this.add(horse5Label);
        horse5Label.setVisible(true);

        horse5Breed = new JComboBox<>(breed);
        horse5Breed.setBounds(180, 375, 80, 20);
        this.add(horse5Breed);
        horse5Breed.setVisible(true);

        // START - All about saddles

        JComboBox<String> saddle1 = saddleComboBox(300, 255, 100, 20);
        this.saddle1 = saddle1;

        JComboBox<String> saddle2 = saddleComboBox(300, 285, 100, 20);
        this.saddle2 = saddle2;

        JComboBox<String> saddle3 = saddleComboBox(300, 315, 100, 20);
        this.saddle3 = saddle3;

        JComboBox<String> saddle4 = saddleComboBox(300, 345, 100, 20);
        this.saddle4 = saddle4;

        JComboBox<String> saddle5 = saddleComboBox(300, 375, 100, 20);
        this.saddle5 = saddle5;

        // END - All about saddles

        // START - All about shoes
        JComboBox<String> shoe1 = shoeComboBox(450, 255, 100, 20);
        this.shoe1 = shoe1;

        JComboBox<String> shoe2 = shoeComboBox(450, 285, 100, 20);
        this.shoe2 = shoe2;

        JComboBox<String> shoe3 = shoeComboBox(450, 315, 100, 20);
        this.shoe3 = shoe3;
        JComboBox<String> shoe4 = shoeComboBox(450, 345, 100, 20);
        this.shoe4 = shoe4;

        JComboBox<String> shoe5 = shoeComboBox(450, 375, 100, 20);
        this.shoe5 = shoe5;
        // END - All about shoes

        // START - All about colours
        JComboBox<String> colour1 = colourBox(600, 255, 100, 20);
        this.colour1 = colour1;

        JComboBox<String> colour2 = colourBox(600, 285, 100, 20);
        this.colour2 = colour2;

        JComboBox<String> colour3 = colourBox(600, 315, 100, 20);
        this.colour3 = colour3;

        JComboBox<String> colour4 = colourBox(600, 345, 100, 20);
        this.colour4 = colour4;

        JComboBox<String> colour5 = colourBox(600, 375, 100, 20);
        this.colour5 = colour5;
        // END - All about colours

        // Labels for breeds, saddles, shoes and colours
        JLabel breedLabel = createLabel("Select horse breed:", 180, 220, 200, 30);
        this.add(breedLabel);

        JLabel saddleLabel = createLabel("Select horse saddle:", 300, 220, 200, 30);
        this.add(saddleLabel);


        JLabel shoeLabel = createLabel("Select horse shoe:", 450, 220, 200, 30);
        this.add(shoeLabel);

        JLabel colourLabel = createLabel("Select horse colour:", 600, 220, 200, 30);
        this.add(colourLabel);

        // END - Labels for breeds, saddles, shoes and colours




        // Message:
        JLabel messageLabel = createLabel("Friesian breeds get a confidence boost of 0.05 and mustang 0.02. Brown saddles gives speed boost (50% chance at each move)", 30, 400, 750, 30);
        JLabel messageLabel2 = createLabel("Red saddles give you an endurance bonus, making you less likely to fall. Silver shoes have the same benefits as Brown saddles.", 30, 440, 750, 30);
        JLabel messageLabel3 = createLabel("Brown shoes give you greater endurance", 30, 480, 750, 30);




        this.setResizable(false);
        this.setVisible(true); // Make the frame visible

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Check if the event source is the submit button
        if (e.getSource() == submitButton) {

            int numHorses = Integer.parseInt((String) horsesComboBox.getSelectedItem());
            String weather = (String) comboBox.getSelectedItem(); 
            this.sliderValue = distanceSlider.getValue();


            // Selected breeds
            breeds[0] = (String) horse1Breed.getSelectedItem();
            breeds[1] = (String) horse2Breed.getSelectedItem();
            breeds[2] = (String) horse3Breed.getSelectedItem();
            breeds[3] = (String) horse4Breed.getSelectedItem();
            breeds[4] = (String) horse5Breed.getSelectedItem();


            // Selected saddles
            horseSaddles[0] = (String) saddle1.getSelectedItem();
            horseSaddles[1] = (String) saddle2.getSelectedItem();
            horseSaddles[2] = (String) saddle3.getSelectedItem();
            horseSaddles[3] = (String) saddle4.getSelectedItem();
            horseSaddles[4] = (String) saddle5.getSelectedItem();

            // END - Selected saddles

            // Selected shoes
            horseShoes[0] = (String) shoe1.getSelectedItem();
            horseShoes[1] = (String) shoe2.getSelectedItem();
            horseShoes[2] = (String) shoe3.getSelectedItem();
            horseShoes[3] = (String) shoe4.getSelectedItem();
            horseShoes[4] = (String) shoe5.getSelectedItem();
            // END - Selected shoes

            // Selected colours
            horseColours[0] = (String) colour1.getSelectedItem();
            horseColours[1] = (String) colour2.getSelectedItem();
            horseColours[2] = (String) colour3.getSelectedItem();
            horseColours[3] = (String) colour4.getSelectedItem();
            horseColours[4] = (String) colour5.getSelectedItem();
            // END - Selected colours



            for (int i = 0; i < breeds.length && i < horses.length; i++) {
                horses[i].setBreed(breeds[i]);
                horses[i].setColor(horseColours[i]);
                horses[i].setSaddle(horseSaddles[i]);
                horses[i].setShoe(horseShoes[i]);
                horses[i].setImagePath(horseColours[i], horseSaddles[i], horseShoes[i]);
                horses[i].recalculateBonuses();
            }




            this.race = new Race(this.sliderValue); // Create a new
            race.setCondition(weather); // Set the weather condition
            GameFrame gameFrame = new GameFrame(horses , this.race, numHorses); // Create a new GameFrame instance
            gameFrame.setVisible(true);
            this.dispose();

        }
    }

    public JLabel createLabel(String text, int x, int y , int width, int height) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setVisible(true);
        this.add(label);
        return label;
    }

    public JComboBox<String> saddleComboBox(int x, int y, int width, int height) {
        JComboBox<String> comboBox = new JComboBox<>(new String[]{"Normal", "Brown", "Red"});
        comboBox.setBounds(x, y, width, height);
        comboBox.setVisible(true);
        comboBox.setSelectedIndex(0);
        this.add(comboBox);
        return comboBox;
    }

    public JComboBox<String> shoeComboBox(int x, int y, int width, int height) {
        JComboBox<String> comboBox = new JComboBox<>(new String[]{"Normal", "Brown", "Silver"});
        comboBox.setBounds(x, y, width, height);
        comboBox.setVisible(true);
        comboBox.setSelectedIndex(0);
        this.add(comboBox);
        return comboBox;
    }

    public JComboBox<String> colourBox( int x, int y, int width, int height) {
        JComboBox<String> comboBox = new JComboBox<>(new String[]{"Black", "Brown", "Blue"});
        comboBox.setBounds(x, y, width, height);
        comboBox.setVisible(true);
        comboBox.setSelectedIndex(0);
        this.add(comboBox);
        return comboBox;
    }



}


class RaceFrame extends JFrame {
    public RaceFrame(int numHorses, String weather, int distance) {
        super("Horse Race Simulation"); 
        this.setSize(600, 400);               
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        
        JLabel label = new JLabel("Race with " + numHorses + " horses, weather: " + weather + 
                                  ", distance: " + distance + " meters");
        this.add(label);                               

       
    }
}
