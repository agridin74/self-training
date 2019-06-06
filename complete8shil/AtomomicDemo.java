import java.util.concurrent.atomic.*;
class AtomomicDemo{
	public static void main(String args[]){
		new AtomThread("A");
		new AtomThread("B");
		new AtomThread("C");
	}
}

class Shared{
	static AtomicInteger ai = new AtomicInteger(0);
}

class AtomThread implements Runnable{
	String name;
	AtomThread(String n){
		name = n;
		new Thread(this).start();
	}

	public void run(){
		System.out.println("Start thread " + name);
		for(int i=1; i<=3; i++)
			System.out.println("Thread " + name + " : " + Shared.ai.getAndSet(i));
	}
}
