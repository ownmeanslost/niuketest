import java.util.concurrent.atomic.AtomicReference;

/**
 * @ClassName: CADtEST
 * @Author: shaofan.li
 * @Description:自旋锁
 * 1.利用automic compareAndSet
 * 2.原子引用类
 * 3.自旋锁
 * 思路：new 一个线程，
 * @Date: 2020/2/23 15:41
 */
public class CADtEST {

    public  AtomicReference<Thread> atomicReference = new AtomicReference<Thread>();

    public void lock(){
        Thread thread = Thread.currentThread();
        while (!atomicReference.compareAndSet(null, thread)){

        }
    }

    public void unLock(){
        Thread thread = Thread.currentThread();
        while (!atomicReference.compareAndSet(thread, null)){

        }
    }

    public static void main(String[] args) {

    }


}


