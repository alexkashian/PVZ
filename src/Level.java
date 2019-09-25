import java.util.ArrayList;

public class Level {

    private int L;

    public Level(int L){
        this.L = L;
    }

    public int getLevel(){
        return L;
    }

    public void Levelup(){
        L ++;
    }


//    public ArrayList Level1(){
//        //spit out an array of 3 random int [0,4]
//
//        ArrayList randomthree = new ArrayList();
//
//        while (randomthree.size()<4){
//
//            int n = (int)Math.random()*5+1;
//
//            if (randomthree.contains(n)==false){
//                randomthree.add(n);
//            }
//
//        }
//
//        return randomthree;
//    }

}
