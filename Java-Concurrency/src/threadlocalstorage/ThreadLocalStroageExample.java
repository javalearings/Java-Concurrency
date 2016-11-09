package threadlocalstorage;

public class ThreadLocalStroageExample implements Runnable {
	private static ThreadLocal<Integer> threadlocal=new ThreadLocal<Integer>();
	private int value;
	
	public ThreadLocalStroageExample(int value) {
		this.value=value;
	}
	
	@Override
	public void run() {
			System.out.println("["+Thread.currentThread().getName()+"] Setting value = "+value);
			threadlocal.set(value);
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("["+Thread.currentThread().getName()+"] Getting value = "+threadlocal.get());
			
	}
	public static void main(String[] args) throws InterruptedException {
		Thread threads[]=new Thread[5];
		for(int i=0; i<threads.length;i++)
		{
			threads[i]=new Thread(new ThreadLocalStroageExample(i),"Thread-"+i);
			threads[i].start();
		}
		for(int i=0; i<threads.length;i++)
		{
			threads[i].join();
		}	
	}
	
}
