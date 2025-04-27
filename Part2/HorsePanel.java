package Part2;
import Part1.Horse;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


class HorsePanel extends JPanel implements ActionListener
{
    Horse horse;
    final int PANEL_HEIGHT = 40;
    int raceDistance;
    Image horseImage;
    Timer timer;
    int xSpeed = 5;
    int startX = 0;
    int startY = 0;

    public HorsePanel(int x, int y, Horse horse , int distance) {

        this.horse = horse;
        this.raceDistance = distance;
        this.setBounds(x, y, distanceToPanelEnd(distance), PANEL_HEIGHT);
        //this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.BLUE);
        horseImage = new ImageIcon(horse.getImagePath()).getImage();

        timer = new Timer(100, this); // this here refers to event listener
        timer.start();

    }

    public void paint(Graphics g) {

        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(horseImage, startX, startY, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Update the position of the horse image
        if(startX + horseImage.getWidth(null) >= distanceToPanelEnd(raceDistance) - 20) {
            return;
        }
        startX += xSpeed;

        // Repaint the panel to show the updated position
        repaint();
    }

    public int distanceToPanelEnd(int distance){
        // MINIMUM DISTANCE IS 10
        // MINIMUM PANEL WIDTH IS 500
        int panelWidth = 400;
        final int SCALE = 25;
        for (int i = 10; i < distance; i++) {
            panelWidth = panelWidth + SCALE;
        }
        return panelWidth;
    }

}