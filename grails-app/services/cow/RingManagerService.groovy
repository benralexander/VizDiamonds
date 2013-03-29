package cow

class RingManagerService {

    String writeRingTree( cow.RingNode ringNode ) {
        StringBuilder stringBuilder = new StringBuilder("var \$data = [")
        if (ringNode)
            stringBuilder << ringNode.toString()
        stringBuilder << "]"
        stringBuilder.toString()
    }


    cow.RingNode createStub () {
        cow.RingNode.createStubRing ()
    }

    String defineColors ( cow.RingNode ringNode ) {
        StringBuilder stringBuilder = new StringBuilder("")
        int numberOfColors = ringNode.maximumTreeHeight()
        List <String>  everyParent = ringNode.listOfEverybodyWhoIsAParent()
        List <String>  everyUniqueParent =  everyParent.unique().sort()
            stringBuilder << ringNode.deriveColors(960,700,everyUniqueParent,numberOfColors)
        stringBuilder.toString()
    }

}
