class Solution {
    public int countBattleships(char[][] board) {
        
        int count = 0;
        int n = board.length, m = board[0].length;
        int col = -1, row = -1;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){

                if (board[i][j] == 'X'){
                    count++;
                    board[i][j] = '.';
                    col = j;
                    if (col+1 < m && board[i][col+1] == 'X'){

                        while (col + 1 < m && board[i][col+1] == 'X'){
                            board[i][col+1] = '.';
                            col++;
                        }      
                        
                    }
                    row = i;
                    if (row + 1 < n && board[row+1][j] == 'X'){
                        while (row + 1 < n && board[row+1][j] == 'X'){
                            board[row+1][j] = '.';
                            row++;
                        }  
                    }

                }

            }
        }

        return count;

    }
}
