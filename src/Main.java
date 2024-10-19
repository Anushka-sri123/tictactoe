import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char [][] board  = new char[3][3];
        for(int row = 0;row< board.length;row++)
        {
            for(int col =0; col<board[row].length;col++)
            {
                board[row][col] = ' ';
            }
        }
        char Player = 'X';
        boolean gameOver = false;
        Scanner sc =  new Scanner(System.in);
        int moves = 0;
        while (!gameOver)
        {
            printBoard(board);
            System.out.println("Player " +  Player  +  "  enter :");
            int row = sc.nextInt();
            int col = sc.nextInt();
            if(board[row][col] == ' ')
            {
               board[row][col] = Player;
               moves ++;
               gameOver = haveWon(board,Player);
               if(gameOver)
               {
                   System.out.println("Player " + Player + " has won");
                   System.exit(0);
               }
               else if(moves == 9){
                   System.out.println("It's a tie!");
                   gameOver = true;
                   System.exit(0);
               }
               else{
                   if(Player == 'X')
                   {
                       Player = 'O';
                   }
                   else {
                       Player = 'X';
                   }
               }
            }
            else{
                System.out.println("Invalid move");
            }
        }
        printBoard(board);
    }
    public static boolean haveWon(char [][] board,char player)
    {
        for(int row = 0;row< board.length;row++)
        {
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player )
            {
                return true;
            }
        }
        for(int col = 0;col< board.length;col++)
        {
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player )
            {
                return true;
            }
        }
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player )
        {
            return true;
        }
        if(board[0][2] == player && board[1][1] == player && board[2][0] == player )
        {
            return true;
        }
        return false;
    }
    public static void printBoard(char[][] board)
    {
        for(int row = 0;row< board.length;row++)
        {
            for(int col =0; col<board[row].length;col++)
            {
                System.out.print(board[row][col] + " |");
            }
            System.out.println();
        }
    }
}