import java.awt.Color; //Import the Graphic Library for Color (Abstract Window Toolkit)
import java.awt.Canvas; //Import the Graphic Library for Canvas (Abstract Window Toolkit)
import java.awt.Graphics; //Import the Graphic Library for Graphics (Abstract Window Toolkit)
//import java.awt.Component; //Import the Graphic Library for Components (Abstract Window Toolkit)
import javax.swing.JFrame;//Import the Graphic Library for JFrame (Abstract Window Toolkit)
import java.util.*;
//import java.io.*;
// import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
import java.util.Scanner;
import javax.swing.*; 
import java.awt.event.*; 
// import java.util.concurrent.TimeUnit;
//https://web.stanford.edu/class/archive/cs/cs108/cs108.1092/handouts/27PaintRepaint.pdf
import java.util.concurrent.TimeUnit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import javax.swing.JFrame;
import javax.swing.JTextArea;

// https://courses.cs.washington.edu/courses/cse341/98au/java/jdk1.2beta4/docs/api/java/awt/Canvas.html#paint(java.awt.Graphics)




//PULSAR PERIOD 3
// https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life#/media/File:Game_of_life_pulsar.gif
// (5, 5) (6, 5) (7, 5) (3, 7) (3, 8) (3, 9) (8, 7) (8, 8) (8, 9) (5, 10) (6, 10) (7, 10) (11, 5) (12, 5) (13, 5) (10, 7) (10, 8) (10, 9) (15, 7) (15, 8) (15, 9) (11, 10) (12, 10) (13, 10) (5, 17) (6, 17) (7, 17) (11, 17) (12, 17) (13, 17) (3, 15) (8, 15) (10, 15) (15, 15) (3, 14) (8, 14) (10, 14) (15, 14) (8, 13) (3, 13) (10, 13) (15, 13) (5, 12) (6, 12) (7, 12) (11, 12) (12, 12) (13, 12)


//GOSPER'S GILIDING GUN
// https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life#/media/File:Game_of_life_glider_gun.svg
// (2, 6) (2, 7) (3, 6) (3, 7) (12, 6) (12, 7) (12, 8) (13, 9) (14, 10) (15, 10) (17, 9) (18, 8) (18, 7) (19, 7) (18, 6) (17, 5) (16, 7) (15, 4) (14, 4) (13, 5) (36, 4) (36, 5) (37, 4) (37, 5) (26, 2) (26, 3) (24, 3) (23, 4) (23, 5) (23, 6) (22, 4) (22, 5) (22, 6) (24, 7) (26, 7) (26, 8)



class Drawing extends Canvas implements MouseListener, MouseMotionListener
{
    // the grid size
    public static int cell_row_num = 100;
    // all of the cells
    public static Cell cells[][] = new Cell[cell_row_num][cell_row_num];

    public static void main(String[] args) 
    {
        // Drawing.Gen();
        JFrame frame = new JFrame("Game");
        Canvas canvas = new Drawing();
        canvas.setSize(cell_row_num * 10, cell_row_num * 10);
        canvas.setBackground(Color.green);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }

    // generating all of the cells


    public void mouseClicked(MouseEvent e) 
    {
        if (e.getButton() == MouseEvent.BUTTON1) 
        {
            System.out.println("Click position (X, Y):  " + e.getX() + ", " + e.getY());
        }
    }
    public void mouseMoved(MouseEvent e) 
    { 
        int noerror;
    }
    public void mouseExited(MouseEvent e) 
    { 
        int noerror;
    } 
  
    public void mouseEntered(MouseEvent e) 
    { 
        int noerror;
    } 
  
    public void mouseReleased(MouseEvent e) 
    { 
        int noerror;
    } 
  
    public void mousePressed(MouseEvent e) 
    { 
        int noerror;
    } 


