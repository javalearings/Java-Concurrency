package overridestart;

public class ThreadOverriddingStartWithCallToRun extends Thread{

	public ThreadOverriddingStartWithCallToRun(String name) {
		
		super(name);
	}
	@Override
	public void run() {
		System.out.println("["+Thread.currentThread().getName()+"] Executing Thread");
	}
	@Override
	public synchronized void start() {
		run();
		
	}
	public static void main(String[] args) {
		
		ThreadOverriddingStartWithCallToRun thread=new ThreadOverriddingStartWithCallToRun("myThread");
		thread.start();
	}
}
