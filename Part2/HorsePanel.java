package Part2;
import Part1.Horse;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


class HorsePanel extends JPanel implements ActionListener
{
    Horse horse;
    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 40;

    Image horseImage;
    Timer timer;
    int xSpeed = 5;
    int startX = 0;
    int startY = 0;

    public HorsePanel(int x, int y, Horse horse) {

        this.horse = horse;
        this.setBounds(x, y, PANEL_WIDTH, PANEL_HEIGHT);
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
        if(startX + horseImage.getWidth(null) >= PANEL_WIDTH - 20) {
            return;
        }
        startX += xSpeed;

        // Repaint the panel to show the updated position
        repaint();
    }

}