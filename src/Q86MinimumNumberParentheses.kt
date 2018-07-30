//Given a string of parentheses, write a function to compute the minimum number of parentheses to be removed
// to make the string valid (i.e. each open parenthesis is eventually closed).

//For example, given the string "()())()", you should return 1.
// Given the string ")(", you should return 2, since we must remove all of them.

//Approach:
//BFS on the list of possible strings formed by the removal of a parentheses on the original string (and its derived)


object Q86MinimumNumberParentheses {
    @JvmStatic
    fun main(args: Array<String>) {
        println(test("()())()"))
        println(test(")("))
        println(test("()()()"))
    }


    fun test(s:String):Int {

        val toVisit= mutableListOf<String>()
        val visited= mutableListOf<String>()

        toVisit.add(s)

        while(!toVisit.isEmpty()) {

            val tmp = toVisit.removeAt(0)

            if (isValid(tmp)) return (s.length-tmp.length)

            for (i in 0 ..tmp.length-1) {
                val t = tmp.substring(0, i) + tmp.substring(i + 1)

                if (!visited.contains(t)) {
                    toVisit.add(t)
                    visited.add(t)
                }
            }
        }
        return -1

    }



    fun isValid(s:String) : Boolean {
        var count:Int =0
        s.forEach{c->
                if ( c == '(' ) count++;
                else if ( c == ')' && --count<0 ) return false;
        }
        return count==0
    }

}