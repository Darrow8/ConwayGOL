import java.util.Scanner;  // the Scanner class
import java.awt.Color; // the Graphic Library for Color (Abstract Window Toolkit)
import java.awt.Canvas; // the Graphic Library for Canvas (Abstract Window Toolkit)
import java.awt.Graphics; // the Graphic Library for Graphics (Abstract Window Toolkit)
import javax.swing.JFrame;// the Graphic Library for JFrame (Abstract Window Toolkit)

// why did you use a billion single line comments...
// also why is all the code commented?
// public class Drawing extends Canvas 
// {
//     Cell cells[]; //all cells
//     int[][] toKill; //kill list 
//     int[][] toRez; //revive list
//     Cell[][] aliveCells; // all cells that are alive  
//     int gridNum = 50; //number of cells in xpos or ypos
//     //GAME LOGIC
//     // public static void main(String []args)
//     // {
//     // }
//     public static void main(String[] args) {
//         // JFrame frame = new JFrame("My Drawing");
//         // Canvas canvas = new Drawing();
//         // canvas.setSize(470, 470);
//         // canvas.setBackground(Color.black);
//         // frame.add(canvas);
//         // frame.pack();
//         // frame.setVisible(true);
//         Drawing.init()



//     }


//     private void init(){
//         //create the cells
//         for (int rows = 0; row < gridNum; rows++)
//         {
//             // Object [] row_of_cells;
//             for (int columns = 0; column < gridNum; columns++)
//             {
//                 // int [] positions= new 
//                 cells = new Cell([row][column]);
//                 // row_of_cells.add(new Cell([row, column]));
//             }
//         }
//     }
          // why is there a game function AND a game class???
//     // private void Game()
//     // {
//     //     // while(true){
//     //         // check which cells are alive
//     //         for(xpos = 0; xpos < gridNum; xpos++) // for each cell
//     //         {
//     //             for(ypos = 0; ypos < gridNum; ypos++) // for each cell
//     //             {
//     //                 int surrounding; // how many cells are surrounding
//     //                 if (cells[xpos][ypos].alive == true) // if the cell is alive
//     //                 {
//     //                     //see if it is on edge or not
                        
//     //                     int surroundingLive; //cell surrounding num
//     //                     //where no difference in xpos
//     //                     if(cells[xpos][ypos + 1].alive == true){

//     //                     }
//     //                     if(cells[xpos][ypos - 1].alive == true){

//     //                     }
//     //                     //where +1 in xpos
//     //                     if(cells[xpos + 1][ypos + 1].alive == true){

//     //                     }
//     //                     if(cells[xpos + 1][ypos - 1].alive == true){

//     //                     }
//     //                     if(cells[xpos + 1][ypos].alive == true){

//     //                     }
//     //                     //where -1 in xpos
//     //                     if(cells[xpos - 1][ypos + 1].alive == true){

//     //                     }
//     //                     if(cells[xpos - 1][ypos].alive == true){

//     //                     }
//     //                     if(cells[xpos - 1][ypos - 1].alive == true){

//     //                     }
                        
//     //                     // for(i = 0; i < cells.length; i++)
//     //                     // {
//     //                     //     if ((aliveCells[i].cell_position[0] == cells[cell].cell_position[0] + 1) || (aliveCells[i].cell_position[0] == cells[cell].cell_position[0] - 1))
//     //                     //     {
//     //                     //         if ((aliveCells[i].cell_position[1] == cells[cell].cell_position[1] + 1) || (aliveCells[i].cell_position[1] == cells[cell].cell_position[1] - 1))
//     //                     //         {
//     //                     //             surrounding++;
//     //                     //         }
//     //                     //     }
//     //                     // }
//     //                     // if (surrounding < 2)
//     //                     // {
//     //                     //     toKill.add(cell);
//     //                     // }
//     //                     // else if (surrounding > 3)
//     //                     // {
//     //                     //     toKill.add(cell);
//     //                     // }
//     //                 }
//     //                 else
//     //                 {
//     //                     for(i = 0; i < cells.length; i++)
//     //                     {
//     //                         if ((aliveCells[i].cell_position[0] == cells[cell].cell_position[0] + 1) || (aliveCells[i].cell_position[0] == cells[cell].cell_position[0] - 1))
//     //                         {
//     //                             if ((aliveCells[i].cell_position[1] == cells[cell].cell_position[1] + 1) || (aliveCells[i].cell_position[1] == cells[cell].cell_position[1] - 1))
//     //                             {
//     //                                 surrounding++;
//     //                             }
//     //                         }
//     //                     }
//     //                     if (surrounding == 3)
//     //                     {
//     //                         toRez.add(cell);
//     //                     }
//     //                 }
//     //             }
//     //         }
//     //         for (int z = 0; z < toKill.length; z ++)
//     //         {
//     //             Cells[toKill[z]].alive = false;
//     //         }
//     //         for (int z = 0; z < toRez.length; z ++)
//     //         {
//     //             Cells[toRez[z]].alive = true;
//     //         }
//     //     }
//     //GRAPHICS STUFF



// }

//Code for the game
// public class Game{
//     public static void main(String[] args) {

//     }
// }

// Graphics code


// Code for the individual cell clss









/*
 Any live cell with fewer than two live neighbours dies, as if by underpopulation.
 Any live cell with two or three live neighbours lives on to the next generation.
 Any live cell with more than three live neighbours dies, as if by overpopulation.
 Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction. 
 */