package cow

/**
 * Created with IntelliJ IDEA.
 * User: balexand
 * Date: 3/22/13
 * Time: 7:26 AM
 * To change this template use File | Settings | File Templates.
 */
class RingNode {
    String name = ""
    int size =  0
    List <RingNode> children = []


    public RingNode( String name, int size = 0  ){
        this.name = name
        this.size = size
    }

    public RingNode( String name, List <RingNode> children  ){
        this.name = name
        this.size = 0
        this.children = children
    }



    public List <String> listOfEverybodyWhoIsAParent ( ) {
        List <String>  everyParent = []
        getParentsBelow ( this, everyParent )
        everyParent
    }

    private void getParentsBelow (RingNode root, List <String>  everyParent )   {
        if ((root.children == null) || (root.children.size() == 0)) {
            return
        } else {
            everyParent << root.name
            for (RingNode oneKid in root.children){
                getParentsBelow (oneKid, everyParent)
             }
        }

    }




    public int maximumTreeHeight ( ) {
        int currentTreeLevel = 0
        int highestTreeLevelSoFar = 0
        return goDownOneLevel ( this,  currentTreeLevel,  highestTreeLevelSoFar)
    }


    private int goDownOneLevel (RingNode root, int currentTreeLevel, int highestTreeLevelSoFar)   {
        if ((root.children == null) || (root.children.size() == 0)) {
            return  highestTreeLevelSoFar
        } else {
            int digDeeper = currentTreeLevel+1
            int deepestLevel = highestTreeLevelSoFar
            int deepestLevelBelow
            if (digDeeper > highestTreeLevelSoFar)
                deepestLevel = digDeeper
            for (RingNode oneKid in root.children){
                deepestLevelBelow = goDownOneLevel (oneKid, digDeeper, deepestLevel)
                deepestLevel = ((deepestLevelBelow > deepestLevel) ?  deepestLevelBelow :  deepestLevel)
            }
            return deepestLevel
        }

    }



    static  RingNode createStubRing () {
        RingNode ringNode1 = new RingNode ("B",[ new RingNode ("A",  1500),
                new RingNode ("ABC",  500),
                new RingNode ("C",  500) ] )
        RingNode ringNode2 = new RingNode ("A",[ new RingNode ("ABC",  1500),
                ringNode1,
                new RingNode ("C",  50) ] )
        return  new RingNode ("AA",[ new RingNode ("FLINA",  1500),
                                    ringNode1,
                                    new RingNode ("FLINC",  1500),
                                    ringNode2] )
    }




    public String deriveColors(int width, int height, List <String> namesThatGetColors, int maximumNumberOfColors) {
        StringBuilder stringBuilder = new StringBuilder()
        stringBuilder << """  var width = ${width},
                height = ${height},
                radius = Math.min(width, height) / 2,
                color = d3.scale.category10().domain([""".toString()
        int numberOfLoops = 0
        for (String name in namesThatGetColors){
            stringBuilder << "\"${name}\""
            ++numberOfLoops
            if ((numberOfLoops < maximumNumberOfColors)&&(numberOfLoops<  namesThatGetColors.size())){
                stringBuilder << ",\n"
            } else  {
                stringBuilder << "\n"
                break
            }
        }
        stringBuilder << "   ]);"
//        var width = 960,
//                height = 700,
//                radius = Math.min(width, height) / 2,
//                color = d3.scale.category10().domain([
//                        "A",
//                        "FLINA",
//                        "C",
//                        "B",
//                        "FLINC",
//                        "ABC",
//                        "AA"
//                ]);
        stringBuilder.toString()
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder()
        // start things out
        stringBuilder << "{"
        // start things out, and write the name
        stringBuilder <<  "\"name\":"
        if (name?.size()>0)
            stringBuilder <<  "\"${name}\""
        // size or children – not both
        if ( children.size()>0 ) {
            stringBuilder <<  ", \"children\": [\n"
            int totalNumberOfKids =  children.size()
            int workingOnKidNumber = 0
            for (RingNode oneKid in children) {
                stringBuilder << oneKid.toString()
                workingOnKidNumber++
                if (workingOnKidNumber < totalNumberOfKids)
                    stringBuilder <<  ","
                stringBuilder << "\n"
            }
            stringBuilder << "]"
        }  else if (size  > 0)  {
            stringBuilder <<  ", "
            stringBuilder <<  "\"size\":"
            stringBuilder << size
        }
        stringBuilder << "}"
        return stringBuilder.toString()
    }
}
