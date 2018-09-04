import javafx.util.Pair

import java.util.ArrayList

object Q98FindWordOn2dBoard {


    @JvmStatic
    fun main(args: Array<String>) {

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

        val visited = ArrayList<Pair<*, *>>()

        println(search(initBoard(), "ABCCED".toCharArray(), visited, 0, 0, 0))
        println(search(initBoard(), "SEE".toCharArray(), visited, 0, 0, 0))
        println(search(initBoard(), "ABCB".toCharArray(), visited, 0, 0, 0))
    }

    internal fun initBoard(): Array<CharArray> {
        return arrayOf(charArrayOf('A', 'B', 'C', 'E'), charArrayOf('S', 'F', 'C', 'S'), charArrayOf('A', 'D', 'E', 'E'))
    }


    internal fun search(board: Array<CharArray>, word: CharArray, visited: List<Pair<*, *>>, x: Int, y: Int, matches: Int): Boolean {
        var matches = matches


        if (x < 0 || y < 0 || x > board.size - 1 || y > board[0].size - 1) {
            return false
        }

        if (visited.contains(Pair(x, y))) {
            return false
        }

        if (matches == word.size) {
            return true
        }

        if (board[x][y] == word[matches]) {
            matches++
        }

        val visitedCopy = ArrayList(visited)
        visitedCopy.add(Pair(x, y))

        return (search(board, word, visitedCopy, x + 1, y, matches)
                || search(board, word, visitedCopy, x - 1, y, matches)
                || search(board, word, visitedCopy, x, y + 1, matches)
                || search(board, word, visitedCopy, x, y - 1, matches))

    }
}