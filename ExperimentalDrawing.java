import java.util.*;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
//https://web.stanford.edu/class/archive/cs/cs108/cs108.1092/handouts/27PaintRepaint.pdf
// https://courses.cs.washington.edu/courses/cse341/98au/java/jdk1.2beta4/docs/api/java/awt/Canvas.html#paint(java.awt.Graphics)
import java.awt.event.MouseWheelEvent;

//PULSAR PERIOD 3
// https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life#/media/File:Game_of_life_pulsar.gif
// (5, 5) (6, 5) (7, 5) (3, 7) (3, 8) (3, 9) (8, 7) (8, 8) (8, 9) (5, 10) (6, 10) (7, 10) (11, 5) (12, 5) (13, 5) (10, 7) (10, 8) (10, 9) (15, 7) (15, 8) (15, 9) (11, 10) (12, 10) (13, 10) (5, 17) (6, 17) (7, 17) (11, 17) (12, 17) (13, 17) (3, 15) (8, 15) (10, 15) (15, 15) (3, 14) (8, 14) (10, 14) (15, 14) (8, 13) (3, 13) (10, 13) (15, 13) (5, 12) (6, 12) (7, 12) (11, 12) (12, 12) (13, 12)

//GOSPER'S GILIDING GUN
// https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life#/media/File:Game_of_life_glider_gun.svg
// (2, 6) (2, 7) (3, 6) (3, 7) (12, 6) (12, 7) (12, 8) (13, 9) (14, 10) (15, 10) (17, 9) (18, 8) (18, 7) (19, 7) (18, 6) (17, 5) (16, 7) (15, 4) (14, 4) (13, 5) (36, 4) (36, 5) (37, 4) (37, 5) (26, 2) (26, 3) (24, 3) (23, 4) (23, 5) (23, 6) (22, 4) (22, 5) (22, 6) (24, 7) (26, 7) (26, 8)

//java.awt.event.MouseAdapter
class ExperimentalDrawing extends java.awt.Canvas 
{
    private static class fra extends JFrame implements java.awt.event.MouseListener, java.awt.event.MouseMotionListener, java.awt.event.MouseWheelListener 
    {
        JFrame frame = new JFrame("Ur Mom ;)");
        public void mouseWheelMoved(MouseWheelEvent e) 
        {
            String message;
            int notches = e.getWheelRotation();
            if (notches < 0) 
            {
                message = "Mouse wheel moved UP " + -notches + " notch(es)\n";
                cellScale += (-notches);
                scrolled = true;
            } 
            else 
            {
                message = "Mouse wheel moved DOWN " + notches + " notch(es)\n";
                cellScale -= notches;
                if (cellScale <= 0) 
                {
                    cellScale = 1;
                }
                scrolled = true;
            }
            if (e.getScrollType() == MouseWheelEvent.WHEEL_UNIT_SCROLL) 
            {
                message += "Scroll type: WHEEL_UNIT_SCROLL\n";
                message += "Scroll amount: " + e.getScrollAmount() + " unit increments per notch\n";
                message += "Units to scroll: " + e.getUnitsToScroll() + " unit increments\n";
            } 
            else 
            { // scroll type == MouseWheelEvent.WHEEL_BLOCK_SCROLL
                message += "Scroll type: WHEEL_BLOCK_SCROLL\n";
            }
            System.out.println(message);
        }

        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) 
        {
            System.out.println("Click position (X, Y):  " + e.getX() + ", " + e.getY());
        }

