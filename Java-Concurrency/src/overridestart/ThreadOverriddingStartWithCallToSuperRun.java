package overridestart;

public class ThreadOverriddingStartWithCallToSuperRun extends Thread {

	public ThreadOverriddingStartWithCallToSuperRun(String name) {
		super(name);
	}
	@Override
	public void run() {
		System.out.println("["+Thread.currentThread().getName()+"] Executing Thread");
	}
	@Override
	public synchronized void start() {
		super.run();
		
	}
	public static void main(String[] args) {
		
		ThreadOverriddingStartWithCallToSuperRun thread=new ThreadOverriddingStartWithCallToSuperRun("myThread");
		thread.start();
	}
}
