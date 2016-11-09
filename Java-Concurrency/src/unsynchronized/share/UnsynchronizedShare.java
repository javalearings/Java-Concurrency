package unsynchronized.share;



public class UnsynchronizedShare implements Runnable {
	private static int value;
	@Override
	public void run() {
		while (value<10) {
			System.out.println("["+Thread.currentThread().getName()+"] value before incremenent "+value);
			value++;
			System.out.println("["+Thread.currentThread().getName()+"] value after incremenent "+value);
		}	
	}
	public static void main(String[] args) {
		Thread threads[]=new Thread[5];
		System.out.println("["+Thread.currentThread().getName()+"] : Running");
		for(int i=0;i<threads.length;i++)
		{
			threads[i]=new Thread(new UnsynchronizedShare(),"Thread-"+i);
			threads[i].start();
		}
		for(int i=0;i<threads.length;i++)
		{
			
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			};
		}
		
		System.out.println("End of MAin Thread");
	}

}
