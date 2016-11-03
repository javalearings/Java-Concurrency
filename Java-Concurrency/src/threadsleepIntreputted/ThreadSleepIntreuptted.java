package threadsleepIntreputted;

public class ThreadSleepIntreuptted implements Runnable {

	@Override
	public void run() {
		
		try{
			System.out.println("["+Thread.currentThread().getName()+"]  Thread is Executing");
			Thread.sleep(Long.MAX_VALUE);
			
		}
		catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("["+Thread.currentThread().getName()+"]  Caught InterruptedException");
		}
		while (!Thread.interrupted()) {
			
		}
		
		System.out.println("["+Thread.currentThread().getName()+"]  Thread Again Intrerupted");

	}
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("["+Thread.currentThread().getName()+"]  Thread is Executing");
		Thread myThread=new Thread(new ThreadSleepIntreuptted(),"myThread");
		myThread.start();
		
		System.out.println("["+Thread.currentThread().getName()+"]  Thread is Sleeping");
		Thread.sleep(5000);
		
		System.out.println("["+Thread.currentThread().getName()+"]  Thread is Intreing myThread");
		myThread.interrupt();
		
		System.out.println("["+Thread.currentThread().getName()+"]  Thread is Sleeping");
		Thread.sleep(5000);
		
		
		System.out.println("["+Thread.currentThread().getName()+"]  Thread is Intreing myThread");
		myThread.interrupt();
	}

}
