package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class MazeSolver extends JFrame {
    // 1 represents obstacles
    // Boundary 1's are walls of grid
    final private int[][] maze={
            {3,3,3,3,3,3,3,3,3,3,3,3,3},
            {3,0,1,0,1,0,1,0,0,0,0,0,3},
            {3,0,1,0,0,0,1,0,1,1,1,0,3},
            {3,0,1,1,1,1,1,0,0,0,0,0,3},
            {3,0,0,1,0,0,0,0,1,1,1,0,3},
            {3,0,1,0,1,1,1,0,1,0,0,0,3},
            {3,0,1,0,1,0,0,0,1,1,1,0,3},
            {3,0,1,0,1,1,1,0,1,0,1,0,3},
            {3,0,0,0,0,0,0,0,0,0,1,9,3},
            {3,3,3,3,3,3,3,3,3,3,3,3,3}
    };

    // ArrayList that stores the path from source to destination
    List<Integer> path=new ArrayList<>();
    public MazeSolver(){
        setTitle("Maze Solver"); // Title of the windows
        setSize(470,370); // Size of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close button that closes the window
        dfs.searchPath(maze,1,1,path);
        //System.out.println(path);
    }

    @Override // We are overriding because we have to change some implementations
    // Paint is pre-defined function that takes the graphics
    public void paint(Graphics g){
        g.translate(50,50); // It sets the jframe in x-y plane
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[0].length;j++){
                Color color; // By using Color object, we can set the colors
                switch(maze[i][j]){
                    case 1: color=Color.gray;
                    break;
                    case 3: color=Color.black;
                    break;
                    case 9: color=Color.red;
                    break;
                    default: color=Color.white;
                }
                g.setColor(color); // It sets the color to grid
                g.fillRect(30*j,30*i,30,30);
                g.setColor(Color.black);
                g.drawRect(30*j,30*i,30,30);
            }
        }
        for(int i=0;i<path.size();i+=2){
            int pathx=path.get(i);
            int pathy=path.get(i+1);
            //System.out.println("X coordinates- "+pathx);
            //System.out.println("Y coordinates- "+pathy);
            g.setColor(Color.green);
            g.fillOval(30*pathx,30*pathy,30,30);
        }
    }
}
