class NxNTicTacToeChecker {
  public static void main(String[] args) {
    System.out.println("hello world");
    char[][] board = new char[4][4];
     //ACROSS
    board[0][0] = 'X';
    board[0][1] = 'X';
    board[0][2] = 'X';
    board[0][3] = 'X';
    
    /* DOWN (tracked, confusingly, by rowSum and incorrectly not cleared between iterations of the outer loop in the reference code)
    board[0][0] = 'X';
    board[1][0] = 'X';
    board[2][0] = 'X';
    board[3][0] = 'X';
    */
    /* TOP LEFT TO LOWER RIGHT DIAG
    board[0][0] = 'X';
    board[1][1] = 'X';
    board[2][2] = 'X';
    board[3][3] = 'X';
    */
    /* TOP RIGHT TO LOWER LEFT DIAG
    board[0][3] = 'X';
    board[1][2] = 'X';
    board[2][1] = 'X';
    board[3][0] = 'X';
    */
    
    System.out.println(checkXWinner(board, 4));
  }
  
  static boolean checkXWinner(char[][] a, int n){
    int[] diagonalSums = new int[2];
    int[] columnSums = new int[n];
    int rowSum = 0;
    for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                     if (a[i][j] == 'X') {
                            rowSum++;
                            columnSums[j]++;
                            if (i == n-1 && columnSums[j] == n) return true;
                            else if (i == j) {
                                     diagonalSums[0]++;
                                     if (i == n-1 && diagonalSums[0] == n) return true;
                            }
                            else if (i == n-1-j) {
                                     diagonalSums[1]++;
                                     if (j == 0 && diagonalSums[1] == n) return true;
                            }
                     }
            }
            if (rowSum == n) return true;
            rowSum = 0;  // THIS WAS MISSING IN THE REFERENCE PSEUDO CODE
    }
    return false;
  }
}