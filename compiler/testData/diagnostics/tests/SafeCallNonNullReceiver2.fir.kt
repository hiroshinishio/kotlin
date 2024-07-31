// http://youtrack.jetbrains.net/issue/KT-418

fun ff() {
    val i: <!REDUNDANT_EXPLICIT_TYPE!>Int<!> = 1
    val a: Int? = i<!UNNECESSARY_SAFE_CALL!>?.<!>plus(2)
}
