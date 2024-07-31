// DIAGNOSTICS: -UNUSED_VARIABLE
// KT-4351 Cannot resolve reference to self in init of class local to function

fun f() {
    class MyClass() {
        init {
            val x: <!REDUNDANT_EXPLICIT_TYPE!>MyClass<!> = MyClass()
        }

        fun member() {
            val x: <!REDUNDANT_EXPLICIT_TYPE!>MyClass<!> = MyClass()
        }
    }

    <!LOCAL_OBJECT_NOT_ALLOWED!>object MyObject<!> {
        init {
            val obj: MyObject = MyObject
        }
    }

    val x: <!REDUNDANT_EXPLICIT_TYPE!>MyClass<!> = MyClass()
}

val closure = {
    class MyClass {
        init {
            val x: <!REDUNDANT_EXPLICIT_TYPE!>MyClass<!> = MyClass()
        }
    }
}
