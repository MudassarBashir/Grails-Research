package com.experimental

class Owned {

    String name

    static belongsTo = [ownera: OwnerA, ownerb:OwnerB]
    static constraints = {
        ownera nullable: true
        ownerb nullable: true /* We make this nullable so that in the controller, we don't have to assign an ownerb to owned objects */
    }
}
