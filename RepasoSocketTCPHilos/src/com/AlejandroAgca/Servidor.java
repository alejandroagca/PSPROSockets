package com.AlejandroAgca;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	static final int PUERTO = 8888;
	
	public Servidor() {
		ServerSocket socketServidor;
		try {
			socketServidor = new ServerSocket(PUERTO);
			while (true) {
				Socket atencion = socketServidor.accept();
				new ServidorHilo(atencion).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Servidor();
	}

}
