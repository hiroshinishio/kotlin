// SKIP_TXT
// FIR_DUMP

abstract class InlineCompletionSessionManager {
    protected class Proto {
        class Some
    }
}

fun checkCannotAccess() {
    object : InlineCompletionSessionManager() {
        fun chch() {
            val b: <!REDUNDANT_EXPLICIT_TYPE!>Proto<!> = Proto()
            if (<!USELESS_IS_CHECK!>b is Proto.Some<!>) return
        }
    }
}
