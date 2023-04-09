public class CellFactory {

    public Cell create(int index){
        /*指定生成什么cell， 1 2 3 4 -- P B C K*/
        switch (index){
            case 1:
                return new Plain();
            case 2:
                return new Bush();
            case 3:
                return new Cave();
            case 4:
                return new Koulou();
            case 5:
                return new Inaccessible();
            case 6:
                return new Nexus();

        }
        System.out.println("index out of range!");
        return null;
    }
}
