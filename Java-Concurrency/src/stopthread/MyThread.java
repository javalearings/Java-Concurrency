package stopthread;

public class MyThread extends Thread {

	public MyThread(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		super.run();
		System.out.println("["+Thread.currentThread().getName()+"] Executing Thread");
	}
	public static void main(String[] args) {
		System.out.println("["+Thread.currentThread().getName()+"] Executing Thread");
		MyThread myThread=new MyThread("myThread");
		System.out.println("["+Thread.currentThread().getName()+"] Executing Thread");
		myThread.start();
		System.out.println("["+Thread.currentThread().getName()+"] Executing Thread");
		myThread.stop();
	}
}
