class Bar<T>(t: T?)
fun <T> bar(t: T) = Bar(t)

val b = bar<String?>(null)

fun accept(arg: Bar<String?>) {

}

fun main() {
    accept(<!ARGUMENT_TYPE_MISMATCH!>b<!>)
}
