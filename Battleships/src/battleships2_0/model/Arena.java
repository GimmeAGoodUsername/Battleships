package battleships2_0.model;

import java.util.Scanner;

/**
 * The Class Grid.
 * 
 * @author Tim Gustaw 4691684 Gruppe 4b
 * @author Lukas Michaelis 4699916 Gruppe 4b 13.12.2015 Arena.java
 */
public class Arena {

	/** The grid. */
	private char[][] grid;

	/** The row number. */
	private int row;

	/** The column number. */
	private int column;

	/** The alphabet. */
	private char[] alphabet = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
	        'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
	        'W', 'X', 'Y', 'Z' };

	private Scanner sc = new Scanner(System.in);

	/**
	 * Instantiates a new grid.
	 * 
	 * @param row
	 *            the row
	 * @param column
	 *            the column
	 */
	public Arena(int row, int column) {

		this.row = row;
		this.column = column;
		this.grid = new char[this.row][this.column];
		this.generateGrid();
	}

	/**
	 * Prints a test version of the alphabet which i had to do to test some
	 * wrong inputs etc.
	 */
	public void printTest() {
		for (int i = 0; i < 10; i++) {
			System.out.println(this.detectChar(alphabet[i]) + " " + i + " "
			        + alphabet[i]);
		}
	}

	/**
	 * Generate grid.
	 */
	public void generateGrid() {
		for (int i = 0; i < this.row; i++) {
			for (int j = 0; j < this.column; j++) {
				this.grid[i][j] = '.';
			}
		}
	}
	public void setValue(int row, int column, char value){
	    this.grid[row][column]= value;
	}
	public char[][] getGrid() {
        return grid;
    }

    public void setGrid(char[][] grid) {
        this.grid = grid;
    }

    /**
	 * Prints the grid.
	 * 
	 * @return
	 */
	public String toString() {
		String output = " ";
		for (int i = 0; i < this.column; i++) {

			output += " " + i;

		}
		output += "\n";

		for (int i = 0; i < this.row; i++) {
			output += alphabet[i] + " ";
			for (int j = 0; j < this.column; j++) {
				output += grid[i][j] + " ";

			}
			output += "\n";
		}
		return output;
	}

	/**
	 * Lets the user place his ships on the grid and checks for collision as
	 * well as wrong inputs
	 */
	// When I wrote this, only God and I understood what I was doing
	// Now, God only knows

	public void setShips() {
		this.generateGrid();
		ShipTypes[] sT = { ShipTypes.Carrier, ShipTypes.Battleship,
		        ShipTypes.Submarine, ShipTypes.Destroyer };

		System.out.println(this);
		outer: for (int i = 0; i < sT.length; i++) {
			inner: for (int j = 0; j < sT[i].getSum(); j++) {
				System.out
				        .println("Where do you want to place your ship named '"
				                + sT[i] + "' with the length '"
				                + sT[i].getLength()
				                + "' (example: From: A1-A5)");
				String input = this.sc.nextLine();
				if (!this.checkInput(sT[i].name(), sT[i].getLength(), input)) {
					System.out
					        .println("You have entered a wrong value please redo");
					this.setShips();
					break outer;
				}
				System.out.println(this);
			}
		}
	}

	public boolean checkInput(String name, int length, String input)
	        throws StringIndexOutOfBoundsException {
		int fromRow;
		int fromColumn;
		int toRow;
		int toColumn;
		if (!Character.isAlphabetic(input.charAt(1))
		        && !Character.isAlphabetic(input.charAt(4))) {
			fromRow = detectChar(input.charAt(0));
			fromColumn = Character.getNumericValue(input.charAt(1));

			toRow = detectChar(input.charAt(3));
			toColumn = Character.getNumericValue(input.charAt(4));
			if (toRow > this.row || toRow < 0 || fromRow > this.row
			        || fromRow < 0) {
				return false;

			}

			if (!this.placeShip(fromRow, fromColumn, toRow, toColumn, length)) {
				return false;
			}

		} else {
			System.out.println("You have entered a wrong Value please redo");
			return false;
		}

		return true;
	}

	private boolean placeShip(int fromRow, int fromColumn, int toRow,
	        int toColumn, int length) throws StringIndexOutOfBoundsException {
		int srow = fromRow;
		int scolumn = fromColumn;
		if (fromRow > toRow && !((fromRow - length) < 0)) {
			for (int x = 0; x < length; x++) {
				if (this.grid[srow - x][scolumn] == '#') {
					return false;
				} else {
					this.grid[srow - x][scolumn] = '#';
				}
			}
		} else if (toRow > fromRow && !((toRow + length) > this.row)) {
			for (int x = 0; x < length; x++) {
				if (this.grid[srow + x][scolumn] == '#') {
					return false;
				} else {
					this.grid[srow + x][scolumn] = '#';
				}

			}
		} else if (fromColumn > toColumn && !((fromColumn - length) < 0)) {
			for (int x = 0; x < length; x++) {
				if (this.grid[srow - x][scolumn] == '#') {
					return false;
				} else {
					this.grid[srow][scolumn - x] = '#';
				}
			}
		} else if (toColumn > fromColumn && !(toColumn + length > this.column)) {
			for (int x = 0; x < length; x++) {
				if (this.grid[srow][scolumn + x] == '#') {
					return false;
				} else {
					this.grid[srow][scolumn + x] = '#';
				}
			}
		} else {
			return false;
		}
		return true;
	}

	

	

	/**
	 * Detect char. Checks a char and returns the numeric value.
	 * 
	 * @param c
	 *            the c
	 * @return the int
	 */
	public int detectChar(char c) {
		c = Character.toUpperCase(c);
		int out = 999;
		switch (c) {
		case 'A':
			return AlphabeticValue.A.getValue();
		case 'B':
			return AlphabeticValue.B.getValue();
		case 'C':
			return AlphabeticValue.C.getValue();
		case 'D':
			return AlphabeticValue.D.getValue();
		case 'E':
			return AlphabeticValue.E.getValue();
		case 'F':
			return AlphabeticValue.F.getValue();
		case 'G':
			return AlphabeticValue.G.getValue();
		case 'H':
			return AlphabeticValue.H.getValue();
		case 'I':
			return AlphabeticValue.I.getValue();
		case 'J':
			return AlphabeticValue.J.getValue();
		case 'K':
			return AlphabeticValue.K.getValue();
		case 'L':
			return AlphabeticValue.L.getValue();
		case 'M':
			return AlphabeticValue.M.getValue();
		case 'N':
			return AlphabeticValue.N.getValue();
		case 'O':
			return AlphabeticValue.O.getValue();
		case 'P':
			return AlphabeticValue.P.getValue();
		case 'Q':
			return AlphabeticValue.Q.getValue();
		case 'R':
			return AlphabeticValue.R.getValue();
		case 'S':
			return AlphabeticValue.S.getValue();
		case 'T':
			return AlphabeticValue.T.getValue();
		case 'U':
			return AlphabeticValue.U.getValue();
		case 'V':
			return AlphabeticValue.V.getValue();
		case 'W':
			return AlphabeticValue.W.getValue();
		case 'X':
			return AlphabeticValue.X.getValue();
		case 'Y':
			return AlphabeticValue.Y.getValue();
		case 'Z':
			return AlphabeticValue.Z.getValue();
		default:
			break;
		}
		return out;

	}
}
