package Part2;

import Part1.Horse;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;

public class Gui {
    public void startRaceGui(Horse[] horses, int raceLength) {
        // Create a JFrame for the GUI
        JFrame frame = new JFrame("Horse Race Sim");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);


        frame.add(addPanel(0, 50, 800, 50, Color.BLUE));
        frame.add(addPanel(0, 150, 800, 50, Color.RED));
        frame.add(addPanel(0, 250, 800, 50, Color.GREEN));
        frame.add(addPanel(0, 350, 800, 50, Color.YELLOW));
        frame.add(addPanel(0, 450, 800, 50, Color.ORANGE));

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

