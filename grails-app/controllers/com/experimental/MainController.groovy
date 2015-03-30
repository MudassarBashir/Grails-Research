package com.experimental

class MainController {

    def index () {}

    def caseofOneOwner() {
        // creating a few instances of the owned domain class
        def owneda = new Owned(name: 'Owned A')
        def ownedb = new Owned(name: 'Owned B')
        def ownedc = new Owned(name: 'Owned C')

        // now we make these instances belong to an instance of OwnerA
        // first we create an instance of OwnerA
        def ownerA = new OwnerA(name: 'Owner A')

        // then we give it ownership of all the instances of Owned that we created
        ownerA.addToOwned(owneda)
        ownerA.addToOwned(ownedb)
        ownerA.addToOwned(ownedc)

        // We also need to let the owned objects know who their owner is because this property cannot be null. But their
        // ownerb can be null since I set it to nullable true.
        owneda.ownera = ownerA
        ownedb.ownera = ownerA
        ownedc.ownera = ownerA

        // now we save the owner instance
        ownerA.save(flush: true)

        // now we see how many instances of both Owners and Owned are in our db
        println "Trial 1"
        println "The number of Owner As in existence are: " + OwnerA.count()
        println "The number of Owned in existence are: " + Owned.count()

        // Now we delete the owner instance
        ownerA.delete(flush: true)

        // now we see how many instances of both Owners and Owned are in our db after the deletion
        println "*****"
        println "After deletion of the OwnerA instance..."
        println "The number of Owner As in existence are: " + OwnerA.count()
        println "The number of Owned in existence are: " + Owned.count()

    }

    def caseOfMultipleOwners () {
        // creating a few instances of the owned domain class
        def owneda = new Owned(name: 'Owned A')
        def ownedb = new Owned(name: 'Owned B')
        def ownedc = new Owned(name: 'Owned C')

        // now we make these instances belong to an instance of OwnerA and an instance of OwnerB
        // first we create an instance of OwnerA
        def ownerA = new OwnerA(name: 'Owner A')

        // We also do the same with an instance of OwnerB
        def ownerB = new OwnerB(name: 'Owner B')

        // then we give them the ownership of all the instances of Owned that we created
        ownerA.addToOwned(owneda)
        ownerA.addToOwned(ownedb)
        ownerA.addToOwned(ownedc)

        ownerB.addToOwned(owneda)
        ownerB.addToOwned(ownedb)
        ownerB.addToOwned(ownedc)

        // We also need to let the owned objects know who their owners are because this property cannot be null. But their
        // ownerb can be null since I set it to nullable true.
        owneda.ownera = ownerA
        ownedb.ownera = ownerA
        ownedc.ownera = ownerA

        owneda.ownerb = ownerB
        ownedb.ownerb = ownerB
        ownedc.ownerb = ownerB

        // now we save the owner instances
        ownerA.save(failOnError: true)
        ownerB.save(failOnError: true)

        // now we see how many instances of both Owners and Owned are in our db
        println "Trial 1"
        println "The number of Owner As in existence are: " + OwnerA.count()
        println "The number of Owner Bs in existence are: " + OwnerB.count()
        println "The number of Owned in existence are: " + Owned.count()

        // Now we delete the Owner A instance
        ownerA.delete(failOnError: true, flush: true)

        // now we see how many instances of both Owners and Owned are in our db after the deletion
        println "*****"
        println "After deletion of the OwnerA instance..."
        println "The number of Owner As in existence are: " + OwnerA.count()
        println "The number of Owner Bs in existence are: " + OwnerB.count()
        println "The number of Owned in existence are: " + Owned.count()
    }
}
