//Min       1259846
//Gurinder
//Rafael

public class MazeApp {
    public static void main(String[]  args) throws Exception {
        String mazeFileLocation="src/maze3.txt";
        Maze maze=new Maze(mazeFileLocation);
        maze.makeMaze();
        maze.printMaze();
    }
}
