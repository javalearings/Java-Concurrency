package createthreadusingrunnale;

public class RunnableThread implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("["+Thread.currentThread().getName()+"] Executing Thread");
	}

	public static void main(String[] args) {
		Thread myThread=new Thread(new RunnableThread(),"mythread");
		myThread.start();
	}

}
