package com.exercise.Backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 八皇后问题（这里是n皇后）
 */
public class Backtracking01 {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new LinkedList<>();
        dfs(board, 0, res);
        return res;
    }

    private void dfs(char[][] board, int rowIndex, List<List<String>> res) {
        if(rowIndex == board.length) {
            res.add(construct(board));
            return;
        }

        for(int i = 0; i < board.length; i++) {
            if(validate(board, rowIndex, i)) {
                board[rowIndex][i] = 'Q';
                dfs(board, rowIndex + 1, res);
                board[rowIndex][i] = '.';
            }
        }

    }

    private List<String> construct(char[][] board) {
        List<String> subList = new LinkedList<>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            subList.add(s);
        }
        return subList;
    }

    private boolean validate(char[][] board, int x, int y) {
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < board.length; j++) {
                if(board[i][j] == 'Q' && (j == y || i + j == x + y || i - j == x - y)) {
                    return false;
                }
            }
        }
        return true;
    }
}
