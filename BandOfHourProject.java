package BandOfHourProject;

import java.util.Scanner;

public class BandOfHourProject {

    private static final Scanner keyboard = new Scanner(System.in);
    private static final int MAX_ROWS = 10;
    private static final int MAX_NUM_POSITIONS = 8;
    private static final int MAX_WEIGHT_PER_POSITION = 100;
    private static final int MAX_WEIGHT = 200;
    private static final int MIN_WEIGHT = 45;
    static int userRows;
    static int[] numPositions;
    static double[][] musicians;

    public static void main(String[] args) {
        System.out.println("Welcome to the Band of the Hour\n---------------------------\n");
        getRowsAndPositions();
        menu();


    }// END OF MAIN METHOD
     private static void getRowsAndPositions() {
         int userPositions;

         System.out.print("Please enter the number of rows     :");
         userRows = keyboard.nextInt();

         while (userRows <= 0||userRows > MAX_ROWS) {
             System.out.print("ERROR: Out of range, try again   :");
             userRows = keyboard.nextInt();
         }

         numPositions = new int[userRows];
         musicians = new double [userRows][];

         for (int i = 0; i < userRows; i++) {
             System.out.print("Please enter number of positions in row " + (char) ('A' + i) + " : ");

             userPositions = keyboard.nextInt();
             while (userPositions > MAX_NUM_POSITIONS) {
                 System.out.print("ERROR: Out of range, try again  :");
                 userPositions = keyboard.nextInt();
             }
             numPositions[i] = userPositions;
             musicians[i] = new double[numPositions[i]];

                }
        } //END OF GET ROWS AND POSITIONS METHOD

        private static void addMusician() {
            char rowLetter;
            int rowIndex;
            double musicianWeight;
            double totalWeightInRow = 0;


            System.out.print("Please enter a row letter     : ");
            rowLetter = (keyboard.next().toUpperCase().charAt(0));
            rowIndex = rowLetter - 'A';

            while (rowIndex < 0|| rowIndex >= userRows ) {
                System.out.print("ERROR: Out of range, try again   :");
                rowLetter = (keyboard.next().toUpperCase().charAt(0));
                rowIndex = rowLetter - 'A';
            }

            System.out.print("Please enter position number (1 to " + numPositions[rowIndex] + ") : ");
            int position = keyboard.nextInt();

            while (position < 1 || position > numPositions[rowIndex]) {
                System.out.print("ERROR: Out of range, try again   : ");
                position = keyboard.nextInt();
            }

            System.out.print("Please enter weight (" + MIN_WEIGHT + " to " + MAX_WEIGHT + ")   : ");
            musicianWeight = keyboard.nextDouble();

            while (musicianWeight < MIN_WEIGHT || musicianWeight > MAX_WEIGHT) {
                System.out.print("ERROR: Out of range, try again   : ");
                musicianWeight = keyboard.nextDouble();
            }

            for (int i = 0; i < numPositions[rowIndex]; i++) {
                totalWeightInRow += musicians[rowIndex][i];
            }

            if ((totalWeightInRow + musicianWeight) > (MAX_WEIGHT_PER_POSITION * numPositions[rowIndex])) {
                System.out.println("ERROR: Adding this musician would exceed the total weight limit for this row.");
            } else if (musicians[rowIndex][position - 1] != 0){
                System.out.print("ERROR: There is already a musician there.");
            } else {
                musicians[rowIndex][position - 1] = musicianWeight;
                System.out.println("******** Musician added.");
            }
        }// END OF ADD MUSICIAN METHOD

        private static void removeMusician(){
            char rowLetter;
            int rowIndex;

            System.out.print("Please enter a row letter      :");
            rowLetter = keyboard.next().toUpperCase().charAt(0);
            rowIndex = rowLetter - 'A';

            while ( rowIndex < 0 || rowIndex >= userRows){
                System.out.print("ERROR: Out of range, try again   :");
                rowLetter = (keyboard.next().toUpperCase().charAt(0));
                rowIndex = rowLetter -'A';
            }
            System.out.println("Please enter position number (1 to " + numPositions[rowIndex] + ") : ");
            int position = keyboard.nextInt();

            while (position < 1 || position > numPositions[rowIndex]){
                System.out.println("ERROR: Out of range, try again   : ");
                position = keyboard.nextInt();
            }
            if (musicians[rowIndex][position - 1] == 0){
                System.out.println("ERROR: That position is vacant.");
            } else {
                musicians[rowIndex][position - 1] = 0;
                System.out.println("******** Musician removed.");
            }

        }// END OF REMOVE MUSICIAN METHOD

        private static void printAssignmentOfPositions(){
            double weight;

            for (int i = 0; i < userRows; i++) {
                double totalRowWeight = 0;
                int totalMusicians = 0;
                System.out.print((char) ('A' + i )+ ":");
                for (int j = 0; j < numPositions[i]; j++) {
                    weight = musicians[i][j];
                    System.out.printf("%5.1f ", weight);
                    totalRowWeight += weight;
                    if (weight != 0) {
                        totalMusicians++;
                    }
                }
                double averageWeight = totalMusicians == 0 ? 0 : totalRowWeight / numPositions[i];
                System.out.printf("         [ %5.1f,  %6.1f]\n", totalRowWeight, averageWeight);

          }

        }// END OF PRINT ASSIGNMENT OF POSITIONS METHOD

        private static void menu(){
            String userInputMenu;

                do {
                    System.out.print("(A)dd, (R)emove, (P)rint,            e(X)it: ");
                    userInputMenu = keyboard.next().toUpperCase();
                    switch (userInputMenu) {
                        case "A":
                            addMusician();
                            break;
                        case "R":
                            removeMusician();
                            break;
                        case "P":
                            printAssignmentOfPositions();
                            break;
                        case "X":
                            break;
                        default:
                            System.out.println("ERROR: Invalid option, try again      :");
                    }
                } while (!(userInputMenu.equals("X")));

        }// END MENU METHOD
    }//END OF BAND OF HOUR PROJECT CLASS



