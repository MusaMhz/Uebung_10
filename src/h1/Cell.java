package h1;

public class Cell {
    private int indexRow, indexCol, numLivingNeighbors;
    private boolean alive, isAliveNextGen;
    
    public Cell(int indexRow, int indexCol, boolean alive) {
        this.indexRow = indexRow;
        this.indexCol = indexCol;
        this.alive = alive;
        this.numLivingNeighbors = 0;
        this.isAliveNextGen = false;
    }
    
    public Cell(int indexRow, int indexCol) {
        this.indexRow = indexRow;
        this.indexCol = indexCol;
        this.alive = false;
        this.numLivingNeighbors = 0;
        this.isAliveNextGen = false;
    }
    
    public void countLivingNeighbors(Cell[][] gridArray) {
        int counter = 0;
        
        for (int rowOffset = -1; rowOffset <= 1; rowOffset++) {
            for (int colOffset = -1; colOffset <= 1; colOffset++) {
                if (rowOffset == 0 && colOffset == 0) {
                    continue;
                }
                
                int neighborRow = this.indexRow + rowOffset;
                int neighborCol = this.indexCol + colOffset;
                
                if (neighborRow >= 0 && neighborRow < gridArray.length &&
                    neighborCol >= 0 && neighborCol < gridArray[0].length) {
                    if (gridArray[neighborRow][neighborCol].isAlive()) {
                        counter++;
                    }
                }
            }
        }
        
        this.numLivingNeighbors = counter;
        this.decideNextStatus();
    }
    
    private void decideNextStatus() {
        if (this.alive) {
            this.isAliveNextGen = (this.numLivingNeighbors == 2 || this.numLivingNeighbors == 3);
        } else {
            this.isAliveNextGen = (this.numLivingNeighbors == 3);
        }
    }
    
   
    public int getIndexRow() { return indexRow; }
    public void setIndexRow(int indexRow) { this.indexRow = indexRow; }
    
    public int getIndexCol() { return indexCol; }
    public void setIndexCol(int indexCol) { this.indexCol = indexCol; }
    
    public boolean isAlive() { return alive; }
    public void setAlive(boolean alive) { this.alive = alive; }
    
    public int getNumLivingNeighbors() { return numLivingNeighbors; }
    public void setNumLivingNeighbors(int numLivingNeighbors) { 
        this.numLivingNeighbors = numLivingNeighbors; 
    }
    
    public boolean isAliveNextGen() { return isAliveNextGen; }
    public void setAliveNextGen(boolean isAliveNextGen) { 
        this.isAliveNextGen = isAliveNextGen; 
    }
}