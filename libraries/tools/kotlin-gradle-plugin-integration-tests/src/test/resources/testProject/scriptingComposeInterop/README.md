# Compose + Scripting Test Project

This project is a modified version of https://github.com/cmelchior/kotlin-script-examples/tree/master/jvm/simple-main-kts
It is intended to catch problems when using the Compose Compiler Plugin on a Kotlin script.

See:
 - https://youtrack.jetbrains.com/issue/KT-67066/DeepCopyIrTreeWithSymbols-does-not-copy-IrScript-nodes-correctly
 - https://youtrack.jetbrains.com/issue/KT-69856/Compose-Plugin-IrType.erasedUpperBound-throws-NullPointerException-when-evaluating-IrScript-nodes-due-to-missing-targetClass
 - https://issuetracker.google.com/issues/329677662
