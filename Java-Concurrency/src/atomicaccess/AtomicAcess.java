package atomicaccess;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AtomicAcess implements Runnable {
	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
	private static HashMap<String,String> configratiommap=new HashMap<String,String>();
	
	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			Map<String, String> currConfig = configratiommap;
			String value1 = currConfig.get("config1");
			String value2 = currConfig.get("config2");
			String value3 = currConfig.get("config3");
			if (!(value1.equals(value2) && value2.equals(value3))) {
			throw new IllegalStateException("Values are not equal.");
			}
			try {
			Thread.sleep(10);
			} catch (InterruptedException e) {
			e.printStackTrace();
			}
		}	
		

	}
	
	public static void readConfigration() {
		HashMap< String, String> setConfigration=new HashMap<String,String>();
		Date now= new Date();
		setConfigration.put("config1", sdf.format(now));
		setConfigration.put("config2", sdf.format(now));
		setConfigration.put("config3", sdf.format(now));
		configratiommap=setConfigration;
	}
	public static void main(String[] args) throws InterruptedException {
		readConfigration();
		Thread configThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					readConfigration();
					try {
					Thread.sleep(10);
					} catch (InterruptedException e) {
					e.printStackTrace();
					}
					}
				
			}
		},"configuration-thread");
		configThread.start();
		Thread[] threads = new Thread[5];
		for (int i = 0; i < threads.length; i++) {
		threads[i] = new Thread(new AtomicAcess(), "thread-" + i);
		threads[i].start();
		}
		for (int i = 0; i < threads.length; i++) {
		threads[i].join();
		}
		configThread.join();
		System.out.println("[" + Thread.currentThread().getName() + "] All threads  - have finished.");
	}
	
}
