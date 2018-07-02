package problem98;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String args[]) {

     /*   Given a 2D board of characters and a word, find if the word exists in the grid.

        The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or
        vertically neighboring. The same letter cell may not be used more than once.

        For example, given the following board:

        [
          ['A','B','C','E'],
          ['S','F','C','S'],
          ['A','D','E','E']
        ]
        exists(board, "ABCCED") returns true, exists(board, "SEE") returns true, exists(board, "ABCB") returns false.

        */

        /*
        Approach:
            Depth first search on the board, keeping track of the number of characters matched,
            and stopping when number of characters matched = length of the word to search for.
         */

        List<Pair> visited = new ArrayList<Pair>();

        System.out.println(search(initBoard(), "ABCCED".toCharArray(), visited, 0, 0, 0));
        System.out.println(search(initBoard(), "SEE".toCharArray(), visited, 0, 0, 0));
        System.out.println(search(initBoard(), "ABCB".toCharArray(), visited, 0, 0, 0));
    }

    static char[][] initBoard() {
        return new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
    }


    static boolean search(char[][] board, char[] word, List<Pair> visited, int x, int y, int matches) {


        if (x < 0 || y < 0 || x > board.length - 1 || y > board[0].length - 1) {
            return false;
        }

        if (visited.contains(new Pair<>(x, y))) {
            return false;
        }

        if (matches == word.length) {
            return true;
        }

        if (board[x][y] == word[matches]) {
            matches++;
        }

        List<Pair> visitedCopy = new ArrayList<>(visited);
        visitedCopy.add(new Pair<>(x, y));

        return search(board, word, visitedCopy, x + 1, y, matches)
                || search(board, word, visitedCopy, x - 1, y, matches)
                || search(board, word, visitedCopy, x, y + 1, matches)
                || search(board, word, visitedCopy, x, y - 1, matches);

    }
}