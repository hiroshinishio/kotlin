// DIAGNOSTICS: -UNUSED_PARAMETER
// OPT_IN: kotlin.contracts.ExperimentalContracts
// ISSUE: KT-70133

import kotlin.contracts.*

inline fun invokeInline(x: () -> Int, y: String) {
    contract { callsInPlace(x, InvocationKind.UNKNOWN) }
    x()
}

fun invokeInPlace(x: () -> Int, y: String) {
    contract { callsInPlace(x, InvocationKind.UNKNOWN) }
    x()
}

fun invokeLater(x: () -> Int, y: String) {
    x()
}

fun immutableInitAfterCaptureInline() {
    val x: String
    invokeInline(
        x = { x.length },
        y = if (true) { x = ""; "" } else { x = ""; "" },
    )
}

fun immutableInitAfterCaptureInPlace() {
    val x: String
    invokeInPlace(
        x = { <!UNINITIALIZED_VARIABLE!>x<!>.length },
        y = if (true) { x = ""; "" } else { x = ""; "" },
    )
}

fun immutableInitAfterCaptureLater() {
    val x: String
    invokeLater(
        x = { <!UNINITIALIZED_VARIABLE!>x<!>.length },
        y = if (true) { x = ""; "" } else { x = ""; "" },
    )
}

fun immutableInitBeforeCaptureInline() {
    val x: String
    invokeInline(
        y = if (true) { x = ""; "" } else { x = ""; "" },
        x = { x.length },
    )
}

fun immutableInitBeforeCaptureInPlace() {
    val x: String
    invokeInPlace(
        y = if (true) { x = ""; "" } else { x = ""; "" },
        x = { x.length },
    )
}

fun immutableInitBeforeCaptureLater() {
    val x: String
    invokeLater(
        y = if (true) { x = ""; "" } else { x = ""; "" },
        x = { x.length },
    )
}

fun mutableInitAfterCaptureInline() {
    var x: String
    invokeInline(
        x = { x.length },
        y = if (true) { x = ""; "" } else { x = ""; "" },
    )
}

fun mutableInitAfterCaptureInPlace() {
    var x: String
    invokeInPlace(
        x = { x.length },
        y = if (true) { x = ""; "" } else { x = ""; "" },
    )
}

fun mutableInitAfterCaptureLater() {
    var x: String
    invokeLater(
        x = { x.length },
        y = if (true) { x = ""; "" } else { x = ""; "" },
    )
}

fun mutableInitBeforeCaptureInline() {
    var x: String
    invokeInline(
        y = if (true) { x = ""; "" } else { x = ""; "" },
        x = { x.length },
    )
}

fun mutableInitBeforeCaptureInPlace() {
    var x: String
    invokeInPlace(
        y = if (true) { x = ""; "" } else { x = ""; "" },
        x = { x.length },
    )
}

fun mutableInitBeforeCaptureLater() {
    var x: String
    invokeLater(
        y = if (true) { x = ""; "" } else { x = ""; "" },
        x = { x.length },
    )
}
