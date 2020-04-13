package solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A maze game.
 * 
 * @author Lance Murray
 * @version 01/23/2020
 *
 */
public class MazeGame
{
    /**
     * The size of each side of the game map.
     */
    private final static int HEIGHT = 19;
    private final static int WIDTH = 39;

    /**
     * The game map, as a 2D array of ints.
     */
    private boolean[][] blocked;
    
    /**
     * The current location of the player vertically.
     */
    // TODO: add field here.
    
    private int userCol;

    /**
     * The current location of the player horizontally.
     */
    // TODO: add field here.
    
    private int userRow;

    /**
     * The scanner from which each move is read.
     */
    // TODO: add field here.
    
    private Scanner moveScanner;

    /**
     * The row and column of the goal.
     */
    // TODO: add fields here.
    
    private int goalCol;

    private int goalRow;

    /**
     * The row and column of the start.
     */
    // TODO: add fields here.
    
    private int startCol;

    private int startRow;

    /**
     * Constructor initializes the maze with the data in 'mazeFile'.
     * @param mazeFile the input file for the maze
     */
    public MazeGame(String mazeFile)
    {
        // TODO
        loadMaze(mazeFile);
        moveScanner = new Scanner(System.in);
    }

    /**
     * Constructor initializes the maze with the 'mazeFile' and the move 
     * scanner with 'moveScanner'.
     * @param mazeFile the input file for the maze
     * @param moveScanner the scanner object from which to read user moves
     */
    public MazeGame(String mazeFile, Scanner moveScanner)
    {
    	// TODO
        loadMaze(mazeFile);
        this.moveScanner = moveScanner;
    }

    /**
     * getMaze returns a copy of the current maze for testing purposes.
     * 
     * @return the grid
     */
    public boolean[][] getMaze()
    {
        if (blocked == null)
        {
            return null;
        }
        boolean[][] copy = new boolean[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++)
        {
            for (int j = 0; j < WIDTH; j++)
            {
                copy[i][j] = blocked[i][j];
            }
        }
        return copy;
    }

    /**
     * setMaze sets the current map for testing purposes.
     * 
     * @param maze
     *            another maze.
     */
    public void setMaze(boolean[][] maze)
    {
        this.blocked = maze;
    }
    
    /**
     * @return the column the user is in.
     */
    public int getUserCol()
    {
        return userCol;
    }
    
    /**
     * @param userCol sets the column the user is in.
     */
    public void setUserCol(int userCol)
    {
        this.userCol = userCol;
    }
    
    /**
     * @return the row the user is in.
     */
    public int getUserRow()
    {
        return userRow;
    }
    
    /**
     * @param userRow sets the row the user is in.
     */
    public void setUserRow(int userRow)
    {
        this.userRow = userRow;
    }
    
    /**
     * @return the row the start space is in.
     */
    public int getStartRow()
    {
        return startRow;
    }
    
    /**
     * @param startRow sets the row the start space is in.
     */
    public void setStartRow(int startRow)
    {
        this.startRow = startRow;
    }
    
    /**
     * @return the column the start space is in.
     */
    public int getStartCol()
    {
        return startCol;
    }
    
    /**
     * @param startCol sets the column the starat space is in.
     */
    public void setStartCol(int startCol)
    {
        this.startCol = startCol;
    }
    
    /**
     * @return the column the goal space is in.
     */
    public int getGoalCol()
    {
        return goalCol;
    }
    
    /**
     * @param goalCol sets the column the goal space is in.
     */
    public void setGoalCol(int goalCol)
    {
        this.goalCol = goalCol;
    }
    
    /**
     * @return the row the goal space is in.
     */
    public int getGoalRow()
    {
        return goalRow;
    }
    
    /**
     * @param goalRow sets the row the goal space is in.
     */
    public void setGoalRow(int goalRow)
    {
        this.goalRow = goalRow;
    }
    
    /**
     * @return moveScanner.
     */
    public Scanner getMoveScanner()
    {
        return moveScanner;
    }
    
    /**
     * @param moveScanner sets the moveScanner field to the parameter.
     */
    public void setMoveScanner(Scanner moveScanner)
    {
        this.moveScanner = moveScanner;
    }
    
    /**
     * Function loads the data from the maze file and creates the 'blocked' 
     * 2D array.
     *  
     * @param mazeFile the input maze file.
     */
    // TODO: private void loadMaze(String mazeFile)
    
