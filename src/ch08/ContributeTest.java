package ch08;

public class ContributeTest {
    public static void main(String[] args) {
        Contributor[] crs = new Contributor[10];//10명의 기부자

        //2 case
        //Contribution group = new Contribution();

        //1 case
        for(int loop=0;loop<10;loop++){
            Contribution group = new Contribution();
            crs[loop] = new Contributor(group," Contributor"+loop);
        }



        for(int loop=0;loop<10;loop++){
            crs[loop].start();
        }
    }
}
