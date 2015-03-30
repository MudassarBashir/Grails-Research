package com.experimental

class OwnerA {
    String name

    static hasMany = [ owned : Owned ]

    static constraints = {

    }
}
