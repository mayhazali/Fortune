import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JButton;

public class FortuneControl extends JPanel
                          implements ActionListener
{
  private JButton button1, button2, button3;
  private FortuneDisplay chartPanel;

  public FortuneControl(FortuneDisplay chart)
  {
    chartPanel = chart;

    button1 = new JButton("1");
    button1.setPreferredSize(new Dimension(80, 30));
    button1.setToolTipText("1");
    button1.addActionListener(this);

    button2 = new JButton("2");
    button2.setPreferredSize(new Dimension(80, 30));
    button2.setToolTipText("2");
    button2.addActionListener(this);

    button3 = new JButton("3");
    button3.setPreferredSize(new Dimension(80, 30));
    button3.setToolTipText("3");
    button3.addActionListener(this);

    add(button1);
    add(button2);
    add(button3);
  }

  /**
   * Processes button events
   */
  public void actionPerformed(ActionEvent e)
  {
    JButton button = (JButton)e.getSource();

    int randNum = (int)(Math.random() * 3);
    if (randNum == 0)
    {
      if (button == button1)
        chartPanel.vote1();
      else if (button == button2)
        chartPanel.vote2();
      else if (button == button3)
        chartPanel.vote3();
    }
    else if (randNum == 1)
    {
      if (button == button1)
        chartPanel.vote2();
      else if (button == button2)
        chartPanel.vote3();
      else if (button == button3)
        chartPanel.vote1();
    }
    else
    {
      if (button == button1)
        chartPanel.vote3();
      else if (button == button2)
        chartPanel.vote1();
      else if (button == button3)
        chartPanel.vote2();
    }

    
    
    chartPanel.repaint();
  }
}
