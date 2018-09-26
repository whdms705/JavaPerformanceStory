package ch08;

import java.util.concurrent.atomic.AtomicBoolean;

public class MyLock {

    // case 1 - 동기화 선언 없는 코드
    /*private boolean loecked  = false;

    public boolean lock(){
        if(!loecked){
            loecked = true;
            return true;
        }
        return false;
    }*/

    // case 2 - synchronized 선언한 코드
    /*private boolean loecked  = false;

    public synchronized boolean lock(){
        if(!loecked){
            loecked = true;
            return true;
        }
        return false;
    }*/

    // case 3 Atomic 자료형 사용 코드
    private AtomicBoolean loecked  = new AtomicBoolean(false);

    public synchronized boolean lock(){
        return loecked.compareAndSet(false,true);// false 이면 true로 수정
    }
}
