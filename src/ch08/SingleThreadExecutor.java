package ch08;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SingleThreadExecutor {
    public static void main(String[] args) {
        System.out.println("Main thread starts here...");

        ExecutorService execService = Executors.newSingleThreadExecutor();

        execService.execute(new Task3());
        execService.execute(new Task3());
        execService.execute(new Task3());
        execService.execute(new Task3());

        execService.shutdown();

        System.out.println("Main thread ends here...");
    }
}

class Task3 implements Runnable{
    private static int count = 0;
    private int id;
    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println("<"+id+">TICK TICK "+i);
            try{
                TimeUnit.MICROSECONDS.sleep((long)Math.random()*1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public Task3(){
        this.id = ++count;
    }
}
