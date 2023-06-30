// LANGUAGE: +ContextReceivers

package value_parameters.test

inline fun funWithInlineParameters1(
    inlineBlock: (Int) -> String,
    noinline noinlineBlock: (Int) -> String,
    crossinline crossinlineBlock: (Int) -> String
): String = ""

inline fun funWithInlineParameters2(
    inlineBlock: Function1<Int, String>,
    noinline noinlineBlock: Function1<Int, String>,
    crossinline crossinlineBlock: Function1<Int, String>
): String = ""

fun funWithDefaultArgs(p1: Int = 42, p2: Long, p3: String = ""): String = ""

// This is needed to check that value parameter indices are properly deserialized for functions with context receivers.
context(Int, Long) fun funWithDefaultArgs(p1: Int = 42, p2: Long, p3: String = ""): String = ""

inline fun funWithMixedStuff(
    crossinline block: (Int) -> String = { it.toString() }
): String = ""
