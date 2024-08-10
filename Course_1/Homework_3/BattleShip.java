import java.util.Scanner;

public class BattleShip {
    public static void main(String[] args) {
        System.out.println("Welcome to Battleship!");
        char[][] battleship1 = {{'-', '-', '-', '-', '-'}, 
        {'-', '-', '-', '-', '-'},
        {'-', '-', '-', '-', '-'},
        {'-', '-', '-', '-', '-'},
        {'-', '-', '-', '-', '-'}};
        char[][] battleship2 = {{'-', '-', '-', '-', '-'}, 
        {'-', '-', '-', '-', '-'},
        {'-', '-', '-', '-', '-'},
        {'-', '-', '-', '-', '-'},
        {'-', '-', '-', '-', '-'}};
        
        battleship1 = createBattleShip(battleship1, 1);
        printBattleShip(battleship1);
        System.out.print("{ 100 empty lines }");

        battleship2 = createBattleShip(battleship2, 2);
        printBattleShip(battleship2);
        System.out.print("{ 100 empty lines }");

        char[][] hintBoard1 = {{'-', '-', '-', '-', '-'}, 
        {'-', '-', '-', '-', '-'},
        {'-', '-', '-', '-', '-'},
        {'-', '-', '-', '-', '-'},
        {'-', '-', '-', '-', '-'}};
        char[][] hintBoard2 = {{'-', '-', '-', '-', '-'}, 
        {'-', '-', '-', '-', '-'},
        {'-', '-', '-', '-', '-'},
        {'-', '-', '-', '-', '-'},
        {'-', '-', '-', '-', '-'}};

        boolean gameOver = false;
        
        do { 
            @SuppressWarnings("resource")
            Scanner input = new Scanner(System.in);
            for(int player = 1; player < 3; player++) {
                System.out.println("");
                System.out.printf("Player %d, enter hit row/column:\n", player);
                int location1 = input.nextInt();
                int location2 = input.nextInt();

                if ((location1 < 0 || location1 > 4) || (location2 < 0 || location2 > 4)) {
                    System.out.print("Invalid coordinates. Choose different coordinates.");
                    player--;
                    continue;
                }

                if (player == 1) {
                    if(battleship2[location1][location2] == '@') {
                        hintBoard2[location1][location2] = 'X';
                        battleship2[location1][location2] = 'X';
                        System.out.println("PLAYER 1 HIT PLAYER 2's SHIP!");
                        printBattleShip(hintBoard2);
                    }
                    else if(battleship2[location1][location2] == '-') {
                        hintBoard2[location1][location2] = 'O';
                        battleship2[location1][location2] = 'O';
                        System.out.println("PLAYER 1 MISSED!");
                        printBattleShip(hintBoard2);
                        continue;
                    }
                    else if((battleship2[location1][location2] == 'X') || (battleship2[location1][location2] == 'O')) {
                        System.out.print("You already fired on this spot. Choose different coordinates.");
                        player--;
                        continue;
                    }

                    if (searchCharArray('@', battleship2) == false) {
                        System.out.println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
                        gameOver = true;
                        break;
                    }
                }

                if (player == 2) {
                    if(battleship1[location1][location2] == '@') {
                        hintBoard1[location1][location2] = 'X';
                        battleship1[location1][location2] = 'X';
                        System.out.println("PLAYER 2 HIT PLAYER 1's SHIP!");
                        printBattleShip(hintBoard1);
                    }
                    else if(battleship1[location1][location2] == '-') {
                        hintBoard1[location1][location2] = 'O';
                        battleship1[location1][location2] = 'O';
                        System.out.println("PLAYER 2 MISSED!");
                        printBattleShip(hintBoard1);
                        continue;
                    }
                    else if((battleship1[location1][location2] == 'X') || (battleship1[location1][location2] == 'O')) {
                        System.out.print("You already fired on this spot. Choose different coordinates.");
                        player--;
                        continue;
                    }

                    if (searchCharArray('@', battleship1) == false) {
                        System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
                        gameOver = true;
                        break;
                    }
                }
            }
        }    while (gameOver == false);

        System.out.println("");
        System.out.println("Final boards:");
        System.out.println("");
        printBattleShip(battleship1);
        System.out.println("");
        printBattleShip(battleship2);
    }

    public static char[][] createBattleShip(char[][] battleship, int player) {
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        System.out.println("");
        System.out.printf("PLAYER %d, ENTER YOUR SHIPS' COORDINATES.\n", player);

        for(int ship = 1; ship < 6; ship++) {
            System.out.printf("Enter ship %d location:\n", ship);
            int location1 = input.nextInt();
            int location2 = input.nextInt();

            if ((location1 < 0 || location1 > 4) || (location2 < 0 || location2 > 4)) {
                System.out.println("Invalid coordinates. Choose different coordinates.");
                ship--;
                continue;
            }

            if (battleship[location1][location2] == '@') {
                System.out.println("You already have a ship there. Choose different coordinates.");
                ship--;
                continue;
            }

            battleship[location1][location2] = '@';
        }

        return battleship;
    }

    public static boolean searchCharArray(char target, char[][] array) {
        boolean result = false;
        for (char[] firstarray : array) {
            for (char element : firstarray) {
                if (element == target) {
                    result = true;
                    break;
                }
            }
        }   
        return result;
    }

    private static void printBattleShip(char[][] player) {
        System.out.print("  ");
        for (int row = -1; row < 5; row++) {
            if (row > -1) {
                System.out.print(row + " ");
            }
            for (int column = 0; column < 5; column++) {
                if (row == -1) {
                    System.out.print(column + " ");
                } else {
                    System.out.print(player[row][column] + " ");
                }
            }
            System.out.println("");
        }
    }
}
