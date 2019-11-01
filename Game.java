import java.util.Scanner;  // Import the Scanner class
import java.awt.Color; //Import the Graphic Library for Color (Abstract Window Toolkit)
import java.awt.Canvas; //Import the Graphic Library for Canvas (Abstract Window Toolkit)
import java.awt.Graphics; //Import the Graphic Library for Graphics (Abstract Window Toolkit)
import javax.swing.JFrame;//Import the Graphic Library for JFrame (Abstract Window Toolkit)


// public class Game {
//     static int cell_row_num = 10;
//     final public static Cell cells[][] = new Cell[cell_row_num][cell_row_num];

//     public static void main(String[] args){
//         for(int column = 0; column < cell_row_num; column++){
//             for(int row = 0; row < cell_row_num; row++){
//                 cells[column][row] = new Cell();
//                 if(row == 5 || row == 7){
//                     cells[column][row].setStuff(column, row, true);
//                 }else{
//                     cells[column][row].setStuff(column, row, false);
//                 }
//                 // cells[column][row].returnVals();
//                 System.out.println(cells[column][row].alive);
//             }
//         }
//     }
// }
class Cell 
{
    // these variables were originally static, which would have definitely broke the code
    public int ypos;
    public int xpos;
    public boolean alive;
    Cell(int x, int y, boolean living)
    {
        ypos = y;
        xpos = x;
        alive = living;
    }
    public void returnVals() 
    {
        if(alive == true)
        {
            System.out.println("Cell at (" + xpos + ", " + ypos + ") is alive.\n");
        }
        else
        {
            System.out.println("Cell at (" + xpos + ", " + ypos + ") is dead.\n");
        }
    }
    // why was this function originally static???
    // I commented out this function because the variable that it is returning is PUBLIC
    /*public boolean checkLiving()
    {
        // cells[x][y]
        return alive;
    }*/
}