    public static void Gen() 
    {
        /*
         * InputStreamReader isr = new InputStreamReader(System.in); BufferedReader br =
         * new BufferedReader(isr); String input = br.readLine();
         */
        for (int row = 0; row < cell_row_num; row++) 
        {
            for (int column = 0; column < cell_row_num; column++) 
            {
                Drawing.cells[row][column] = new Cell(row, column, false);
            }
        }
        boolean input_toggle = true; // if true, you draw, if false, you input with the console
        if (!input_toggle)
        {
            System.out.println("Please input what cells you want to be alive.\nPlease use format: (cellx, celly) (cellx, celly)");
            Scanner scanner = new Scanner(System.in);
            String input;
            input = scanner.nextLine();
            scanner.close();
            String[] locations = input.split("\\) ");
            for (int i = 0; i < locations.length; i++) 
            {
                locations[i] = locations[i].substring(1, locations[i].length());
            }
            ArrayList<String[]> actualLocations = new ArrayList<String[]>();
            for (int yum = 0; yum < locations.length; yum++) {
                if (yum == locations.length - 1) {
                    String[] arr = locations[yum].split(", ");
                    arr[arr.length - 1] = arr[arr.length - 1].substring(0, arr[arr.length - 1].length() - 1);
                    actualLocations.add(arr);
                } else {
                    actualLocations.add(locations[yum].split(", "));
                }
            }
            ArrayList<int[]> convertedLocations = new ArrayList<int[]>();
            for (int bruh = 0; bruh < actualLocations.size(); bruh++) 
            {
                int[] loc = new int[2];
                loc[0] = Integer.valueOf(actualLocations.get(bruh)[0]);
                loc[1] = Integer.valueOf(actualLocations.get(bruh)[1]);
                convertedLocations.add(loc);
            }
            for (int z = 0; z < convertedLocations.size(); z++)
            {
                cells[convertedLocations.get(z)[0]][convertedLocations.get(z)[1]] = new Cell(convertedLocations.get(z)[0], convertedLocations.get(z)[1], true);
            }
        }
    }

