import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class MinesOfMoria {

    private static Cell[][] maze;
    private int cellSize = 50;
    private int frameSizeX = 500;
    private int frameSizeY = 500;

    // List of locations on the maze that have already been visited
    private static ArrayList<int[]> path = new ArrayList<>();

    // Constructor for MinesOfMoria object
    // Automatically adjusts the size of the cells depending on the size of the maze
    public MinesOfMoria(int index) {
        maze = generateRandomMaze(index);
        cellSize = frameSizeX / index;

    }

    // Randomly generated maze
    // Generates 2/3 of the cells as PATH and 1/3 as WALL
    public Cell[][] generateRandomMaze(int index) {
        Cell[][] newMaze = new Cell[index][index];
        Random random = new Random();
        int switchNumber;

        for (int i = 0; i < newMaze.length; i++) {
            for (int j = 0; j < newMaze[i].length; j++) {
                switchNumber = random.nextInt(3);

                // Determining whether a given cell is a WALL or PATH depending on randomly
                // generated number (2/3 of cells will be paths)
                switch (switchNumber) {
                    case 0:
                        newMaze[i][j] = Cell.WALL;
                        break;
                    case 1:
                    case 2:
                        newMaze[i][j] = Cell.PATH;
                        break;
                }
            }
        }
        newMaze[0][0] = Cell.PATH; // Ensuring the first cell is a PATH
        newMaze[newMaze.length - 1][newMaze.length - 1] = Cell.PATH; // Ensuring the ending cell is a PATH
        return newMaze;
    }

    // Checking whether a given location is actually within the bounds of the maze
    public boolean isValidLocation(int x, int y) {
        if ((x >= 0) && (x < maze.length) && (y >= 0) && (y < maze.length)) {
            return true;
        } else {
            return false;
        }
    }

    // Generating the coordinates of the four possible diretions of travel given 
    // a certain location on the maze
    public int[][] generatePositions(int x, int y) {
        int[][] newPositions = {
                { x, y + 1 },
                { x + 1, y },
                { x - 1, y },
                { x, y - 1 }
        };
        return newPositions;
    }

    // Adding to the list of locations on the maze that have already been traveled to
    public void addToPath(int x, int y) {
        int[] newLocation = { x, y };
        path.add(newLocation);
    }

    /* Checks whether a given location on the maze has already been visited before. This is done
        by iterating through the list of locations in path and seeing if the coordinates are equal */
    public boolean visited(int x, int y) {
        for (int i = 0; i < path.size(); i++) {
            if (x == path.get(i)[0] && y == path.get(i)[1]) {
                return true;
            }
        }
        return false;
    }

    // Recursively finds the end of the maze using backtracking.
    public boolean findPath(int x, int y) {
        // Making sure the arguments are a valid location on the maze
        if (isValidLocation(x, y)) {

            // Checking if the current position in the maze is a possible path
            // If not, return false
            if (maze[x][y] == Cell.WALL || visited(x, y)) {
                return false;
            }
            maze[x][y] = Cell.TRACK; // Filling in the track as the maze is being solved
            addToPath(x, y); // Adding the current location to the list of locations visited by the program

            // Checking if the end of the maze has been reached successfully
            if ((x == maze.length - 1) && (y == maze.length - 1)) {
                return true;
            }

            // Generating the four possible next locations given the current location
            // Recursively calling findPath() for each of the possible next locations
            int[][] newLocations = generatePositions(x, y);
            for (int[] location : newLocations) {
                if (findPath(location[0], location[1])) {
                    return true;
                }
            }
        }

        return false;
    }

    // Printing out the maze
    public void printMaze() {
        // Printing the maze to the console in the form of the mazeNumbers
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j].mazenumber + " ");
            }
            System.out.println();
        }
        // Creating a GUI with the maze: black = WALL, white = PATH, green = TRACK
        JFrame frame = new JFrame("Mines of Moria Maze");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameSizeX, frameSizeY);
        frame.setResizable(true);
        JPanel mazePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int x = 0; x < maze.length; x++) {
                    for (int y = 0; y < maze[x].length; y++) {
                        if (maze[x][y] == Cell.WALL) {
                            g.setColor(Color.BLACK);
                        } else if (maze[x][y] == Cell.PATH) {
                            g.setColor(Color.WHITE);
                        } else {
                            g.setColor(Color.GREEN);
                        }
                        g.fillRect(y * cellSize, x * cellSize, cellSize, cellSize);
                        g.setColor(Color.GRAY);
                        g.drawRect(y * cellSize, x * cellSize, cellSize, cellSize);
                    }
                }
            }
        };
        frame.add(mazePanel);
        frame.setVisible(true);
    }
}
