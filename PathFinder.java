import java.io.*;
import java.util.*;

/* THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS OR ONLINE RESOURCES.
Malia Walewski*/

public class PathFinder {

    /**
     *   Main method loads maze file and performs
     *   search.
     *   @param args array containing maze file
     */
    public static void main(String[] args) throws IOException {
        if(args.length<1){
            System.err.println("***Usage: java PathFinder maze_file");
            System.exit(-1);
        }

        char [][] maze;
        maze = readMaze(args[0]);
        printMaze(maze);
        Position [] path = stackSearch(maze);
        if( path == null ){
            System.out.println("Maze is NOT solvable (no valid path identified in stackSearch).");
        } else {
            System.out.println("stackSearch Solution:");
            printPath(path);
            printMaze(maze);
        }

        char [][] maze2 = readMaze(args[0]);
        path = queueSearch(maze2);
        if( path == null ){
            System.out.println("Maze is NOT solvable (no valid path identified in queueSearch).");
        } else {
            System.out.println("queueSearch Solution:");
            printPath(path);
            printMaze(maze2);
        }
    }

    /**
     *   Find a path linking the entrance to the exit of the given maze.
     *   This version uses a queue to track positions.
     *   @param maze the shape of the maze, given as an N-by-N grid
     *   @return a sequence of positions identifying the path, or null if no path exists
     */
    public static Position [] queueSearch(char [][] maze) {
        Queue<Position> queueList = new ArrayDeque<>();
        int N = maze.length;

        Position startPosition = new Position(0, 0, maze[0][0], null); 
        queueList.add(startPosition); //adds first posiiton to the queue

        while(!queueList.isEmpty()){
            Position current = queueList.poll();
            int i = current.getI();
            int j = current.getJ();
            maze[i][j] = '.'; //mark visited path 
            if(i == N-1 && j == N-1) {
                return constructPath(current, maze); //calls method that constructs the path used to solve
            } else {
                //Down
                if (i + 1 < N && maze[i+1][j] == '0') {
                    queueList.add(new Position(i+1, j, '0', current));
                }
                //Up
                if (i - 1 >= 0 && maze[i-1][j] == '0') {
                    queueList.add(new Position(i-1, j, '0', current));
                }
                //Right
                if (j + 1 < N && maze[i][j+1] == '0') {
                    queueList.add(new Position(i, j+1, '0', current));
                }
                //Left
                if (j - 1 >= 0 && maze[i][j-1] == '0') {
                    queueList.add(new Position(i, j-1, '0', current));
                }
            }
        }
        return null;
    }


    /**
     *   Find a path linking the entrance to the exit of the given maze.
     *   This version uses a stack to track positions.
     *   @param maze the shape of the maze, given as an N-by-N grid
     *   @return a sequence of positions identifying the path, or null if no path exists
     */
    public static Position [] stackSearch(char [][] maze) {
        Stack<Position> stackList = new Stack<>();
        int N = maze.length;

        Position startPosition = new Position(0, 0, maze[0][0], null);
        stackList.add(startPosition); //adds initial position to the stack 

        while(!stackList.isEmpty()){
            Position current = stackList.pop();
            int i = current.getI();
            int j = current.getJ();
            maze[i][j] = '.'; //mark visited path 
            if(i == N-1 && j == N-1) {
                return constructPath(current, maze); //calls method that constructs the path used to solve
            } else {
                //Down
                if (i + 1 < N && maze[i+1][j] == '0') {
                    stackList.push(new Position(i+1, j, '0', current));
                }
                //Up
                if (i - 1 >= 0 && maze[i-1][j] == '0') {
                    stackList.push(new Position(i-1, j, '0', current));
                }
                //Right
                if (j + 1 < N && maze[i][j+1] == '0') {
                    stackList.push(new Position(i, j+1, '0', current));
                }
                //Left
                if (j - 1 >= 0 && maze[i][j-1] == '0') {
                    stackList.push(new Position(i, j-1, '0', current));
                }
            }
        }
        return null;
    }

        /**
     *   Find a path linking the entrance to the exit of the given maze.
     *   @param maze the shape of the maze, given as an N-by-N grid
     *   @param end the last position that the maze path travels, current position of the stack/queue
     *   @return a sequence of positions identifying the path
     */
    public static Position[] constructPath(Position end, char[][] maze) {
        // Alg 2
         List<Position> path = new ArrayList<>(); 
         Position current = end; //mark the current position as the end 
 
          while(current != null){
             int i = current.getI(); 
             int j = current.getJ();
             maze[i][j] = 'X'; //update the i and j coordinate with an X for having been on the path 
             path.add(0, current); //adds to beginning of array 
             current = current.getParent(); //finds parent of each coordinate 
         }
         return path.toArray(new Position[0]);
     }


    /**
     *   Print the given path through the maze.
     *   @param path Path through maze, given as array of Position
     */
    public static void printPath(Position [] path){
        System.out.print("Path: ");
        for(Position p : path){
            System.out.print(p+ " ");
        }
        System.out.println();
    }

    /**
     *   Read a file containing maze data and convert to array representation.
     *   @param filename file containing the maze data
     *   @return 2-D grid of characters reprsenting maze structure
     */
    public static char [][] readMaze(String filename) throws IOException{
        char [][] maze;
        Scanner scanner;
        try{
            scanner = new Scanner(new FileInputStream(filename));
        }
        catch(IOException ex){
            System.err.println("Invalid filename: " + filename);
            throw ex;
        }

        int N = scanner.nextInt();
        scanner.nextLine();
        maze = new char[N][N];
        int i=0;
        while(i < N && scanner.hasNext()){
            String line =  scanner.nextLine();
            String [] tokens = line.split("\\s+");
            int j = 0;
            for (; j< tokens.length; j++){
                maze[i][j] = tokens[j].charAt(0);
            }
            if(j!=N){
                System.err.println("Invalid line: " + i + " has wrong # columns: " + j);
                return null;
            }
            i++;
        }
        if(i!=N){
            System.err.println("Invalid file: has wrong number of rows: " + i);
            return null;
        }
        return maze;
    }

    /**
     *   Display maze structure on screen.
     *   @param maze array created by readMze
     */
    public static void printMaze(char[][] maze){
        System.out.println("Maze: ");
        if(maze==null || maze[0] == null){
            System.err.println("*** Invalid maze array");
            return;
        }

        for(int i=0; i< maze.length; i++){
            for(int j = 0; j< maze[0].length; j++){
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

}
