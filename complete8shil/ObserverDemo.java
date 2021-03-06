import java.util.*;
class Watcher implements Observer {
	public void update(Observable obj, Object arg) {
		System.out.println("=> update() count: "+
		((Integer)arg).intValue());
	}
}

class BeingWatched extends Observable {
	void counter(int period){
		for(; period >=0; period--){
			setChanged();
			notifyObservers(new Integer(period));
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
				System.out.println(" === break");
			}
		}
	}
}

class ObserverDemo {
	public static void main(String args[]){
		BeingWatched observer = new BeingWatched();
		Watcher observing = new Watcher();
		observer.addObserver(observing);
		observer.counter(10);
	}
}