    // will be run every second
    public static void Game() 
    {
        // columns go up and down while rows go side to side.
        // DETERMINE CELL SURROUNDING VAL
        // rows
        // System.out.println(cells.length);
        for (int i = 0; i < cells.length; i++) 
        {
            // collumns
            for (int a = 0; a < cells[i].length; a++) // originally the code here was "for (int a = 0; 0 <
                                                      // cells[i].length; a++)" which caused it to keep on messing up
                                                      // for obvious reasons
            {
                // System.out.println(i + " " + a);
                int surrounding = 0;

                if (i == 0) 
                {
                    if (a == 0) // left top
                    {
                        if (cells[i + 1][a].alive == true) 
                        {
                            surrounding += 1;
                        }
                        if (cells[i + 1][a + 1].alive == true) 
                        {
                            surrounding += 1;
                        }
                        if (cells[i][a + 1].alive == true) 
                        {
                            surrounding += 1;
                        }
                    } else if (a == (cells[i].length - 1)) // left bottom
                    {
                        if (cells[i][a - 1].alive == true) 
                        {
                            surrounding += 1;
                        }
                        if (cells[i + 1][a - 1].alive == true) 
                        {
                            surrounding += 1;
                        }
                        if (cells[i + 1][a].alive == true) 
                        {
                            surrounding += 1;
                        }
                    } else // left middle
                    {
                        if (cells[i][a + 1].alive == true) // code keeps erroring here
                        {
                            surrounding += 1;
                        }
                        if (cells[i + 1][a + 1].alive == true) 
                        {
                            surrounding += 1;
                        }
                        if (cells[i + 1][a].alive == true) 
                        {
                            surrounding += 1;
                        }
                        if (cells[i + 1][a - 1].alive == true) 
                        {
                            surrounding += 1;
                        }
                        if (cells[i][a - 1].alive == true) 
                        {
                            surrounding += 1;
                        }
                    }
                } 
                else if (i == cells.length - 1) 
                {
                    if (a == 0) // right top
                    {
                        if (cells[i][a + 1].alive == true) 
                        {
                            surrounding += 1;
                        }
                        if (cells[i - 1][a + 1].alive == true) 
                        {
                            surrounding += 1;
                        }
                        if (cells[i - 1][a].alive == true) 
                        {
                            surrounding += 1;
                        }
                    } 
                    else if (a == cells[i].length - 1) // right bottom
                    {
                        if (cells[i][a - 1].alive == true) 
                        {
                            surrounding += 1;
                        }
                        if (cells[i - 1][a - 1].alive == true) 
                        {
                            surrounding += 1;
                        }
                        if (cells[i - 1][a].alive == true) 
                        {
                            surrounding += 1;
                        }
                    } 
                    else // right middle
                    {
                        if (cells[i][a + 1].alive == true) 
                        {
                            surrounding += 1;
                        }
                        if (cells[i - 1][a + 1].alive == true) 
                        {
                            surrounding += 1;
                        }
                        if (cells[i - 1][a - 1].alive == true) 
                        {
                            surrounding += 1;
                        }
                        if (cells[i - 1][a].alive == true) 
                        {
                            surrounding += 1;
                        }
                        if (cells[i][a - 1].alive == true) 
                        {
                            surrounding += 1;
                        }
                    }
                } 
                else if (a == 0) // top middle
                {
                    if (cells[i][a + 1].alive == true) 
                    {
                        surrounding += 1;
                    }
                    if (cells[i + 1][a + 1].alive == true) 
                    {
                        surrounding += 1;
                    }
                    if (cells[i - 1][a + 1].alive == true) 
                    {
                        surrounding += 1;
                    }
                    if (cells[i - 1][a].alive == true) 
                    {
                        surrounding += 1;
                    }
                    if (cells[i + 1][a].alive == true) 
                    {
                        surrounding += 1;
                    }
                } 
                else if (a == cells[i].length - 1) // bottom middle
                {
                    if (cells[i][a - 1].alive == true) 
                    {
                        surrounding += 1;
                    }
                    if (cells[i - 1][a - 1].alive == true) 
                    {
                        surrounding += 1;
                    }
                    if (cells[i + 1][a].alive == true) 
                    {
                        surrounding += 1;
                    }
                    if (cells[i - 1][a].alive == true) 
                    {
                        surrounding += 1;
                    }
                    if (cells[i + 1][a - 1].alive == true) 
                    {
                        surrounding += 1;
                    }
                } 
                else // middle
                {
                    if (cells[i][a + 1].alive == true) 
                    {
                        surrounding += 1;
                    }
                    if (cells[i + 1][a + 1].alive == true) 
                    {
                        surrounding += 1;
                    }
                    if (cells[i - 1][a + 1].alive == true) 
                    {
                        surrounding += 1;
                    }
                    if (cells[i][a - 1].alive == true) 
                    {
                        surrounding += 1;
                    }
                    if (cells[i + 1][a - 1].alive == true) 
                    {
                        surrounding += 1;
                    }
                    if (cells[i - 1][a - 1].alive == true) 
                    {
                        surrounding += 1;
                    }
                    if (cells[i - 1][a].alive == true) 
                    {
                        surrounding += 1;
                    }
                    if (cells[i + 1][a].alive == true) 
                    {
                        surrounding += 1;
                    }
                }
                Drawing.cells[i][a].surrounding = surrounding;
                // Drawing.cells[i][a].surrounding = backup_surrounding(i, a);
                /*
                 * if (i == 11 && a == 11) { System.out.println(backup_surrounding(i, a)); }
                 */
            }
        }
        // PURGATORY
        // rows
        for (int i = 0; i < cells.length; i++) 
        {
            // collumns
            for (int a = 0; a < cells[i].length; a++) 
            {
                // RULE 1: Any live cell with fewer than two live neighbours dies, as if by
                // underpopulation.
                if (Drawing.cells[i][a].surrounding < 2) 
                {
                    // DANTE'S HELL
                    Drawing.cells[i][a].killSwitch();
                }
                // RULE 2: Any live cell with two or three live neighbours lives on to the next
                // generation.
                if (Drawing.cells[i][a].alive == true) 
                {
                    if ((Drawing.cells[i][a].surrounding < 4) && (Drawing.cells[i][a].surrounding > 1)) 
                    {
                        // PARADISO
                        Drawing.cells[i][a].reviveSwitch();
                    }
                }
                // RULE 3: Any live cell with more than three live neighbours dies, as if by
                // overpopulation.
                if (Drawing.cells[i][a].surrounding > 3) 
                {
                    // DANTE'S HELL
                    Drawing.cells[i][a].killSwitch();
                }
                // RULE 4: Any dead cell with exactly three live neighbours becomes a live cell,
                // as if by reproduction.
                if (Drawing.cells[i][a].surrounding == 3) 
                {
                    Drawing.cells[i][a].reviveSwitch();
                }
            }
        }
    }

