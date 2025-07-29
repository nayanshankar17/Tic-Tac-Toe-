import java.util.Scanner;
public class tictactoe{

    //basic layout of places where X and O will appear
    static char[][] board = {
        { ' ', ' ', ' '},
        { ' ', ' ', ' '},
        { ' ', ' ', ' '}
    };

    //character X/O
    static char currentPlayer = 'X';

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean gameEnded = false;

        System.out.println("Welcome to the TicTacToe game!!");
        printBoard();

        //main functioning
        while(!gameEnded){
            System.out.println("Player "+currentPlayer+" choose row(0-2) and column(0-2): ");
            int row = sc.nextInt();
            int column = sc.nextInt();

            if(row<0||row>2||column<0||column>2){
                System.out.println("Invalid. Enter a valid choice.");
                continue;//input again, while loop will run again
            }

            //cell check, if empty
            if(board[row][column]!=' '){
                System.out.println("The cell is already occupied");
                continue;//if cell is filled, again the while loop will run
            }

            board[row][column] = currentPlayer;
            printBoard();

            if(checkWin()){
                System.out.println("Player "+currentPlayer+" Wins!!!");
                gameEnded = true;//while loop terminated
            }
            else if(checkDraw()){
                System.out.println("Game draw.");
                gameEnded = true;//while loop terminated
            }
            else{
                if(currentPlayer=='X'){
                    currentPlayer='O';
                } else{
                    currentPlayer='X';
                }
            }
        }
        sc.close();/* When you create a Scanner using new Scanner(System.in), it keeps a connection open to 
                   the input stream (System.in). If you don’t close it, it can keep unnecessary resources 
                   locked (like memory or file handles). Closing it tells Java that you are done using the 
                   scanner and it can release resources. */
                   /* Not necessary to use it bacause java automatically closes it. However, it is a good
                   practice to use it. */ 
    }

    //func to draw a board
    public static void printBoard(){
        System.out.println("-------------");
        for(int i=0; i<3; i++){
            System.out.print("| ");
            for(int j=0; j<3; j++){
                System.out.print(board[i][j]+" | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }


    //func to check if any player has won
    public static boolean checkWin(){
        for(int i=0; i<3; i++){
            //row check
            if(board[i][0]==currentPlayer && board[i][1]==currentPlayer && board[i][2]==currentPlayer) return true;

            //column check
            if(board[0][i]==currentPlayer && board[1][i]==currentPlayer && board[2][i]==currentPlayer) return true;

            //diagonal check
            if(board[0][2]==currentPlayer && board[1][1]==currentPlayer && board[2][0]==currentPlayer) return true;
            if(board[0][0]==currentPlayer && board[1][1]==currentPlayer && board[2][2]==currentPlayer) return true;
        }
        return false;
    }


    //func to check if the game is drawn
    public static boolean checkDraw(){
        for(int i=0; i<3;i++){
            for(int j=0; j<3; j++){
                if(board[i][j]==' '){
                    return false;// some space is still enpty
                }
            }
        }
        return true;// no winning condition results in game draw
    }
}
