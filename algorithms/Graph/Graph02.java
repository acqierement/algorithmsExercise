import java.util.HashSet;
import java.util.Set;

public class Graph02 {
    // 使用set对每一行每一列每一格进行验证。
    // 三个for循环分别对行、列、格进行验证。对于9个格要对i和j进行转换
    public boolean isValidSudoku01(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            Set<Character> rowSet = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') continue;
                if (!rowSet.add(board[i][j])) return false;
            }
        }

        for (int i = 0; i < board.length; i++) {
            Set<Character> colSet = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[j][i] == '.') continue;
                if (!colSet.add(board[j][i])) return false;
            }
        }

        for (int i = 0; i < board.length; i++) {
            Set<Character> boxSet = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                int rowIndex = 3 * (i / 3);  // 000333666
                int colIndex = 3 * (i % 3);  // 036036036
                int m = rowIndex + j / 3;
                int n = colIndex + j % 3;
                if (board[m][n] == '.') continue;
                if (!boxSet.add(board[m][n])) return false;
            }
        }
        return true;
    }

    // 对于前一个方法，三个for循环可以合成一个。
    public boolean isValidSudoku02(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rows = new HashSet<Character>();
            HashSet<Character> columns = new HashSet<Character>();
            HashSet<Character> cube = new HashSet<Character>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j]))
                    return false;
                if (board[j][i] != '.' && !columns.add(board[j][i]))
                    return false;
                int RowIndex = 3 * (i / 3);
                int ColIndex = 3 * (i % 3);
                if (board[RowIndex + j / 3][ColIndex + j % 3] != '.' && !cube.add(board[RowIndex + j / 3][ColIndex + j % 3]))
                    return false;
            }
        }
        return true;
    }

    // set里面存的是字符串，通过文字来对三种情况进行检查。简单易懂，可读性强。
    public boolean isValidSudoku03(char[][] board) {
        Set seen = new HashSet();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i/3 + "-" + j/3))
                        return false;
            }
        }
        return true;
    }
}
