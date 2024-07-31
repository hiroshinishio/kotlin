fun Int.gg() = null

fun ff() {
    val a: <!REDUNDANT_EXPLICIT_TYPE!>Int<!> = 1
    val b: Int = <!INITIALIZER_TYPE_MISMATCH, TYPE_MISMATCH!>a<!UNNECESSARY_SAFE_CALL!>?.<!>gg()<!>
}
