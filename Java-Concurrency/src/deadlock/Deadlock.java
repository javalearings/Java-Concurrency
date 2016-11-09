package deadlock;

import java.util.Random;

public class Deadlock implements Runnable {
	private static final Object resource1=new Object();
	private static final Object resource2=new Object();
	private final Random random = new Random(System.currentTimeMillis());
	@Override
	public void run() {
		
		for(int i=0;i<1000;i++)
		{
			Boolean b=random.nextBoolean();
			if(b)
			{
					System.out.println("["+Thread.currentThread().getName()+"] Trying to accqure lock on resource 1");
					synchronized (resource1) {
					
						System.out.println("["+Thread.currentThread().getName()+"]  accqured lock on resource 1");
						
						System.out.println("["+Thread.currentThread().getName()+"] Trying to accqure lock on resource 2");
						synchronized (resource2) {
						
							System.out.println("["+Thread.currentThread().getName()+"]  accqured lock on resource 2");
						}
					}
						
			}
			else
			{
				System.out.println("["+Thread.currentThread().getName()+"] Trying to accqure lock on resource 2");
				synchronized (resource2) {
				
					System.out.println("["+Thread.currentThread().getName()+"]  accqured lock on resource 2");
					
					System.out.println("["+Thread.currentThread().getName()+"] Trying to accqure lock on resource 1");
					synchronized (resource1) {
					
						System.out.println("["+Thread.currentThread().getName()+"]  accqured lock on resource 1");
					}
				}
			}
		}

	}
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread thread1=new Thread(new Deadlock(),"thread-1");
		Thread thread2=new Thread(new Deadlock(),"thread-2");
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
		
	}

}
