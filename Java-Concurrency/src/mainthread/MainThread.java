package mainthread;

public class MainThread {
	
	public static void main(String[] args) {
		
		System.out.println("Thread Name "+Thread.currentThread().getName());
		System.out.println("Thread Id "+Thread.currentThread().getId());
		System.out.println("Thread Priority "+Thread.currentThread().getPriority());
		System.out.println("Thread State "+Thread.currentThread().getState());
		System.out.println("Thread Group "+Thread.currentThread().getThreadGroup().getName());
	}

}
