package overridestart;

public class ThreadOverriddingStartWithCallToSuperStart extends Thread {

	public ThreadOverriddingStartWithCallToSuperStart(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		System.out.println("["+Thread.currentThread().getName()+"] Executing Thread");
	}
	@Override
	public synchronized void start() {
		super.start();
		
	}
	public static void main(String[] args) {
		
		ThreadOverriddingStartWithCallToSuperStart thread=new ThreadOverriddingStartWithCallToSuperStart("myThread");
		thread.start();
	}
}
