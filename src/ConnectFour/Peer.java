package ConnectFour;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Peer for a simple client-server application
 * 
 * @author Theo Ruys
 * @version 2005.02.21
 */
public class Peer implements Runnable {
	public static final String EXIT = "exit";

	protected String name;
	protected Socket sock;
	protected BufferedReader in;
	protected BufferedWriter out;

	/*
	 * @ requires (nameArg != null) && (sockArg != null);
	 */
	/**
	 * Constructor. creates a peer object based in the given parameters.
	 * 
	 * @param nameArg
	 *            name of the Peer-proces
	 * @param sockArg
	 *            Socket of the Peer-proces
	 */
	public Peer(String nameArg, Socket sockArg) throws IOException {
		name = nameArg;
		sock = sockArg;
		in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		out = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
	}

	/**
	 * Reads strings of the stream of the socket-connection and writes the
	 * characters to the default output.
	 */
	public void run() {
		while (!sock.isClosed()) {
			try {
				System.out.println(in.readLine());
			} catch (IOException e) {
				this.shutDown();
				e.printStackTrace();
			}
		}
	}

	/**
	 * Reads a string from the console and sends this string over the
	 * socket-connection to the Peer process. On Peer.EXIT the method ends
	 */
	public void handleTerminalInput() {
		while (!sock.isClosed()) {
			String send = readString("Your message?");
			if (send.equals(EXIT)) {
				this.shutDown();
			} else {
				try {
					out.write(send);
					out.newLine();
					out.flush();
				} catch (IOException e) {
					this.shutDown();
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Closes the connection, the sockets will be terminated
	 */
	public void shutDown() {
		try {
			in.close();	
			out.close();
			sock.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/** returns name of the peer object */
	public String getName() {
		return name;
	}

	/** read a line from the default input */
	static public String readString(String test) {
		System.out.print(test);
		String antw = null;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			antw = in.readLine();
		} catch (IOException e) {
		}

		return (antw == null) ? "" : antw;
	}
}
