package com.AlejandroAgca;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	static final int PUERTO = 8888;
	static final String HOST = "localhost";
	public Cliente() {
		try {
			Socket socketCli = new Socket(HOST, PUERTO);
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socketCli.getOutputStream(), "utf-8"), true);
			pw.println("Mensaje");
			socketCli.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Cliente();
	}

}
