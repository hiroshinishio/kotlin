// FILE: main.kt

fun main() {
    val j: <!REDUNDANT_EXPLICIT_TYPE!>JavaClass<!> =  JavaClass()
}

// FILE: JavaClass.java

@()
public class JavaClass {}
