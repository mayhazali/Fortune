/**
 * Implements a Java Swing program that generates a pie chart
 * showing your fortune based on your selection of a number sequence
 */

import java.awt.Color;
import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Fortune extends JFrame
{
  public Fortune()
  {
    super("Press buttons in any sequence to generate your fortune");

    Container c = getContentPane();
    c.setBackground(Color.WHITE);
    FortuneDisplay chart = new FortuneDisplay("1", "2", "3");
    FortuneControl controls = new FortuneControl(chart);
    c.add(chart, BorderLayout.CENTER);
    c.add(controls, BorderLayout.SOUTH);
  }

 public static void main(String[] args)
  {
    Fortune f = new Fortune();
    f.setBounds(300, 300, 400, 400);
    f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    f.setVisible(true);
  }
}

