//Min       1259846
//Gurinder
//Rafael

import java.io.File;
import java.util.Scanner;

public class Maze {

    private char[][] chars;          //maze
    private Scanner inputFile;       //holds the file
    private int rows;                //number of rows
    private int cols;                //number of cols
    private int startRow;
    private int startCol;
    private Location start;          //start Location
    private int endRow;
    private int endCol;
    private Location end;            //end Location
    private LocationQueue queue;     //queue to hold the next paths

    //initializes a maze form the file location
    //goes thorough the first line to get the metadata for the maze
    //initializes chars with the given no. of rows and cols
    //mark the start and end locations with the metadata
    //initialize queue and insert start.
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
        chars=new char[rows][cols];
        start=new Location(startRow,startCol);
        end=new Location(endRow, endCol);
        queue=new LocationQueue(rows*cols);
        queue.insert(start);

        System.out.println(inputFile.nextLine());   //fixes the out of bounds exception

        System.out.println("Maze");
        makeMaze();
        printMaze();
    }
    //inserts all the maze into chars
    private void makeMaze(){
        for (int i=0; i<rows; i++){
            String row=inputFile.nextLine();
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
            System.out.println();               //go to next line
        }
        System.out.println();                   //leave a line
    }

    //finds the path in the maze
    public void findpath(){
        Location current=start;
        while(!queue.isEmpty() && !current.equals(end)){        //not the end and still path to go
            current=queue.remove();                             //next in queue
            chars[current.i][current.j]='.';                    //visited
            searchalldirections(current);                       //search the directions and add to queue
        }
        if (current.i==end.i && current.j==end.j) {             //found
            System.out.println("Found path");
            printMaze();
            return;
        }
        System.out.println("No path found");                    //when queue is empty and end isn't found.
    }

    //breath first search (east, west, north, south)
    //if more than one path, add to queue
    private void searchalldirections(Location current){
        Location next;
        if(current.j!=cols-1){                              //checks east wall.
            if (chars[current.i][current.j+1]==' '){        //east
                next=new Location(current.i, current.j+1);
                queue.insert(next);
            }
        }
        if(current.j!=0){                                   //check west wall
            if (chars[current.i][current.j-1]==' '){        //west
                next=new Location(current.i, current.j-1);
                queue.insert(next);
            }
        }
        if(current.i!=0){                                   //checks for north wall.
            if (chars[current.i-1][current.j]==' '){        //north
                next=new Location(current.i-1, current.j);
                queue.insert(next);
            }
        }
        if (current.i!=rows-1) {                            //checks south wall
            if (chars[current.i + 1][current.j] == ' ') {   //south
                next = new Location(current.i + 1, current.j);
                queue.insert(next);
            }
        }
    }
}
