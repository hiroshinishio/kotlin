// SKIP_INLINE_CHECK_IN: lParams$default

// FILE: 1.kt

package test
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]
//A lot of blank lines [Don't delete]

inline fun kValue(): String {
    return getKValue()
}

inline fun lParams(initParams: () -> String = {
    "O" + kValue()
}): String {
    val z = "body"
    return initParams()
}

// FILE: 2.kt
package test

inline fun getKValue() = "K"

// FILE: 3.kt
import test.*

fun box(): String {
    return run {
        lParams()
    }
}
