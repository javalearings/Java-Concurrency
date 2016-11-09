package jointhread.example;

public class JoinThreads implements Runnable{

	@Override
	public void run() {
		
		System.out.println("["+Thread.currentThread().getName()+"] : Running");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		Thread threads[]=new Thread[5];
		System.out.println("["+Thread.currentThread().getName()+"] : Running");
		for(int i=0;i<threads.length;i++)
		{
			threads[i]=new Thread(new JoinThreads(),"Thread-"+i);
			threads[i].start();
		}
		for(int i=0;i<threads.length;i++)
		{
			
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
		}
		
		System.out.println("End of MAin Thread");
	}

}
