package overridestart;

public class ThreadOverriddingStart extends Thread {
	
	public ThreadOverriddingStart(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		System.out.println("["+Thread.currentThread().getName()+"] Executing Thread");
	}
	@Override
	public synchronized void start() {
		super.start();
		System.out.println("In Start");
		run();
	}
	public static void main(String[] args) {
		
		ThreadOverriddingStart thread=new ThreadOverriddingStart("myThread");
		thread.start();
	}
}
