fun test(<expr>b: Boolean</expr>): Int {
    val (one, two) = b to !b
    return if (one && two) {
        54
    } else {
        45
    }
}