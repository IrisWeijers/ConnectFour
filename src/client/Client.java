package client;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import ConnectFour.AIPlayer;
import ConnectFour.NaiveStrategy;
import ConnectFour.Player;
import ConnectFour.SmartStrategy;
import exceptions.InvalidInputException;
import exceptions.UserAlreadyConnectedException;
import ConnectFour.Protocol;
import ConnectFour.LocationState;
import ConnectFour.HumanNetworkPlayer;




/**
 * Client class for a simple client-server application
 * @author  Theo Ruys
 * @version 2005.02.21
 */

public class Client {

	public static final String HELP = "HELP";
	public static final String GIVEHELP = 
			"List of commands:\n" + "DISCONNECT: disconnect from server and exit\n"
					+ "PLAYERS ALL: get list of players that are connected to server\n"
					+ "GAME READY: notify server you are ready to play a game\n"
					+ "GAME UNREADY: notify server that you are not ready anymore to play a game\n";

	private String name;
	private int port;
	private InetAddress ipAddress;
	private Socket sock;
	private BufferedReader reader;
	private PrintWriter writer;
	private BufferedReader terminalReader;
	private ServerInputHandler serverInputHandler;
	private Player player;
	private boolean hasTurn;
	private boolean running;

	public Client() {
		terminalReader = new BufferedReader(new InputStreamReader(System.in));
		hasTurn = false;
	}

	public static void main(String[] args) {
		Client client = new Client();
		client.reader = null;
		client.writer = null;
		boolean infoReady = false;
		while (!infoReady) {
			try {
				client.getConnectionInfo();
				client.getPlayerInfo();
				client.sock = new Socket(client.ipAddress, client.port);
				client.reader = 
						new BufferedReader(new InputStreamReader(client.sock.getInputStream()));
				client.writer = 
						new PrintWriter(new OutputStreamWriter(client.sock.getOutputStream()));
				client.connect();
				if (!client.reader.readLine().startsWith(Protocol.CONFIRM)) {
					System.out.println(client.reader.readLine());
					throw new UserAlreadyConnectedException();
				} else {
					System.out.println("For help, type " + HELP);
					infoReady = true;
				}

			} catch (IOException | NumberFormatException e) {
				System.out.println("An IO-Exception/NumberFormatException Occured, "
						+ "please enter information again. " 
						+ "Possible causes:\n"
						+ "- incorrect ip address\n" + "- incorrect port number\n");
				e.printStackTrace();
			} catch (UserAlreadyConnectedException e) {
				System.out.println(e.getMessage() + ". Please choose a different username");
				e.printStackTrace();
			} catch (InvalidInputException e) {
				System.out.println(e.getMessage());
			}
		}
		try {
			client.serverInputHandler = new ServerInputHandler(client.reader, client);
			client.serverInputHandler.start();
			client.handleTerminalInput();
			client.disconnect();
		} catch (IOException e) {
			System.out.println("IO exception in main client");
		}

	}

	public void getConnectionInfo() throws IOException, NumberFormatException {
		System.out.println("What is your name?");
		String[] nameparts = terminalReader.readLine().split(" ");
		name = "";
		for (int i = 0; i < nameparts.length; i++) {
			name = name + nameparts[i];
		}
		System.out.println("To what ip address do you wish to connect?");
		ipAddress = InetAddress.getByName(terminalReader.readLine());
		System.out.println("To what port do you wish to connect?");
		port = Integer.parseInt(terminalReader.readLine());
	}

	public void getPlayerInfo() throws IOException, InvalidInputException {
		System.out.println("Do you wish to play with an AI (1) or by yourself (2)?");
		String playChoice = terminalReader.readLine();
		if (playChoice.equals("2")) {
			player = new HumanNetworkPlayer(LocationState.YELLOW, name, terminalReader);
		} else if (playChoice.equals("1")) {
			System.out.println(
					"Do you wish to play with a fast naive AI (1) or slow smart AI (2)?");
			playChoice = terminalReader.readLine();
			if (playChoice.equals("1")) {
				player = new AIPlayer(LocationState.YELLOW, new NaiveStrategy());
			} else if (playChoice.equals("2")) {
				player = new AIPlayer(LocationState.YELLOW, new SmartStrategy());
			} else {
				throw new InvalidInputException(
						"Invalid input, please provide a 1 or a 2 as answer");
			}
		} else {
			throw new InvalidInputException("Invalid input, please provide a 1 or a 2 as answer");
		}
	}

	public void handleTerminalInput() throws IOException {
		running = true;
		while (running) {
			while (!hasTurn) {
				if (terminalReader.ready()) {
					String input = terminalReader.readLine();
					String[] parsedInput = input.split(" ");
					if (parsedInput.length >= 1 && parsedInput[0].equals(Protocol.DISCONNECT)) {
						writeToServer(input);
						running = false;
						disconnect();
					} else if (parsedInput.length >= 1 && parsedInput[0].equals(HELP)) {
						System.out.println(GIVEHELP);
					} else {
						writeToServer(input);
					}
				}
			}
		}
	}

	public void disconnect() throws IOException {
		serverInputHandler.stopRunning();
		writer.close();
		terminalReader.close();
		reader.close();
	}

	public void connect() {
		writeToServer(Protocol.CONNECT + " " + name);
	}

	public void writeToServer(String msg) {
		writer.println(msg);
		writer.flush();
	}

	public Player getPlayer() {
		return player;
	}

	public String getName() {
		return name;
	}

	public boolean isHasTurn() {
		return hasTurn;
	}

	public void setHasTurn(boolean hasTurn) {
		this.hasTurn = hasTurn;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}
}


