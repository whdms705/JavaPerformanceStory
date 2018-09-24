package ch08;

public class Contribution {
    //private int amount = 0;

    //case 3
    private static int amount = 0;
    public void donate(){
        amount++;
    }

    //case 2
    /*public synchronized void donate(){
        amount++;
    }*/
    public int getTotal(){
        return amount;
    }

}
