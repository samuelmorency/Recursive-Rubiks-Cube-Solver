/****************************************************************************
 *
 * Created by: Sam Morency
 * Created on: December 2016
 * Created for: ICS4U
 * This class models and solves a 2x2 rubiks cube
 *
 ****************************************************************************/

import java.util.ArrayList;
public class Cube {
	public enum _colours {
		// enum for the colours on the faces of the cube
		B,
		R,
		W,
		Y,
		O,
		G
		
	}
	private int _numOfFaces = 6;
	private int _squaresPerFace = 4;
	private _colours[][] _cube = new _colours[this._numOfFaces][this._squaresPerFace];
	//create a list of moves to print to user
	private ArrayList<String> _moves = new ArrayList<String>();
	
	//Constructor
	public Cube (_colours [][] cubeInput) {
		this._cube = cubeInput;
		
	}
	
	//Where all of the magic happens
	//Solves cube recursively
	public void solveCube() {
		
		for (int counter = 0; counter < 33; counter++) {
			// 33 is the most # of moves that a 2x2 rubiks cube can be solved with
			// (only moving one direction i.e. not turning sides backwards)
			
			if (!(this.checkSolved() == true)) {
				
				this.getMoves(0, counter);
				// at this point, current move is 0
			}
			else {
				//print moves and exit method when solution is found
				this.printMoves();
				return;
			}
			
		}
		
	}
	
	public void getMoves (int currentMove, int movesToCheck) {
		
		if (currentMove < movesToCheck) {
			// recurse through each move
			
			for (int faceIndex = 0; faceIndex < 3; faceIndex++) {
				// do all three  moves and add to list 

				if (faceIndex == 0) {
						
					this._moves.add("Rotate front");
					this.rotateFront();
						
				}
				else if (faceIndex == 1) {
						
					this._moves.add("Rotate top");
					this.rotateTop();
						
				}
				else {
						
					this._moves.add("Rotate right");
					this.rotateRight();
						
				}
					
				getMoves(currentMove+1, movesToCheck); // move onto next branch
				
				
				if (this.checkSolved()) {
					// if solved, exit method
					return;
						
				}
				
				this._moves.remove(currentMove); // remove the current instruction index
				
				for (int counter = 0; counter < 3; counter++) {
					// if the cube is not solved undo last move by doing it 3 times
					
					if (faceIndex == 0) {
							
						this.rotateFront();
							
					}
					else if (faceIndex == 1) {
							
						this.rotateTop();
							
					}
					else {
						this.rotateRight();
					}
						
				}
					
			}
				
		}
		
	}
	
	public boolean checkSolved() {
		// checks if the current cube is solved
		
		for (_colours [] face : this._cube) {
			// for each face in the cube, if all the colours are not the same as the 
			// first colour, then it's not solved
			// otherwise, it is solved.
			for (int counter = 0; counter < 4; counter++) {
				
				if (face[counter] != face[0]) {
					
					return false;
					
				}
				
			}
			
		}
		
		return true;
		
	}
	
	public void rotateFront () {
		// rotates front face
		_colours [][] temp = new _colours [6][4];
		
		for (int counter = 0; counter < 6; counter++) {
			
			//duplicate cube so we can switch around values
			temp[counter] = this._cube[counter].clone();
			
		}
		this._cube[2][1] = temp[4][0];
		this._cube[2][2] = temp[4][1];
		this._cube[3][0] = temp[5][3];
		this._cube[3][3] = temp[5][2];
		this._cube[4][0] = temp[3][3];
		this._cube[4][1] = temp[3][0];
		this._cube[5][2] = temp[2][1];
		this._cube[5][3] = temp[2][2];
		
		for (int counter = 0; counter < 4; counter++) {
			// rotate the colours on the face being turned
			this._cube[0][(counter+1) % 4] = temp[0][counter];
			
		}
	}
	
    public void rotateTop () {
		// rotates top face
    	_colours [][] temp = new _colours [6][4];
		
		for (int counter = 0; counter < 6; counter++) {
			//duplicate cube so we can switch around values
			
			temp[counter] = this._cube[counter].clone();
			
		}
        for (int counter = 0; counter < 4; counter++) {
			this._cube[2][(counter+1) % 4] = temp[2][counter];
			
		}
		this._cube[0][0] = temp[5][0];
		this._cube[0][3] = temp[5][3];
		this._cube[1][0] = temp[4][0];
		this._cube[1][3] = temp[4][3];
		this._cube[4][0] = temp[0][0];
		this._cube[4][3] = temp[0][3];
		this._cube[5][0] = temp[1][0];
		this._cube[5][3] = temp[1][3];
		
        
	}
	
    public void rotateRight () {
	    // rotates the right face
    	_colours [][] temp = new _colours [6][4];
		
		for (int counter = 0; counter < 6; counter++) {
			//duplicate cube so we can switch around values
			
			temp[counter] = this._cube[counter].clone();
			
		}
		this._cube[0][0] = temp[3][0];
		this._cube[0][1] = temp[3][1];
		this._cube[1][3] = temp[2][1];
		this._cube[1][2] = temp[2][0];
		this._cube[2][0] = temp[0][0];
		this._cube[2][1] = temp[0][1];
		this._cube[3][0] = temp[1][2];
		this._cube[3][1] = temp[1][3];
	
        for (int counter = 0; counter < 4; counter++) {
			this._cube[5][(counter+1) % 4] = temp[5][counter];
			
		}
    }
    
    public void printMoves () {
    	// prints out all the moves to solve the cube
    	for (int counter = 0; counter < this._moves.size(); counter++) {
    		
    		System.out.println(this._moves.get(counter));
    		
    	}
    	
    	if (this._moves.size() == 0) {
    		// if there was no solution after each path of 33 turns
    		System.out.println("This cube is not solvable");
    	}
    	else {
    		System.out.println("Solved");
    	}
    	
}
}
