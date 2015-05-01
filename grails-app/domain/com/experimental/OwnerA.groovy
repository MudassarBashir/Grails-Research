package com.experimental

class OwnerA {
    String name

    static hasMany = [ owned : Owned ]

    static mapping = {
        owned cascade: "all-delete-orphan"

    }

    static constraints = {
        owned nullable: true
    }
}
