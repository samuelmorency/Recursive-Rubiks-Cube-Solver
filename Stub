/****************************************************************************
 *
 * Created by: Sam Morency
 * Created on: December 2016
 * Created for: ICS4U
 * This is a stub class for a rubiks cube program
 *
 ****************************************************************************/

import java.util.Scanner;

public class Stub {
	public static void main(String[] args) {
		
	    Scanner scan = new Scanner(System.in);
	    
	    //Guilty until Proven innocent
	    boolean inputIsValid = false;
		//1d array of _colours on cube
		Cube._colours [] cubeInput1d = new Cube._colours[24];
		
		
		for (int counter = 0; counter < cubeInput1d.length; counter++) {
			
			inputIsValid = false;
			
			if ((counter == 0)) {
				System.out.println();
				System.out.println("Front: ");
				
			}
			
			if (counter == 4) {
				System.out.println();
				System.out.println("Back: ");
				
			}
			
			if (counter == 8) {
				System.out.println();
				System.out.println("Top: ");
				
			}
			
                        if (counter == 12) {
            	                System.out.println();
				System.out.println("Bottom: ");
				
			}
            
                        if (counter == 16) {
            	                System.out.println();
				System.out.println("Left: ");
				
			}
			
                        if (counter == 20) {
            	                System.out.println();
				System.out.println("Right: ");
				
			}
            
			while (!(inputIsValid == true)) {
				try {
					System.out.println("Square" + " " + ((counter % 4) + 1) + ": ");
					cubeInput1d[counter] = Cube._colours.valueOf(scan.nextLine());
					inputIsValid = true;
					
				} catch (IllegalArgumentException e) {
					
					System.err.println("Invalid input - please re-enter");
					inputIsValid = false;
				} 
			}
			
			
		}
	
        Cube._colours [][] cubeInput2d = oneToTwo(cubeInput1d);
		Cube rubiksCube = new Cube(cubeInput2d);
		// instantiate the cube object
		
		if ((rubiksCube.checkSolved() == true)) {
				
			System.out.println("Turn any face forward then back and bam");
			// if the cube is already solved, tell the user
		}
		else {
			System.out.println("Calculating...");	
			rubiksCube.solveCube();
				
		}
			
	}
		
	public static Cube._colours [][] oneToTwo (Cube._colours [] oneDimArray) {
		// converts 1d array to 2d
		// six faces with four squares each
		Cube._colours [][] twoDArray = new Cube._colours [6][4];
			
		for (int collumnOneCounter = 0; collumnOneCounter < 6; collumnOneCounter++) {
				
			for (int collumnTwoCounter = 0; collumnTwoCounter < 4; collumnTwoCounter++) {
				// 4 * Counter1 skips through each face already converted
				twoDArray[collumnOneCounter][collumnTwoCounter] = oneDimArray[4*collumnOneCounter + collumnTwoCounter];
					
			}	
		}
			
		return twoDArray;
			
}
}
