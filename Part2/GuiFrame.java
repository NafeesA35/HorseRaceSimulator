package Part2;

import Part1.Horse;
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

    
    private JComboBox<String> comboBox;     
    private JSlider distanceSlider;         
    private JButton submitButton;
    private JComboBox<String> horsesComboBox;
    private Horse[] horses; // Array to hold horse objects        

    public GuiFrame() {
        super("Horse Race Sim");
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
        JComboBox<String> horse1Breed = new JComboBox<>(breed);
        horse1Breed.setBounds(180, 255, 80, 20);
        this.add(horse1Breed);



        JLabel horse2Label = createLabel("Horse 2: Roach :", 30, 280, 200, 30);
        this.add(horse2Label);
        horse2Label.setVisible(true);

        JComboBox<String> horse2Breed = new JComboBox<>(breed);
        horse2Breed.setBounds(180, 285, 80, 20);
        this.add(horse2Breed);
        horse2Breed.setVisible(true);

        

        JLabel horse3Label = createLabel("Horse 3: Pasta :", 30, 310, 200, 30);
        this.add(horse3Label);
        horse3Label.setVisible(true);

        JComboBox<String> horse3Breed = new JComboBox<>(breed);
        horse3Breed.setBounds(180, 315, 80, 20);
        this.add(horse3Breed);
        horse3Breed.setVisible(true);

        JLabel horse4Label = createLabel("Horse 4: Khat :", 30, 340, 200, 30);
        this.add(horse4Label);
        horse4Label.setVisible(true);

        JComboBox<String> horse4Breed = new JComboBox<>(breed);
        horse4Breed.setBounds(180, 345, 80, 20);
        this.add(horse4Breed);
        horse4Breed.setVisible(true);
        

        JLabel horse5Label = createLabel("Horse 5: Ty: ", 30, 370, 200, 30);
        this.add(horse5Label);
        horse5Label.setVisible(true);

        JComboBox<String> horse5Breed = new JComboBox<>(breed);
        horse5Breed.setBounds(180, 375, 80, 20);
        this.add(horse5Breed);
        horse5Breed.setVisible(true);
        




        this.setResizable(false);
        this.setVisible(true); // Make the frame visible

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Check if the event source is the submit button
        if (e.getSource() == submitButton) {

            int numHorses = Integer.parseInt((String) horsesComboBox.getSelectedItem());
            String weather = (String) comboBox.getSelectedItem(); 


            int distance = distanceSlider.getValue();


            RaceFrame raceFrame = new RaceFrame(numHorses, weather, distance);
            raceFrame.setVisible(true);
            this.dispose();

        }
    }

    public JLabel createLabel(String text, int x, int y , int width, int height) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setVisible(true);
        return label;
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
