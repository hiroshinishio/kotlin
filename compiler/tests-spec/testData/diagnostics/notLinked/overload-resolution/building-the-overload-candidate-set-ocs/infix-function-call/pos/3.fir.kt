// DIAGNOSTICS: -UNUSED_VARIABLE -UNUSED_PARAMETER
// SKIP_TXT

/*
 * KOTLIN DIAGNOSTICS NOT LINKED SPEC TEST (POSITIVE)
 *
 * SECTIONS: overload-resolution, building-the-overload-candidate-set-ocs, infix-function-call
 * NUMBER: 3
 * DESCRIPTION: "Unsafe" cast doesn't work in case of property infix call
 * UNEXPECTED BEHAVIOUR
 * ISSUES: KT-36786
 */

class B(val memberVal: Any)
class C() {
    infix operator fun invoke(i: Int) { } //(1)
}

// TESTCASE NUMBER: 1
fun case1() {
    val b: <!REDUNDANT_EXPLICIT_TYPE!>B<!> = B(C())
    b <!FUNCTION_EXPECTED!>memberVal<!> 1
    b.memberVal.<!UNRESOLVED_REFERENCE!>invoke<!>(2)
    b.<!FUNCTION_EXPECTED!>memberVal<!>(1)

    b.memberVal as C

    b memberVal 1
    b.memberVal.invoke(1)

    b.memberVal(1)
    (b.memberVal)(1)

}
