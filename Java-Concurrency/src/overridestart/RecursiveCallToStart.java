package overridestart;

public class RecursiveCallToStart extends Thread {

	public RecursiveCallToStart(String name) {
		super(name);
	}
	@Override
	public void run() {
		System.out.println("["+Thread.currentThread().getName()+"] Executing Thread");
	}
	@Override
	public synchronized void start() {
		super.start();
		start();
	}
	public static void main(String[] args) {
		
		RecursiveCallToStart thread=new RecursiveCallToStart("myThread");
		thread.start();
	}
}