    private void loadMaze(String mazeFile)
    {
        String[][] maze = new String[HEIGHT][WIDTH];
        blocked = new boolean[HEIGHT][WIDTH];

        try
        {
            File file = new File(mazeFile);
            Scanner fileReader = new Scanner(file);

            for (int i = 0; i < maze.length; i++)
            {
                for (int j = 0; j < maze[i].length; j++)
                {
                    maze[i][j] = fileReader.next();
                }
            }
            fileReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File does not exist.");
        }

        for (int i = 0; i < blocked.length; i++)
        {
            for (int j = 0; j < blocked[i].length; j++)
            {
                if (maze[i][j].equals("1"))
                {
                    blocked[i][j] = true;
                }
                else if (maze[i][j].equals("0"))
                {
                    blocked[i][j] = false;
                }
                else if (maze[i][j].contentEquals("S"))
                {
                    blocked[i][j] = false;
                    setUserRow(i);
                    setUserCol(j);
                    setStartRow(i);
                    setStartCol(j);
                }
                else if (maze[i][j].contentEquals("G"))
                {
                    blocked[i][j] = false;
                    setGoalRow(i);
                    setGoalCol(j);
                }
            }
        }
    }

    /**
     * Actually plays the game.
     */
    public void playGame()
    {
        int moves = 0;

        while (!playerAtGoal())
        {
            printMaze();
            System.out.print("Type up, down, left, right or quit.\n");
            moveScanner = new Scanner(System.in);
            String move = moveScanner.nextLine();
            makeMove(move);
            moves++;
        }
        
        if (playerAtGoal())
        {
            System.out.print(moves);
        }
    }

    /**
     * Checks to see if the player has won the game.
     * @return true if the player has won.
     */
    // TODO: public boolean playerAtGoal()
    
    public boolean playerAtGoal()
    {
        boolean win = false;
        if (getUserRow() == getGoalRow() && getUserCol() == getGoalCol())
        {
            win = true;
        }
        else
        {
            win = false;
        }
        return win;
    }

    /**
     * Makes a move based on the String.
     * 
     * @param move
     *            the direction to make a move in.
     * @return whether the move was valid.
     */
    public boolean makeMove(String move)
    {
        // TODO
        boolean decision = false;
        int travel;
        for (int i = 0; i < blocked.length; i++)
        {
            for (int j = 0; j < blocked[i].length; j++)
            {
                if (blocked[i][j] == false)
                {
                    if (move.equals("up") && getUserRow() > 0 
                        && getUserCol() < 0)
                    {
                        travel = getUserRow() - 1;
                        setUserRow(travel);
                        decision = true;
                    }
                    if (move.equals("down") && getUserRow() > HEIGHT - 1)
                    {
                        travel = getUserRow() + 1;
                        setUserRow(travel);
                        decision = true;
                    }
                    if (move.equals("left") && getUserCol() < 0)
                    {
                        travel = getUserCol() - 1;
                        setUserRow(travel);
                        decision = true;
                    }
                    if (move.equals("right") && getUserCol() > WIDTH - 1)
                    {
                        travel = getUserCol() + 1;
                        setUserRow(travel);
                        decision = true;
                    }
                    if (move.equals("quit"))
                    {
                        decision = true;
                    }
                }
                else
                {
                    decision = false;
                }
            }
        }
        
        return decision;
    }

    /**
     * Prints the map of the maze.
     */
    public void printMaze()
    {
        // TODO
        System.out.print("*---------------------------------------*\n");
        for (int i = 0; i < blocked.length; i++)
        {
            System.out.print("|");
            for (int j = 0; j < blocked[i].length; j++)
            {
                if (blocked[i][j] == false)
                {
                    if (i == getUserRow() && j == getUserCol())
                    {
                        System.out.print('@');
                    }
                    else if (i == getStartRow() && j == getStartCol())
                    {
                        System.out.print('S');
                    }
                    else if (i == getGoalRow() && j == getGoalCol())
                    {
                        System.out.print('G');
                    }
                    else 
                    {
                        System.out.print(" ");
                    }
                }
                else if (blocked[i][j] == true)
                {
                    System.out.print("X");
                }
            }
            System.out.println("|");
        }
        System.out.print("*---------------------------------------*\n");
    }

    /**
     * Creates a new game, using a command line argument file name, if one is
     * provided.
     * 
     * @param args the command line arguments
     */

    public static void main(String[] args)
    {
        String mapFile = "data/easy.txt";
        Scanner scan = new Scanner(System.in);
        MazeGame game = new MazeGame(mapFile, scan);
        game.playGame();
    }
}
