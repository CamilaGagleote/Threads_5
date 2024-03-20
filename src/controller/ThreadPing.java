package controller;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ThreadPing extends Thread {
	
	private BufferedReader read;
	private Runtime run = Runtime.getRuntime();
	private Process process;
	private String sis;

	public ThreadPing(String site) {
		sis = site;
		
	}
	public void run() {
		ping(sis);
	}
	private void ping(String site) {
		String command = "ping -4 -n 10 www." + site + ".com.br";
		try {
			process = run.exec(command);

			read = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = read.readLine();

			while (line != null) {
				System.out.println(line);

				if (line.contains("dia")) {
					String[] p = line.trim().split(" ");
					System.out.println("Site: " + site + " possui média de ping igual a " + p[p.length - 1]);
				}

				line = read.readLine();
			}

			read.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

				

	}

}
