// import java.awt.Color; //Import the Graphic Library for Color (Abstract Window Toolkit)
// import java.awt.Canvas; //Import the Graphic Library for Canvas (Abstract Window Toolkit)
// import java.awt.Graphics; //Import the Graphic Library for Graphics (Abstract Window Toolkit)
// import javax.swing.JFrame;//Import the Graphic Library for JFrame (Abstract Window Toolkit)


// // public class Drawing extends Canvas {
//     // public static void main(String[] args) {
//     //     JFrame frame = new JFrame("My Drawing");
//     //     Canvas canvas = new Drawing();
//     //     canvas.setSize(Game.cell_row_num*10, Game.cell_row_num*10);
//     //     canvas.setBackground(Color.green);
//     //     // canvas.paint(g);
//     //     frame.add(canvas);
//     //     frame.pack();
//     //     frame.setVisible(true);
//     // }
//     //sets the canvas
// // }


// class Drawing extends Canvas {
//     public static int cell_row_num = 10;
//     public static Cell cells[][] = new Cell[cell_row_num][cell_row_num];
//     public static void main(String[] args) {
//         JFrame frame = new JFrame("My Drawing");
//         Canvas canvas = new Drawing();
//         canvas.setSize(cell_row_num*10, cell_row_num*10);
//         canvas.setBackground(Color.green);
//         // canvas.paint(g);
//         frame.add(canvas);
//         frame.pack();
//         frame.setVisible(true);
//     }

//     public static void Gen(){
//         for(int column = 0; column < cell_row_num; column++){
//             for(int row = 0; row < cell_row_num; row++){
//                 // cells[column][row] = new Cell();
//                 if(row == 5 || row == 7){
//                     Drawing.cells[column][row] = new Cell(column,row,true);
//                     // g.setColor(Color.white);
//                     // g.fillRect(column * 10, row * 10, 10, 10);
//                 }else{
//                     Drawing.cells[column][row] = new Cell(column,row,false);
//                     // g.setColor(Color.black);
//                     // g.fillRect(column* 10, row * 10, 10, 10); 
//                 }
//             }
//         }
//     }
//     public void paint(Graphics g){
//         // Drawing.Gen();
//         for(int column = 0; column < cell_row_num; column++){
//             for(int row = 0; row < cell_row_num; row++){
//                 // // cells[column][row] = new Cell();
//                 // if(row == 5 || row == 7){
//                 //     cells[column][row] = new Cell(column,row,true);
//                 //     // g.setColor(Color.white);
//                 //     g.fillRect(column * 10, row * 10, 10, 10);
//                 // }else{
//                 //     cells[column][row] = new Cell(column,row,false);
//                 //     // g.setColor(Color.black);
//                 //     g.fillRect(column* 10, row * 10, 10, 10); 
//                 // }

//                 if(Drawing.cells[column][row].alive){
//                     g.setColor(Color.white);
//                 }else{
//                     g.setColor(Color.black);
//                 }

//                 // cells[0][0].returnVals();
//                 System.out.println(cells[column][row].alive);
//             }
//         }
        
//         // System.out.println(cells[5][5].alive);
//     //     for(int i=0; i < cell_row_num; i++) {
//     //         for (int j = 0; j < cell_row_num; j++) {
//     //             System.out.println(cells[i][j].alive);
//     //             if(cells[i][j].alive){
//     //             // if(i == 5){
//     //                 // System.out.println(Game.cells[i][j].alive);
//     //                 // alive
//     //                 // System.out.println("WORKING");
//                     // g.setColor(Color.white);
//                     // g.fillRect(i * 10, j * 10, 10, 10);
//     //                 // Game.cells[i][j].returnVals();
//     //             // }
//     //             }else{
//                     // g.setColor(Color.black);
//                     // g.fillRect(i * 10, j * 10, 10, 10);   
//     //             }
//     //         }
//     //     }
//     }
// }





import java.awt.Color; //Import the Graphic Library for Color (Abstract Window Toolkit)
import java.awt.Canvas; //Import the Graphic Library for Canvas (Abstract Window Toolkit)
import java.awt.Graphics; //Import the Graphic Library for Graphics (Abstract Window Toolkit)
import javax.swing.JFrame;//Import the Graphic Library for JFrame (Abstract Window Toolkit)

class Drawing extends Canvas {
    //the grid size
    public static int cell_row_num = 10;
    //all of the cells
    public static Cell cells[][] = new Cell[cell_row_num][cell_row_num];
    public static void main(String[] args) {
        JFrame frame = new JFrame("My Drawing");
        Canvas canvas = new Drawing();
        canvas.setSize(cell_row_num*10, cell_row_num*10);
        canvas.setBackground(Color.green);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }
    //generating all of the cells
    public static void Gen(){
        for(int column = 0; column < cell_row_num; column++){
            for(int row = 0; row < cell_row_num; row++){
                //if the row is 5 or 7, the cell is true
                if(row == 5 || row == 7){
                    Drawing.cells[column][row] = new Cell(column,row,true);
                }else{
                    Drawing.cells[column][row] = new Cell(column,row,false);
                }
            }
        }
    }
    //for painting to the canvas
    public void paint(Graphics g){
        Drawing.Gen();
        for(int column = 0; column < cell_row_num; column++){
            for(int row = 0; row < cell_row_num; row++){
                //if the cell is true, make the rect white
                if(Drawing.cells[column][row].alive){
                    g.setColor(Color.white);
                    g.fillRect(column * 10, row * 10, 10, 10);
                }else{
                    g.setColor(Color.black);
                    g.fillRect(column * 10, row * 10, 10, 10);
                }
                System.out.println(cells[column][row].alive);
            }
        }
    }
}