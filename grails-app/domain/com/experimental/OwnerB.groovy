package com.experimental

class OwnerB {
    String name

    static hasMany = [ owned : Owned ]



    static mapping = {
        owned cascade: "all-delete-orphan"
    }
}
