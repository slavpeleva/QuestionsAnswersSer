
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;


public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {	
	
		ReadFromFile read = new ReadFromFile();
		final ArrayList<Questions> quest = read.readFromFile();		
		
		
		final Thread scannerThread = new Thread(new Runnable() {
			@Override
			public void run() {				
				for (int i = 0; i < 4; ) {					
					threadTest(quest);
					i++;
				}
			}
		});
		scannerThread.start();

		
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
				scannerThread.interrupt();
			}
		}).start();
		

	}

	private static void threadTest(ArrayList<Questions> quest) {
		Collections.shuffle(quest);
		System.out.println(quest.get(0).getQuestion());
		System.out.println(quest.get(0).getAnswer());
		String string = null;
		try {
			string = new TestThreads().requestInput();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(string!=null && !string.isEmpty()){
			System.out.println("Correct? " + string.equalsIgnoreCase(quest.get(0).getCorrectAnswer()));
		}
	}

}
