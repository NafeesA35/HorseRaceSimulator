package Part2;
import Part1.Horse;
import Part1.Race;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


class HorsePanel extends JPanel implements ActionListener
{

    Horse horse;
    final int PANEL_HEIGHT = 40;
    final int PANEL_WIDTH = 780;
    Image horseImage;
    Timer timer;
    int xSpeed = 5;
    int startX = 0;
    int startY = 0;
    Race race;
    double pxRatio;
    GameFrame gameFrame;

    public HorsePanel(int x, int y, Horse horse , Race race, GameFrame frame) {
        this.gameFrame = frame;
        this.horse = horse;
        this.race = race;
        this.setBounds(x, y, PANEL_WIDTH, PANEL_HEIGHT);
        //this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.pink);
        horseImage = new ImageIcon(horse.getImagePath()).getImage();

        pxRatio = (double)(PANEL_WIDTH - horseImage.getWidth(null)) / race.getRaceLength();

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
        horse.incrementTime();
        // Update the position of the horse image
        if(horse.hasFallen()){
            startX = 0;
            horse.incrementTotalFalls();
            timer.stop();


            if(gameFrame.allFallen()){
                gameFrame.displayLoss();
                return;
            }

            return;
        }

        if(startX + horseImage.getWidth(null) >= PANEL_WIDTH) {
            timer.stop();
            return;
        }else if (Race.shouldMove(horse)){
            this.race.moveHorseGui(horse);
            if(horse.getBreed().equals("Arabian")){
                startX = (int)(horse.getDistanceTravelled() * pxRatio);
            }else if(horse.getBreed().equals("Friesian")){
                startX = (int)(horse.getDistanceTravelled() * pxRatio);
            }else if(horse.getBreed().equals("Mustang")){
                startX = (int)(horse.getDistanceTravelled() * pxRatio);
            }else{
                startX = (int)(horse.getDistanceTravelled() * pxRatio);
            }
        }

        if (race.winner(horse)) {
            horse.increaseConfidence();
            repaint();
            timer.stop();
            gameFrame.displayWinner(horse);
            return;
        }



        repaint();

    }

    // We have established a 1:40 ratio between the horse image and the panel width
    // 1 horse image = 40 pixels in width

}