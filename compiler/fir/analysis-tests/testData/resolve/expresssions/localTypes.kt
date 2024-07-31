interface Foo

fun foo() {
    val x: <!REDUNDANT_EXPLICIT_TYPE!>Int<!> = 1
    class Bar : Foo {
        val y: String = ""
        fun Int.bar(s: String): Boolean {
            val z: <!REDUNDANT_EXPLICIT_TYPE!>Double<!> = 0.0
            return true
        }
        val Boolean.w: Char get() = ' '
        fun <T : Foo> id(arg: T): T = arg
    }
}
