class Solution {
    public int countBattleships(char[][] board) {
        int numOfShips = 0;
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    numOfShips++;
                    this.blowUpShip(i, j, board);
                }
            }
        }
        
        return numOfShips;
    }
    
    public void blowUpShip(int row, int col, char[][] board) {
        int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        
        
        for(int[] dir : directions) {
            int r = row + dir[0];
            int c = col + dir[1];
            
            while(r >= 0 && r < board.length && c >=0 && c < board[0].length) {
                if (board[r][c] == 'X') {
                    board[r][c] = 'O';
                } else if (board[r][c] == '.') {
                    break;
                }
                
                r += dir[0];
                c += dir[1];
            }
        }
    }
}