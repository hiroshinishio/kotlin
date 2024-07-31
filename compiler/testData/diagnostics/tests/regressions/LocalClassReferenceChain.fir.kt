// KT-47135

fun test2() {
    class LocalA {
        inner class LocalB {
            inner class LocalC {
            }
        }
    }

    fun LocalA.LocalB.blah() {
        val c: <!REDUNDANT_EXPLICIT_TYPE!>LocalA.LocalB.LocalC<!> = LocalC()
    }
}