        @Override
        public void mouseMoved(java.awt.event.MouseEvent e) 
        {
            System.out.println("Click position (X, Y):  " + e.getX() + ", " + e.getY());
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) 
        {
            System.out.println("Click position (X, Y):  " + e.getX() + ", " + e.getY());
        }

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) 
        {
            System.out.println("Click position (X, Y):  " + e.getX() + ", " + e.getY());
        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) 
        {
            System.out.println("Click position (X, Y):  " + e.getX() + ", " + e.getY());
        }

        @Override
        public void mousePressed(java.awt.event.MouseEvent e) 
        {
            if (e.getButton() == java.awt.event.MouseEvent.BUTTON1) 
            {
                System.out.println("Click position (X, Y): " + e.getX() + ", " + e.getY());
                if (input_toggle) 
                {
                    cells[e.getX() / cellScale][e.getY() / cellScale].alive = true;
                }
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) 
        {
            if (e.getButton() == java.awt.event.MouseEvent.BUTTON1) 
            {
                System.out.println("Click position (X, Y): " + e.getX() + ", " + e.getY());
                if (input_toggle) 
                {
                    cells[e.getX() / cellScale][e.getY() / cellScale].alive = true;
                }
            }
        }
    }
    // the grid size
    static int cell_row_num = 100;
    // how big is a cell on the screen
    static int cellScale = 10;
    // all of the cells
    static Cell cells[][] = new Cell[cell_row_num][cell_row_num];
    // unimportant var used in commented out code
    static String theIn;
    static boolean scrolled = false; // if the user scrolled to adjust zoom
    static boolean input_toggle = false; // if true, you draw, if false, you input with the console 

    Long duration = 10L; // how long between each update

    public static void main(String[] args) 
    {
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fra yeet = new fra();
        yeet.frame.addMouseListener(yeet);
        yeet.frame.addMouseMotionListener(yeet);
        yeet.frame.addMouseWheelListener(yeet);
        yeet.addMouseListener(yeet);
        yeet.addMouseMotionListener(yeet);
        yeet.addMouseWheelListener(yeet);
        java.awt.Canvas canvas = new Drawing();
        canvas.setSize(cell_row_num * 10, cell_row_num * 10);
        canvas.setBackground(java.awt.Color.CYAN);
        yeet.frame.add(canvas);
        yeet.frame.pack();
        yeet.frame.setVisible(true);
    }

    public static void Gen() // generates all the cells before the game starts
    {
        for (int row = 0; row < cell_row_num; row++) 
        {
            for (int column = 0; column < cell_row_num; column++) 
            {
                Drawing.cells[row][column] = new Cell(row, column, false);
            }
        }
        System.out.println("Do you want to draw or use the console to input? Input d for draw and c for console.");
        Scanner scan = new Scanner(System.in);
        String choice;
        choice = scan.nextLine().toLowerCase();
        boolean chosen = false;
        while (!chosen) 
        {
            if (choice.equals("c")) 
            {
                input_toggle = false;
                chosen = true;
            } else if (choice.equals("d")) 
            {
                input_toggle = true;
                chosen = true;
            } else 
            {
                System.out.println("Input " + choice + " is invalid. Please input c or d");
                choice = scan.nextLine().toLowerCase();
            }
        }
        if (!input_toggle) 
        {
            System.out.println("Please input what cells you want to be alive.\nPlease use format: (cellx, celly) (cellx, celly)");
            String input;
            input = scan.nextLine();
            theIn = input;
            scan.close();
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
                    arr[arr.length - 1] = arr[arr.length - 1].substring(0, arr[arr.length - 1].length() - 1);
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
            for (int z = 0; z < convertedLocations.size(); z++) 
            {
                cells[convertedLocations.get(z)[0]][convertedLocations.get(z)[1]] = new Cell(convertedLocations.get(z)[0], convertedLocations.get(z)[1], true);
            }
        }
    }

    // is run in a while loop; it is the game logic
    public static void Game() 
    {
        // columns go up and down while rows go side to side.
        boolean border_top = false;
        boolean border_bottom = false;
        boolean border_left = false;
        boolean border_right = false;

        for (int i = 0; i < cells.length; i++) // rows
        {
            // originally the code here was "for (int a = 0; 0 < cells[i].length; a++)" which caused it to keep on messing up for obvious reasons
            for (int a = 0; a < cells[i].length; a++) // columns
            {
                int surrounding = 0;
                if (i == 0) {
                    if (cells[i][a].alive) 
                    {
                        border_left = true;
                    }
                    if (a == 0) // left top
                    {
                        if (cells[i][a].alive) 
                        {
                            border_top = true;
                        }
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
                    } 
                    else if (a == (cells[i].length - 1)) // left bottom
                    {
                        if (cells[i][a].alive) 
                        {
                            border_bottom = true;
                        }
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
                    } 
                    else // left middle
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
                    if (cells[i][a].alive) 
                    {
                        border_right = true;
                    }
                    if (a == 0) // right top
                    {
                        if (cells[i][a].alive) 
                        {
                            border_top = true;
                        }
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
                        if (cells[i][a].alive) 
                        {
                            border_bottom = true;
                        }
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
                    if (cells[i][a].alive) 
                    {
                        border_top = true;
                    }
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
                } else if (a == cells[i].length - 1) // bottom middle
                {
                    if (cells[i][a].alive) 
                    {
                        border_bottom = true;
                    }
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
                } else // middle
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
        if (border_bottom || border_top || border_left || border_right) 
        {
            int old_num = cell_row_num;
            cell_row_num += 2; // once you think about it, adding ten kinda made sense

            Cell newCells[][] = new Cell[cell_row_num][cell_row_num];
            for (int i = 0; i < newCells.length; i++) 
            {
                for (int a = 0; a < newCells[i].length; a++) 
                {
                    newCells[i][a] = new Cell(i, a, false);
                }
            }
            for (int i = 0; i < cells.length; i++) 
            {
                for (int a = 0; a < cells[i].length; a++) 
                {
                    newCells[i + ((cell_row_num - old_num) / 2)][a + ((cell_row_num - old_num) / 2)] = new Cell(i, a, cells[i][a].alive);
                }
            }
            if (!scrolled)
            {
                if (cellScale > 1) 
                {
                    cellScale--;
                }
            }
            cells = newCells;
        }
    }

    // for painting to the canvas
    public void paint(java.awt.Graphics g/* , MouseEvent yeetus */) 
    {
        Drawing.Gen();
        while (true) 
        {
            // https://stackoverflow.com/questions/24104313/how-do-i-make-a-delay-in-java
            try 
            {
                // TimeUnit.SECONDS.sleep(1L);
                java.util.concurrent.TimeUnit.MILLISECONDS.sleep(duration);
            } 
            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
            Drawing.Game();
            for (int row = 0; row < cell_row_num; row++) 
            {
                for (int column = 0; column < cell_row_num; column++) 
                {
                    if (Drawing.cells[row][column].alive) 
                    {
                        g.setColor(java.awt.Color.white);
                        g.fillRect(row * cellScale, column * cellScale, cellScale, cellScale);
                    } 
                    else 
                    {
                        g.setColor(java.awt.Color.black);
                        g.fillRect(row * cellScale, column * cellScale, cellScale, cellScale);
                    }
                }
                // Blacks out space not used by the two dimensional array of cells
                /* diagonal */g.fillRect(cellScale * Drawing.cells[0].length, cellScale * Drawing.cells[0].length,
                        1000 - (cellScale * Drawing.cells[0].length), 1000 - (cellScale * Drawing.cells[0].length));
                /* right */g.fillRect(cellScale * Drawing.cells[0].length, 0,
                        1000 - (cellScale * Drawing.cells[0].length), 1000);
                /* left */g.fillRect(0, cellScale * Drawing.cells[0].length, 1000,
                        1000 - (cellScale * Drawing.cells[0].length));
            }
            repaint();
        }
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


