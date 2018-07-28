object Q92CoursesPrerequisites {

    //We're given a hashmap with a key courseId and value a list of courseIds, which represents that the prerequsite of courseId is courseIds.
    //Return a sorted ordering of courses such that we can finish all courses.
    //Return null if there is no such ordering.
    //For example, given {'CSC300': ['CSC100', 'CSC200'],'CSC200': ['CSC100'], 'CSC100': []}, should return ['CSC100', 'CSC200', 'CSCS300'].

    //Approach: topological sort

    @JvmStatic
    fun main(args: Array<String>) {

        val courses: Map<String, List<String>> =
                mapOf("CSC300" to listOf("CSC100", "CSC200"),
                        "CSC200" to listOf("CSC100"),
                        "CSC100" to listOf());

        val indegrees = mutableMapOf<String, Int>()
        courses.keys.stream().forEach { s -> indegrees.merge(s, 1) { a, b -> a + b } }
        println(study("CSC300", courses, indegrees))

    }


    fun study(course: String, courses: Map<String, List<String>>, indegrees: MutableMap<String, Int>): Set<String> {

        val collect = mutableSetOf<String>()
        topo(course, courses, collect, indegrees);
        return collect
    }

    fun topo(course: String, courses: Map<String, List<String>>, collect: MutableSet<String>, indegrees: MutableMap<String, Int>) {

        for (n in courses.get(course).orEmpty()) {
            val count = indegrees.get(n)!!.minus(1)
            indegrees.put(n, count)
            if (count == 0) {
                topo(n, courses, collect, indegrees)
            }
        }
        collect.add(course)
    }


}