// WITH_REFLECT

// example from the issue KT-68685
import kotlin.reflect.full.memberProperties

data class Response(
    val list: List<Data>,
) {
    data class Data(
        val id: String,
    )
}

val mp1 = Response::class.memberProperties.single()
val mp2 = Response.Data::class.memberProperties.single()

// simplified and extended repro
class O {
    class K {
        inner class `!`
        companion object {
            fun foo(): String {
                class Foo
                return Foo::class.simpleName!!
            }
        }
    }
}

val o = O::class.simpleName
val k = O.K::class.simpleName
val `!` = O.K.`!`::class.simpleName

fun bar(): String {
    class Bar
    return Bar::class.simpleName!!
}

val rv = "$o$k$`!`_${O.K.foo()}_${bar()}"

// expected: rv: OK!_Foo_Bar
