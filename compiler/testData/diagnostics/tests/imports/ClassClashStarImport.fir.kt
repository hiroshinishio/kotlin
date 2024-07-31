// MODULE: m1
// FILE: a.kt
package a

class B {
    fun m1() {}
}

// MODULE: m2
// FILE: b.kt
package a

class B {
    fun m2() {}
}

// MODULE: m3(m2, m1)
// FILE: b.kt
import a.*


fun test(b: B) {
    b.m2()
    b.<!UNRESOLVED_REFERENCE!>m1<!>()

    val b_: <!REDUNDANT_EXPLICIT_TYPE!>B<!> = B()
    b_.m2()

    val b_1: <!REDUNDANT_EXPLICIT_TYPE!>a.B<!> = B()
    b_1.m2()

    val b_2: <!REDUNDANT_EXPLICIT_TYPE!>B<!> = a.B()
    b_2.m2()

    val b_3 = B()
    b_3.m2()

    val b_4 = a.B()
    b_4.m2()
}


//----------------------------TOP LEVEL---------------------

// MODULE: top_m1
// FILE: top_a.kt
class B {
    fun m1() {}
}

// MODULE: top_m2
// FILE: top_b.kt
class B {
    fun m2() {}
}

// MODULE: top_m3(top_m2, top_m1)
// FILE: top_c.kt

fun test(b: B) {
    b.m2()
    b.<!UNRESOLVED_REFERENCE!>m1<!>()

    val b_: <!REDUNDANT_EXPLICIT_TYPE!>B<!> = B()
    b_.m2()

    val b_2 = B()
    b_2.m2()

    val b_3 = B()
    b_3.m2()

    val b_4 = <!UNRESOLVED_REFERENCE!>a<!>.B()
    b_4.m2()
}
