class Solution {
    public boolean isValidSudoku(char board[][]) {
        
        boolean[] freq = new boolean[10];

        for (int i = 0; i < 9; i++){

            Arrays.fill(freq,false);

            for (int j = 0; j < 9; j++){

                if(board[i][j] == '.') continue;

                if (freq[board[i][j]-'0'])
                    return false;

                freq[board[i][j]-'0'] = true;

            }

            Arrays.fill(freq,false);

            for (int j = 0; j < 9; j++){

                if(board[j][i] == '.') continue;

                if (freq[board[j][i]-'0'])
                    return false;

                freq[board[j][i]-'0'] = true;

            }

        }

        int sr = 0;
        int sc = 0;

        for (int i = 0; i < 9; i++){

            Arrays.fill(freq,false);

            for (int j = sr; j < sr + 3; j++){
                for (int k = sc; k < sc + 3; k++){

                    if(board[j][k] == '.') continue;

                    if (freq[board[j][k]-'0'])
                        return false;

                    freq[board[j][k]-'0'] = true;

                }
            }

            sc += 3;

            if (sc == 9){
                sc = 0;
                sr += 3;
            }

        }

        return true;

    }
}
