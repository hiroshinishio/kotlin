// PLATFORM_DEPENDANT_METADATA
//ALLOW_AST_ACCESS

package test

import java.io.Serializable

@Target(AnnotationTarget.TYPE)
annotation class A

interface Foo<T : @A Number> : @A Serializable {
    fun <E, F : @A E> bar()
}

// org.jetbrains.kotlin.js.test.fir.FirLoadK2CompiledJsKotlinTestGenerated.CompiledKotlin.Annotations.Types#testSupertypesAndBounds
// Some propblem with f/o builder