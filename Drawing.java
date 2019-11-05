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
// import java.util.concurrent.TimeUnit;
//https://web.stanford.edu/class/archive/cs/cs108/cs108.1092/handouts/27PaintRepaint.pdf

// https://courses.cs.washington.edu/courses/cse341/98au/java/jdk1.2beta4/docs/api/java/awt/Canvas.html#paint(java.awt.Graphics)

class Drawing extends Canvas 
{
    //the grid size
    public static int cell_row_num = 100;
    //all of the cells
    public static Cell cells[][] = new Cell[cell_row_num][cell_row_num];
    public static void main(String[] args) 
    {
        // Drawing.Gen();
        JFrame frame = new JFrame("Game");
        Canvas canvas = new Drawing();
        canvas.setSize(cell_row_num*10, cell_row_num*10);
        canvas.setBackground(Color.green);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }
    //generating all of the cells
    public static void Gen()
    {
         System.out.println("Please input what cells you want to be alive.\nPlease use format: (cellx, celly) (cellx, celly)");
         /*InputStreamReader isr = new InputStreamReader(System.in);
         BufferedReader br = new BufferedReader(isr);
         String input = br.readLine();*/
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
         for (int yum = 0; yum < locations.length; yum++)
         {
             if (yum == locations.length - 1)
             {
                String[] arr = locations[yum].split(", ");
                arr[arr.length-1] = arr[arr.length-1].substring(0, arr[arr.length-1].length()-1);
                actualLocations.add(arr);
             }
             else
             {
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
         System.out.print(convertedLocations);

        
        for (int row = 0; row < cell_row_num; row++)
        {
            for (int column = 0; column < cell_row_num; column++)
            {
                Drawing.cells[row][column] = new Cell(row, column, false);
                //if the row is 5 or 7, the cell is true
                // if(row == 5 && column == 7)
                // {
                //     Drawing.cells[column][row] = new Cell(column,row,true);
                // }
                // else
                // {
                //     Drawing.cells[column][row] = new Cell(column,row,false);
                // }
            }
            for (int z = 0; z < convertedLocations.size(); z++)
            {
                Drawing.cells[convertedLocations.get(z)[0]][convertedLocations.get(z)[1]] = new Cell(convertedLocations.get(z)[0], convertedLocations.get(z)[1], true);
            }
        }   
    }
    //will be run every second
    public static void Game()
    {
        //columns go up and down while rows go side to side.
        //DETERMINE CELL SURROUNDING VAL
        //rows
        //System.out.println(cells.length);
        for (int i = 0; i < cells.length; i++)
        {
            //collumns
            for (int a = 0; a < cells[i].length; a++) // originally the code here was "for (int a = 0; 0 < cells[i].length; a++)" which caused it to keep on messing up for obvious reasons
            {
                //System.out.println(i + " " + a);
                int surrounding = 0;

                if (i == 0)
                {
                    if (a == 0) // left top
                    {
                        if (cells[i+1][a].alive == true)
                        {
                            surrounding += 1;
                        }
                        if (cells[i+1][a+1].alive == true)
                        {
                            surrounding += 1; 
                        }
                        if (cells[i][a+1].alive == true)
                        {
                            surrounding += 1;
                        }
                    }
                    else if (a == (cells[i].length - 1)) // left bottom
                    {
                        if (cells[i][a-1].alive == true)
                        {
                            surrounding += 1;
                        }
                        if (cells[i+1][a-1].alive == true)
                        {
                            surrounding += 1;
                        }
                        if (cells[i+1][a].alive == true)
                        {
                             surrounding += 1;
                        }
                    }
                    else // left middle 
                    {
                        if (cells[i][a+1].alive == true) // code keeps erroring here
                        {
                            surrounding += 1; 
                        }
                        if (cells[i+1][a+1].alive == true)
                        {
                            surrounding += 1; 
                        }
                        if (cells[i+1][a].alive == true)
                        {
                             surrounding += 1;
                        }
                        if (cells[i+1][a-1].alive == true)
                        {
                            surrounding += 1;
                        }
                        if (cells[i][a-1].alive == true)
                        {
                            surrounding += 1;
                        }
                    }
                }
                else if (i == cells.length - 1)
                {
                    if (a == 0) // right top
                    {
                        if (cells[i][a+1].alive == true)
                        {
                            surrounding += 1;
                        }
                        if (cells[i-1][a+1].alive == true)
                        {
                            surrounding += 1;
                        }
                        if (cells[i-1][a].alive == true)
                        {
                            surrounding += 1;
                        }
                    }
                    else if (a == cells[i].length - 1) // right bottom
                    {
                        if (cells[i][a-1].alive == true)
                        {
                            surrounding += 1;
                        }
                        if (cells[i-1][a-1].alive == true)
                        {
                            surrounding += 1; 
                        }
                        if (cells[i-1][a].alive == true)
                        {
                             surrounding += 1;
                        }
                    }
                    else // right middle 
                    {
                        if (cells[i][a+1].alive == true)
                        {
                            surrounding += 1;
                        }
                        if (cells[i-1][a+1].alive == true)
                        {
                            surrounding += 1; 
                        }
                        if (cells[i-1][a-1].alive == true)
                        {
                            surrounding += 1; 
                        }
                        if (cells[i-1][a].alive == true)
                        {
                             surrounding += 1;
                        }
                        if (cells[i][a-1].alive == true)
                        {
                            surrounding += 1;
                        }
                    }
                }
                else if (a == 0) // top middle 
                {
                    if (cells[i][a+1].alive == true)
                    {
                        surrounding += 1;
                    }
                    if (cells[i+1][a+1].alive == true)
                    {
                        surrounding += 1; 
                    }
                    if (cells[i-1][a+1].alive == true)
                    {
                        surrounding += 1;
                    }
                    if (cells[i-1][a].alive == true)
                    {
                      surrounding += 1;
                    }
                    if (cells[i+1][a].alive == true)
                    {
                        surrounding += 1;
                    }
                }
                else if (a == cells[i].length - 1) // bottom middle 
                {
                    if (cells[i][a-1].alive == true)
                    {
                        surrounding += 1;
                    }
                    if (cells[i-1][a-1].alive == true)
                    {
                        surrounding += 1; 
                    }
                    if (cells[i+1][a].alive == true)
                    {
                        surrounding += 1;
                    }
                    if (cells[i-1][a].alive == true)
                    {
                        surrounding += 1;
                    }
                    if (cells[i+1][a-1].alive == true)
                    {
                         surrounding += 1;
                    }
                }
                else // middle
                {
                    if (cells[i][a+1].alive == true)
                    {
                        surrounding += 1;
                    }
                    if (cells[i+1][a+1].alive == true)
                    {
                        surrounding += 1; 
                    }
                    if (cells[i-1][a+1].alive == true)
                    {
                        surrounding += 1; 
                    }
                    if (cells[i][a-1].alive == true)
                    {
                        surrounding += 1;
                    }
                    if (cells[i+1][a-1].alive == true)
                    {
                      surrounding += 1;
                    }
                    if (cells[i-1][a-1].alive == true)
                    {
                        surrounding += 1;
                    }
                    if (cells[i-1][a].alive == true)
                    {
                         surrounding += 1;
                    }
                    if (cells[i+1][a].alive == true)
                    {
                        surrounding += 1;
                    }
                }
                Drawing.cells[i][a].surrounding = surrounding;
            }
        }
    //PURGATORY
        //rows
        for (int i = 0; i < cells.length; i++)
        {
            //collumns
            for (int a = 0; a < cells[i].length; a++)
            {
                //RULE 1: Any live cell with fewer than two live neighbours dies, as if by underpopulation.
                if (Drawing.cells[i][a].surrounding < 2)
                {
                    //DANTE'S HELL
                    Drawing.cells[i][a].killSwitch();
                }
                //RULE 2: Any live cell with two or three live neighbours lives on to the next generation.
                if (Drawing.cells[i][a].alive == true)
                {
                    if ((Drawing.cells[i][a].surrounding < 4) && (Drawing.cells[i][a].surrounding > 1))
                    {
                        //PARADISO
                        Drawing.cells[i][a].reviveSwitch();
                    }
                }
                //RULE 3: Any live cell with more than three live neighbours dies, as if by overpopulation.
                if (Drawing.cells[i][a].surrounding > 3)
                {
                    //DANTE'S HELL
                    Drawing.cells[i][a].killSwitch();
                }
                //RULE 4: Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
                if (Drawing.cells[i][a].surrounding == 3)
                {
                    Drawing.cells[i][a].reviveSwitch();
                }
            }
        }
    }

    //for painting to the canvas
    public void paint(Graphics g)
    {
        Drawing.Gen();
        // while(true){
            //https://stackoverflow.com/questions/24104313/how-do-i-make-a-delay-in-java
            //Long second = 1L;
            //TimeUnit.SECONDS.sleep(second);
            // Drawing.Game();
        for (int row = 0; row < cell_row_num; row++)
        {
            for (int column = 0; column < cell_row_num; column++)
            {
                //if the cell is true, make the rect white
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
                    // System.out.println(cells[column][row].alive);
            }
        }
        repaint();
    }
    public void update(Graphics g)
    {
        Drawing.Game();
        for (int row = 0; row < cell_row_num; row++)
        {
            for (int column = 0; column < cell_row_num; column++)
            {
                //if the cell is true, make the rect white
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
        }
        // repaint();
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