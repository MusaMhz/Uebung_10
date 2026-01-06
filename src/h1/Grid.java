package h1;

public class Grid {
	private Cell[][] gridArray;
	
	public Cell [][] getGridArray(){
		return gridArray;
	}
	public void setGridArray(Cell[][] gridArray){
		this.gridArray = gridArray;
	}
	
	public Grid(Cell[] cells, int gridRows, int gridCols) {
	    this.gridArray = new Cell[gridRows][gridCols];
	    
	    for (int row = 0; row < gridRows; row++) {
	        for (int col = 0; col < gridCols; col++) {
	            gridArray[row][col] = new Cell(row, col, false);
	        }
	    }
	    
	    if (cells != null) {
	        for (Cell cell : cells) {
	            int targetRow = cell.getIndexRow();
	            int targetCol = cell.getIndexCol();
	            
	            if (targetRow >= 0 && targetRow < gridRows &&
	                targetCol >= 0 && targetCol < gridCols) {
	                gridArray[targetRow][targetCol].setAlive(true);
	            }
	        }
	    }
	    
	    for (int row = 0; row < gridRows; row++) {
	        for (int col = 0; col < gridCols; col++) {
	            gridArray[row][col].countLivingNeighbors(gridArray);
	        }
	    }
	}
	
	public void computeNextGen() {
	    int rows = gridArray.length;
	    int cols = gridArray[0].length;
	    
	    for (int row = 0; row < rows; row++) {
	        for (int col = 0; col < cols; col++) {
	            gridArray[row][col].countLivingNeighbors(gridArray);
	        }
	    }
	    
	    for (int row = 0; row < rows; row++) {
	        for (int col = 0; col < cols; col++) {
	            Cell cell = gridArray[row][col];
	            cell.setAlive(cell.isAliveNextGen());
	        }
	    }
	}

	public void computeGeneration(int n) {
	    for (int i = 0; i < n; i++) {
	        computeNextGen();
	    }
	}
	
	
	
	
	
}
