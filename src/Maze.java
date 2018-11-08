//Min       1259846
//Gurinder
//Rafael

import java.io.File;
import java.util.Scanner;

public class Maze {

    public char[][] chars;
    public Scanner inputFile;
    public int rows;
    public int cols;
    public int startRow;
    public int startCol;
    public Location start;
    public int endRow;
    public int endCol;
    public Location end;
    public LocationQueue queue;

    //initializes a maze form the file location
    //goes thorough the first line to get the metadata for the maze
    //initializes chars with the given no. of rows and cols
    //mark the start and end locations with the metadata
    //initialize locationqueue and insert start.
    public Maze(String mazeFileLocation)throws Exception{
        inputFile=new Scanner(new File(mazeFileLocation));
        if (inputFile.hasNext()){
            rows=inputFile.nextInt();
            cols=inputFile.nextInt();
            startRow=inputFile.nextInt();
            startCol=inputFile.nextInt();
            endRow=inputFile.nextInt();
            endCol=inputFile.nextInt();
        }
        chars=new char[cols][rows];
        start=new Location(startRow,startCol);
        end=new Location(endRow, endCol);
        queue=new LocationQueue(rows*cols);
        queue.insert(start);
        System.out.println(inputFile.nextLine());
            //fixes the out of bounds exception

        makeMaze();
        printMaze();
    }
    //inserts all the maze into chars
    public void makeMaze(){
        for (int i=0; i<rows; i++){
            String row=inputFile.nextLine();
            //System.out.println(row);
            for (int j=0; j<cols; j++){
                chars[i][j]=row.charAt(j);
            }
        }
    }

    //prints the maze
    public void printMaze(){
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols;j++){
                System.out.print(chars[i][j]);
            }
            System.out.println();
        }
    }

    //finds the path in the maze
    void findpath(){

    }




}
