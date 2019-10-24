package leetcode;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintInOrder {
	    
	    boolean isFirstDone, isSecondDone; 
	    Lock lock;
	    
	    public PrintInOrder() {
	        isFirstDone = isSecondDone = false; 
	        lock = new ReentrantLock(); 
	    }

	    public void first(Runnable printFirst) throws InterruptedException {
	        synchronized(lock) {
	            printFirst.run();
	            isFirstDone = true; 
	            lock.notifyAll(); 
	        }
	    }

	    public void second(Runnable printSecond) throws InterruptedException {
	        synchronized(lock) {
	            while(!isFirstDone) {
	                lock.wait(); 
	            } 
	            printSecond.run();
	            isSecondDone = true; 
	            lock.notifyAll(); 
	        }
	    }

	    public void third(Runnable printThird) throws InterruptedException {
	        synchronized(lock) {
	            while(!isFirstDone || !isSecondDone) {
	                lock.wait(); 
	            } 
	            printThird.run();
	        }
	    }
	}
