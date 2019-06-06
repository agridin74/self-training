import java.util.concurrent.locks.*;
class LockDemo {
	public static void main(String args[]){
		ReentrantLock lock = new ReentrantLock();
		new LockThread(lock, "A");
		new LockThread(lock, "B");
	}
}
class Shared {
	static int count =0;
}

class LockThread implements Runnable {
	String name;
	ReentrantLock lock;

	LockThread(ReentrantLock lk, String n){
		lock = lk;
		name = n;
		new Thread(this).start();
	}

	public void run(){
		System.out.println("Start ... "+name);
		try{
			System.out.println("Thread " + name + " wait lock");
			lock.lock();
			System.out.println("Thread " + name + " lock");
			Shared.count++;
			System.out.println("Thread " + name + " : " + Shared.count);
			System.out.println("Thread " + name + " wait");
			Thread.sleep(1000);
		}catch (InterruptedException e){
			System.out.println(e);
		}finally{
			System.out.println("Thread " + name + " unlock count" );
		}
	}
}
