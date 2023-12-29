import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class tictactoe {
    static ArrayList <Integer> playerPositions = new ArrayList<>();
    static ArrayList <Integer> cpuPositions = new ArrayList<>();
    public static void main(String[] args) {
        char [][] gameBoard = {{' ', '|', ' ', '|', ' '},
                               {'-', '+', '-', '+', '-'},
                               {' ', '|', ' ', '|', ' '},
                               {'+', '-', '+', '-', '+'},
                               {' ', '|', ' ', '|', ' '}};    
        
        printgameBoard(gameBoard);

        
        while (true) {
        Scanner scan = new Scanner (System.in);
        System.out.println("Enter your placement (1-9) :");
        int playerpos = scan.nextInt ();
        while (playerPositions.contains(playerpos) || cpuPositions.contains(playerPositions)) {
            System.out.println("Position taken: Enter a correct position");
            playerpos = scan.nextInt();
            
        }
       

        placement(gameBoard, playerpos, "player");

        Random rand = new Random();
        int cpupos = rand.nextInt(9) + 1;
        while (playerPositions.contains(cpupos) || cpuPositions.contains(cpupos)) {
            System.out.println("Position taken: Enter a correct position");
            cpupos = rand.nextInt(9) + 1;
        }

        placement(gameBoard, cpupos, "cpu");

        printgameBoard(gameBoard);
        String result = winnerchecker();
        System.out.println(result);
            
        }


    }
    public static void printgameBoard (char [][]gameBoard) {
        for(char [] row: gameBoard ){
            for( char c: row){
                System.out.print(c);
            }
            System.out.println();
        }
        
    }   
    public static void placement (char gameBoard [][], int pos, String User) {
        char symbol = ' ';
        if (User.equals("player")) {
            symbol = 'X';   
            playerPositions.add(pos);         
        }else if (User.equals("cpu")) {
            symbol = 'O';
            cpuPositions.add(pos);
             {
            
                
            }
        }
        switch (pos) {
                          case 1:
            gameBoard [0] [0] = symbol;             
                break;
                          case 2:
            gameBoard [0] [2] = symbol;              
                break;
                          case 3:
            gameBoard [0] [4] = symbol; 
                break; 
                      case 4:
            gameBoard [2] [0] = symbol;        
                 break;
                 case 5:
            gameBoard [2] [2] = symbol;             
                break;
                 case 6:
            gameBoard [2] [4] = symbol;             
                break;
                case 7:
            gameBoard [4] [0] = symbol;              
                break;
                 case 8:
            gameBoard [4] [2] = symbol;              
                break;
                case 9:
            gameBoard [4] [4] = symbol;             
                break;     
            default:
                break;
        }
        
    } 

public static String winnerchecker() {
    List topRow = Arrays.asList(1,2,3);
    List midRow = Arrays.asList(4,5,6);
    List botRow = Arrays.asList (7,8,9);
    List leftCol = Arrays.asList(1,4,8);
    List midCol = Arrays.asList (2,5,8);
    List rightCol = Arrays.asList (3,6,9);
    List cross1 = Arrays.asList (1,5,9);
    List cross2 = Arrays.asList (3,5,7);

    List <List> winConditions = new ArrayList<List>();
    winConditions.add (topRow);
    winConditions.add (midRow);
    winConditions.add (botRow);
    winConditions.add (leftCol);
    winConditions.add (rightCol);
    winConditions.add (midCol);
    winConditions.add (cross1);
    winConditions.add (cross2);

    for (List l : winConditions){
        if (playerPositions.containsAll(l)) {
            return "Congratulations Champ";
            
        } else if (cpuPositions.containsAll(l)) {
            return "CPU wins :(";
            
        } else if (playerPositions.size() + cpuPositions.size () == 9) {
            return "TIE!";
            
        }
    }

    return "";
    
}
    
}
