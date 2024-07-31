// FIR_DUMP

class Base {
    private class Private

    fun test() {
        object {
            val x: Private = Private()

            init {
                val y: <!REDUNDANT_EXPLICIT_TYPE!>Private<!> = Private()
            }

            fun foo() {
                val z: <!REDUNDANT_EXPLICIT_TYPE!>Private<!> = Private()
            }
        }
    }
}
