//Min       1259846
//Gurinder
//Rafael

import java.util.Scanner;


public class MazeApp {

    //asks the user for the name of the maze file
    //makes imprints the map onto themaze
    //prints the original maze
    public static void main(String[]  args) throws Exception {
        System.out.println("Enter the name for maze file: ");
        Scanner scn =new Scanner (System.in);
        String mazeFileLocation="src/"+"maze3.txt"; //scn.next());
        Maze themaze=new Maze(mazeFileLocation);
    }
}
