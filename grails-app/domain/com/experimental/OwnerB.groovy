package com.experimental

class OwnerB {
    String name

    static hasMany = [ owned : Owned ]

    static constraints = {
    }
}
