import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class FortuneDisplay extends JPanel
{
  private String name1, name2, name3;
  private int count1, count2, count3;

  public FortuneDisplay(String nm1, String nm2, String nm3)
  {
    setBackground(Color.WHITE);
    name1 = nm1;
    name2 = nm2;
    name3 = nm3;
    count1 = 0;   
    count2 = 0;   
    count3 = 0;   
  }

  public void vote1()
  {
    count1 += 1;
  }

  public void vote2()
  {
    count2 += 1;
  }

  public void vote3()
  {
    count3 += 1;
  }

  public String toString()
  {
    return (name1 + ": " + count1 + " " + 
            name2 + ": " + count2 + " " + 
            name3 + ": " + count3);
  }

  private int countToDegrees(int count, int total)
  {
    double degrees = ((double) count / total) * 360;
    int roundedDegrees = (int) (degrees + 0.5);
    return roundedDegrees;
  }

  private void drawSector(Graphics g, int x, int y, int r, int fromDegree, int degrees)
  {
    if (degrees > 359)
      g.fillOval(x - r, y - r, 2 * r, 2 * r);
    else
      g.fillArc(x - r, y - r, 2 * r, 2 * r, fromDegree, degrees);
  }

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    int w = getWidth();
    int h = getHeight();
    int x = w/2;
    int y = h/2;
    int r = Math.min(w, h) / 4;
    drawPieChart(g, x, y, r);
    drawLegend(g, x, y, r);
  }

  private void drawPieChart(Graphics g, int x, int y, int r)
  {
    int total = count1 + count2 + count3;
    int fromDegree = 0;

    if (total > 0)
    {
      int degrees;
        
      g.setColor(Color.RED);
      degrees = countToDegrees(count1, total);
      drawSector(g, x, y, r, fromDegree, degrees);
      fromDegree += degrees;

      g.setColor(Color.YELLOW);
      degrees = countToDegrees(count2, total);
      drawSector(g, x, y, r, fromDegree, degrees);
      fromDegree += degrees;

      g.setColor(Color.GREEN);
      degrees = Math.max(360 - fromDegree, 0);
      drawSector(g, x, y, r, fromDegree, degrees);
    }
    else
    {
      g.setColor(Color.LIGHT_GRAY);
      drawSector(g, x, y, r, fromDegree, 360);
    }
  }

  private void drawLegend(Graphics g, int x, int y, int r)
  {
    // Display the counts
    y += (r + 20);
    g.setColor(Color.BLACK);
    g.drawString( count1 + "" , x - r, y);
    g.drawString( count2 + "" , x, y);
    g.drawString( count3 + "" , x + r, y);

    // Display the colored squares
    y += 5;
    x -= 2;
    g.setColor(Color.RED);
    g.fillRect(x - r, y, 10, 10);
    g.setColor(Color.YELLOW);
    g.fillRect(x, y, 10, 10);
    g.setColor(Color.GREEN);
    g.fillRect(x + r, y, 10, 10);

    //display the labels
    y += 25;
    g.setColor(Color.BLACK);
    g.drawString( "Watchout!" + "" , x - r, y);
    g.drawString( "Meh~" + "" , x, y);
    g.drawString( "Lucky!" + "" , x + r, y);
  }
}