    // for painting to the canvas
    public void paint(Graphics g, MouseEvent yeetus) 
    {
        Drawing.Gen();
        while (true) 
        {
            // MouseEvent yeetus;
            //   System.out.println("Number of click: " + e.getClickCount());
    
            // if (yeetus.getButton() == MouseEvent.BUTTON1) 
            // {
            //     System.out.println("Click position (X, Y):  " + yeetus.getX() + ", " + yeetus.getY());
            // }

            // https://stackoverflow.com/questions/24104313/how-do-i-make-a-delay-in-java
            try 
            {
                //TimeUnit.SECONDS.sleep(1L);
                TimeUnit.MILLISECONDS.sleep(50);
            } 
            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
         /*try 
        {
            Thread.sleep(1000);
        } 
        catch(InterruptedException ex) 
        {
            Thread.currentThread().interrupt();
        }*/
        // Drawing.Game();
            Drawing.Game();
            for (int row = 0; row < cell_row_num; row++) 
            {
                for (int column = 0; column < cell_row_num; column++) 
                {
                // if the cell is true, make the rect white
                    if (Drawing.cells[row][column].alive) 
                    {
                        g.setColor(Color.white);
                        g.fillRect(row * 10, column * 10, 10, 10);
                    } 
                    else 
                    {
                        g.setColor(Color.black);
                        g.fillRect(row * 10, column * 10, 10, 10);
                    }
                }   
                // System.out.println(cells[column][row].alive);
            }
            repaint();
        }
    }

    public void update(Graphics g) 
    {
        Drawing.Game();
        for (int row = 0; row < cell_row_num; row++) 
        {
            for (int column = 0; column < cell_row_num; column++) 
            {
                // if the cell is true, make the rect white
                if (Drawing.cells[row][column].alive) 
                {
                    g.setColor(Color.white);
                    g.fillRect(row * 10, column * 10, 10, 10);
                } else 
                {
                    g.setColor(Color.black);
                    g.fillRect(row * 10, column * 10, 10, 10);
                }
            }
        }
        // repaint();
    }

    private static int backup_surrounding(int x, int y)
    {
        int surrounding = 0;
        for (int i = 0; i < cells.length; i++)
        {
            for (int a = 0; a < cells[i].length; a++)
            {
                if (cells[i][a].alive == true)
                {
                    if ((i == x || i == x + 1 || i == x - 1) && (a == y || a == y + 1 || a == y - 1) && !(i == x && a == y))
                    {
                        surrounding += 1;
                    }
                }
            }
        }
        return surrounding; 
    }

    @Override
    public void mouseDragged(MouseEvent arg0) 
    {
        // TODO Auto-generated method stub
    }
}

class Cell 
{
    // these variables were originally static, which would have definitely broke the code
    public int ypos;
    public int xpos;
    public boolean alive;
    public int surrounding;
    Cell(int x, int y, boolean living)
    {
        this.ypos = y;
        this.xpos = x;
        this.alive = living;
        this.surrounding = 0;
    }
    public void returnVals() 
    {
        if (alive == true)
        {
            System.out.println("Cell at (" + xpos + ", " + ypos + ") is alive.\n");
        }
        else
        {
            System.out.println("Cell at (" + xpos + ", " + ypos + ") is dead.\n");
        }
    }
    public void killSwitch()
    {
        this.alive = false;
    }
    public void reviveSwitch()
    {
        this.alive = true;
    }
}  