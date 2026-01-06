package h2;

public class Spielstein {
	private int currentRow, currentCol;
	private Spielbrett brett;
	
	public Spielstein(Spielbrett brett, int indexRow, int indexCol) {
		this.currentRow = indexRow;
		this.currentCol = indexCol;
		this.brett = brett;
	}
	
	
	private boolean movesOut() {
		Feld [][] alleFelder = brett.getBrett();
		Feld aktuellesFeld = alleFelder [currentRow][currentCol];
		char direction = aktuellesFeld.getDirection();
		int brettDim = brett.getDim();
		
		if (direction == 'U' && currentRow == 0) {
			return true;
		}
		if (direction == 'D' && currentRow == brettDim -1) {
			return true;
		}
		
		if (direction == 'L' && currentCol == 0) {
			return true;
		}
		
		if (direction == 'R' && currentCol == brettDim -1) {
			return true;
		} return false;
	}
	
	
	public void go(int n ) {
		for (int i = 0; i < n; i++) {
			 Feld aktuellesFeld = brett.getBrett()[currentRow][currentCol];
			 
			 if (aktuellesFeld.getBoese()) continue;
			 
			 char direction = aktuellesFeld.getDirection();
			 
			 int neueRow = currentRow;
			 int neueCol = currentCol;
			 if (direction == 'U') {
				 neueRow = currentRow - 1;
			 } else if (direction == 'D') {
				 neueRow = currentRow +1;
			 } else if (direction == 'L') {
				 neueCol = currentCol -1;
			 } else if (direction == 'R') {
				 neueCol = currentCol +1;
			 }
			 
			 int dim = brett.getDim();
			 if (neueRow >= 0 && neueRow < dim && neueCol >= 0 && neueCol < dim) {
				 currentRow = neueRow;
				 currentCol = neueCol;
			 }
		}
	}
	
	
	
	public void setCurrentRow(int currentRow) {
		this.currentRow = currentRow;
	}
	
	public void setCurrentCol(int currentCol) {
		this.currentCol = currentCol;
	}
	
	public void setBrett(Spielbrett brett) {
		this.brett = brett;
	}
	
	public int getCurrentRow() {
		return currentRow;
	}
	
	public int getCurrentCol() {
		return currentCol;
	}
	
	public Spielbrett getBrett() {
		return brett;
	}
}
