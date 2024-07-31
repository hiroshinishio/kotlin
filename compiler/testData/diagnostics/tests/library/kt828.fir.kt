fun test() {
    var res : <!REDUNDANT_EXPLICIT_TYPE!>Boolean<!> = true
    res = (res and false)
    res = (res or false)
    res = (res xor false)
    res = (true and false)
    res = (true or false)
    res = (true xor false)
    res = (!true)
    res = (true && false)
    res = (true || false)
}
