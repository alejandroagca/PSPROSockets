package com.AlejandroAgca;

import java.io.IOException;
import java.net.UnknownHostException;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class Cli_SSL {

	static int PUERTO = 5555;
	static final String DESTINO = "localhost"; //puerto destino del servidor al que conecta
	
	public Cli_SSL(String mensaje) throws UnknownHostException, IOException {
		System.out.println("Obteniendo factoria del socket del cliente...");
		SSLSocketFactory socketCliFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		
		System.out.println("Creando el socket del cliente...");
		SSLSocket socketCli = (SSLSocket) socketCliFactory.createSocket(DESTINO, PUERTO);
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		new Cli_SSL("Alejandro");
	}

}
