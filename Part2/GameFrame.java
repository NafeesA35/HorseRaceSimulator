// Import
package Part2;

import Part1.Horse;
import Part1.Race;
import Part2.HorsePanel;
import javax.swing.*;

public class GameFrame extends JFrame
{
    HorsePanel horsePanel;

    public GameFrame()
    {
        HorsePanel horsePanel = new HorsePanel(0 ,30, new Horse('■', "Opio", 0.5));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.add(horsePanel);
        this.setSize(800, 600);
        this.setResizable(false);
        this.setVisible(true);
        
    }
}



