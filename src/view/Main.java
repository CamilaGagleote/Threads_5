package view;
import controller.ThreadPing;
public class Main {

	public static void main(String[] args) {
		ThreadPing t1 = new ThreadPing("google");
		ThreadPing t2 = new ThreadPing("terra");
		ThreadPing t3 = new ThreadPing("uol");
		
		t1.start();
		t2.start();
		t3.start();

	}

}
