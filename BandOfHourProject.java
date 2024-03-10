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



    public static void main(String[] args) {
        System.out.println("Welcome to the Band of the Hour\n---------------------------\n");
        getRowsAndPositions();
        menu();


    }// END OF MAIN METHOD
     private static void getRowsAndPositions() {
        int userPositions = 0;

        System.out.print("Please enter the number of rows     :");
        userRows = keyboard.nextInt();


         while (userRows >= MAX_ROWS) {
             System.out.print("ERROR: Out of range, try again   :");
             userRows = keyboard.nextInt();

             int[] numPositions;
             numPositions = new int[userRows];
             for (int i = 0; i < userRows; i++) {
                 System.out.print("Please enter number of positions in row " + (char) ('A' + i) + " : ");

                 userPositions = keyboard.nextInt();
                 while (userPositions > MAX_NUM_POSITIONS) {
                     System.out.print("ERROR: Out of range, try again  :");
                     userPositions = keyboard.nextInt();
                 }
                 numPositions[i] = userPositions;

                }
            }

        } //END OF GET ROWS AND POSITIONS METHOD


        private static void addMusician(){
            char rowLetter;
            int rowIndex;
            System.out.println("Please enter a row letter     : ");
            rowLetter = (keyboard.next().toUpperCase().charAt(0));
            rowIndex = rowLetter - 'A';

            while (rowIndex >= userRows){
                System.out.println("ERROR: Out of range, try again   :");
                rowLetter = (keyboard.next().toUpperCase().charAt(0));
                rowIndex = rowLetter -'A';

            }


            System.out.println("Please enter position number (1 to" + numPositions[rowIndex] + "");



        }// END OF ADD MUSICIAN METHOD

        private static void removeMusician(){

        }// END OF REMOVE MUSICIAN METHOD

        private static void printAssignmentOfPositions(){

        }// END OF PRINT ASSIGNMENT OF POSITIONS METHOD
        private static void menu(){
            String userInputMenu;
            System.out.println("(A)dd, (R)emove, (P)rint,            e(X)it: ");
            userInputMenu = keyboard.next().toUpperCase();

            while (!(userInputMenu == "X")){
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
                    case "X" :
                        break;
                    default:
                        System.out.println("ERROR: Invalid option, try again      :");


            }


            }


        }// END MENU METHOD
    }//END OF BAND OF HOUR PROJECT CLASS



