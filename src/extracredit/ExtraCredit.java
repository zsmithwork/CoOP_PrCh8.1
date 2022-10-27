package extracredit;
import java.util.Scanner;
import java.util.Arrays;

public class ExtraCredit {

    public static void main(String[] args) {

        //Var Initialization
        final int SZ = 5;
        int vist = 1;
        int plyr = 2;
        int goal = 3;

        int i;
        int j;
        int xpos = 0;
        int ypos = 0;
        char move = 'x';
        boolean mapexplored = false;
        boolean goalreached = false;
        boolean movechk = false;
        Scanner key = new Scanner(System.in);

        //Maze Initialization
        int [][] Maze = new int[SZ][SZ];
        for (i = 0; i < SZ-1; i++) {
            for (j = 0; j < SZ-1; j++) {
                Maze[i][j] = 0;
            }
        }
        
        //Set Starting pos. and Goal
        Maze[0][0] = plyr;
        Maze[4][4] = goal;

        do {
            //Reset check var.
            mapexplored = true;
            movechk = false;
            move = 'x';

            //Check if every node explored
            for (i = 0; i < SZ-1; i++) {
                for (j = 0; j < SZ-1; j++) {
                    if (Maze[i][j] == 0)
                        mapexplored = false;
                }
            }

            //Output maze state
            System.out.println("_____________");
            System.out.println("| " + Maze[0][0] + " " + Maze[0][1] + " " + Maze[0][2] + " " + Maze[0][3] + " " + Maze[0][4] + " |");
            System.out.println("| " + Maze[1][0] + " " + Maze[1][1] + " " + Maze[1][2] + " " + Maze[1][3] + " " + Maze[1][4] + " |");
            System.out.println("| " + Maze[2][0] + " " + Maze[2][1] + " " + Maze[2][2] + " " + Maze[2][3] + " " + Maze[2][4] + " |");
            System.out.println("| " + Maze[3][0] + " " + Maze[3][1] + " " + Maze[3][2] + " " + Maze[3][3] + " " + Maze[3][4] + " |");
            System.out.println("| " + Maze[4][0] + " " + Maze[4][1] + " " + Maze[4][2] + " " + Maze[4][3] + " " + Maze[4][4] + " |");
            System.out.println("_____________");

            System.out.print("Move: ");
            //Get next input
            do {
                move = key.next().charAt(0);
                if (move == 'w' || move == 'a' || move == 's' || move == 'd')
                    movechk = true;
                else
                    System.out.println("Incorrect input");
            } while (!movechk);
            
            //Update prev. player pos.
            if (xpos == 4 && ypos == 4)
                Maze[ypos][xpos] = goal;
            else
                Maze[ypos][xpos] = vist;

            //Update player pos.
            switch (move) {
                case 'w' :
                    --ypos;
                    break;
                case 'a' :
                    --xpos;
                    break;
                case 's' :
                    ++ypos;
                    break;
                case 'd' :
                    ++xpos;
                    break;
            }
            
            //Validate player pos.
            switch (xpos) {
                case -1 :
                    xpos = 0;
                    System.out.println("Out of bounds!");
                    break;
                case 5 :
                    xpos = 4;
                    System.out.println("Out of bounds!");
                    break;
            }
            switch (ypos) {
                case -1 :
                    ypos = 0;
                    System.out.println("Out of bounds!");
                    break;
                case 5 :
                    ypos = 4;
                    System.out.println("Out of bounds!");
                    break;
            }

            //Move player
            Maze[ypos][xpos] = plyr;
            
            //Check if goal reached
            if (xpos == 4 && ypos == 4)
                goalreached = true;

            //Output final map state
            if (goalreached && !mapexplored) {
                System.out.println("_____________");
                System.out.println("| " + Maze[0][0] + " " + Maze[0][1] + " " + Maze[0][2] + " " + Maze[0][3] + " " + Maze[0][4] + " |");
                System.out.println("| " + Maze[1][0] + " " + Maze[1][1] + " " + Maze[1][2] + " " + Maze[1][3] + " " + Maze[1][4] + " |");
                System.out.println("| " + Maze[2][0] + " " + Maze[2][1] + " " + Maze[2][2] + " " + Maze[2][3] + " " + Maze[2][4] + " |");
                System.out.println("| " + Maze[3][0] + " " + Maze[3][1] + " " + Maze[3][2] + " " + Maze[3][3] + " " + Maze[3][4] + " |");
                System.out.println("| " + Maze[4][0] + " " + Maze[4][1] + " " + Maze[4][2] + " " + Maze[4][3] + " " + Maze[4][4] + " |");
                System.out.println("_____________");
                System.out.println("You did not explore the whole map...");
            }
            else if (goalreached && mapexplored) {
                System.out.println("_____________");
                System.out.println("| " + Maze[0][0] + " " + Maze[0][1] + " " + Maze[0][2] + " " + Maze[0][3] + " " + Maze[0][4] + " |");
                System.out.println("| " + Maze[1][0] + " " + Maze[1][1] + " " + Maze[1][2] + " " + Maze[1][3] + " " + Maze[1][4] + " |");
                System.out.println("| " + Maze[2][0] + " " + Maze[2][1] + " " + Maze[2][2] + " " + Maze[2][3] + " " + Maze[2][4] + " |");
                System.out.println("| " + Maze[3][0] + " " + Maze[3][1] + " " + Maze[3][2] + " " + Maze[3][3] + " " + Maze[3][4] + " |");
                System.out.println("| " + Maze[4][0] + " " + Maze[4][1] + " " + Maze[4][2] + " " + Maze[4][3] + " " + Maze[4][4] + " |");
                System.out.println("_____________");
                System.out.println("You explored the whole map!");
            }
        } while (!goalreached);
        
        //Output victory message
        System.out.println("Game complete!");
    }
}
