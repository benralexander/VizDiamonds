package cow

class SunburstHandlerTagLib {

    RingManagerService ringManagerService

    def makeSunburst = { attrs, body ->
        cow.RingNode root =  ringManagerService.createStub()
        out <<   ringManagerService.writeRingTree(root)
        out <<   "\n"
        out <<     ringManagerService.defineColors(root)
    }



}
