// !SKIP_JAVAC
// !LANGUAGE: +InlineClasses
// ALLOW_KOTLIN_PACKAGE
// !DIAGNOSTICS: -UNUSED_PARAMETER

package kotlin.jvm

annotation class JvmInline

@JvmInline
value class X(val x: Int)
@JvmInline
value class Z(val x: Int)

class TestOk1(val a: Int, val b: Int) {
    constructor(x: X) : this(x.x, 1)
}

class TestErr1(val a: Int) {
    <!CONFLICTING_JVM_DECLARATIONS!>constructor(x: X)<!> : this(x.x)
}

class <!CONFLICTING_JVM_DECLARATIONS!>TestErr2(val a: Int, val b: Int)<!> {
    <!CONFLICTING_JVM_DECLARATIONS!>constructor(x: X)<!> : this(x.x, 1)
    <!CONFLICTING_JVM_DECLARATIONS!>constructor(z: Z)<!> : this(z.x, 2)
}
