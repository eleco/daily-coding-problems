import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

import java.util.concurrent.Executors.newSingleThreadScheduledExecutor

object Q105Debounce {

    //Given a function f, and N return a debounced f of N milliseconds.
    //That is, as long as the debounced f continues to be invoked, f itself will not be called for N milliseconds.

    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {

        val d = Debounce(5)
        for (i in 0..99) {
            d.debounce(Runnable { print("x") })
            Thread.sleep(1000)
        }
    }


    internal class Debounce(private val wait: Int) {

        private val executorService = newSingleThreadScheduledExecutor()
        @Volatile
        private var debouncing: Boolean = false

        fun debounce(r: Runnable) {
            print(".")
            if (!debouncing) {
                r.run()
                debouncing = true
                executorService.schedule({ debouncing = false }, wait.toLong(), TimeUnit.SECONDS)
            }
        }

    }

}

