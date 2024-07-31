// PLATFORM_DEPENDANT_METADATA
package test

import java.io.Serializable

public open class AllBoundsInWhen {
    public open fun <T> foo() where T: Serializable {
        throw UnsupportedOperationException()
    }
}

// org.jetbrains.kotlin.js.test.fir.FirLoadK2CompiledJsKotlinTestGenerated.CompiledKotlin.FromLoadJava.KotlinSignature#testAllBoundsInWhen
// ambiguity betweeen kotlin.Serializable, kotlin.io.Serializable