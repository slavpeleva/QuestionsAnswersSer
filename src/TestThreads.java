import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicBoolean;

public class TestThreads {
	private final AtomicBoolean stop = new AtomicBoolean();
	public void stop() {
		stop.set(true);
	}

	public String requestInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input;
		do {
			System.out.println("Your answer is?");
			try {
				// wait until we have data to complete a readLine()
				while (!br.ready() && !stop.get()) {
					Thread.sleep(200);					
				}
				input = br.readLine();
			} catch (InterruptedException e) {		
				System.out.println("ConsoleInputReadTask() cancelled");
				Thread.interrupted();
				return null;
			}
		} while ("".equals(input)&&!input.isEmpty());
//		System.out.println("Thank You for providing input!");
		return input;
	}

//	public static void main(String[] args) {
//		final Thread scannerThread = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					String string = new TestThreads().requestInput();
//					System.out.println("Input: " + string);
//				} catch (IOException e) {
//					throw new RuntimeException(e);
//				}
//			}
//		});
//		scannerThread.start();
//
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					Thread.sleep(5000);
//				} catch (InterruptedException e) {
//					throw new RuntimeException(e);
//				}
//				scannerThread.interrupt();
//			}
//		}).start();
//	}
}
