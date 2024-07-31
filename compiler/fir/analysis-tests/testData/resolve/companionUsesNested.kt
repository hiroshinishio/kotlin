abstract class Base {
    class BaseNested
}

class Derived : Base() {
    class DerivedNested

    companion object {
        val b: BaseNested = BaseNested()

        val d: DerivedNested = DerivedNested()

        fun foo() {
            val bb: <!REDUNDANT_EXPLICIT_TYPE!>BaseNested<!> = BaseNested()
            val dd: <!REDUNDANT_EXPLICIT_TYPE!>DerivedNested<!> = DerivedNested()
        }
    }
}
