package com.AlejandroAgca;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.UnknownHostException;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class Cli_SSL {

	static int PUERTO = 5555;
	static final String DESTINO = "localhost"; //puerto destino del servidor al que conecta
	
	private void mostrarCifrados(SSLSocket socket) {
		String [] protocolos = socket.getEnabledProtocols();
		System.out.print("Protocolos habilitados: ");
		for (int i = 0; i < protocolos.length; i++) {
			System.out.print(protocolos[i] + ", ");
		}
		
		String [] protocolosSoportados = socket.getSupportedProtocols();
		System.out.print("\nProtocolos disponibles: ");
		for (int i = 0; i < protocolosSoportados.length; i++) {
			System.out.print(protocolosSoportados[i] + ", ");
		}
		
		String [] protocolosDeseados = new String[1];
		protocolosDeseados[0] = "TLSv1.2";
		socket.setEnabledProtocols(protocolosDeseados);
		
		protocolos = socket.getEnabledProtocols();
		System.out.print("\nProtocolos activos: ");
		for (int i = 0; i < protocolos.length; i++) {
			System.out.print(protocolos[i] + ", ");
		}
	}
	
	public Cli_SSL(String mensaje) throws UnknownHostException, IOException {
		System.out.println("Obteniendo factoria del socket del cliente...");
		SSLSocketFactory socketCliFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		
		System.out.println("Creando el socket del cliente...");
		SSLSocket socketCli = (SSLSocket) socketCliFactory.createSocket(DESTINO, PUERTO);
		
		mostrarCifrados(socketCli); //Mostramos los cifrados que actualmente tenemos disponibles y habilitados
		
		PrintWriter pw = new PrintWriter(new BufferedOutputStream(socketCli.getOutputStream()));
		pw.println(mensaje);
		pw.flush(); //por seguridad
		System.out.println("\nMensaje enviado");
		
		//Esperamos la respuesta cifrada con hash desde el servidor y la mostramos por consola
		BufferedReader br = new BufferedReader(new InputStreamReader(socketCli.getInputStream(), "utf8"));
		System.out.println("Mensaje cifrado recibido: " + br.readLine());
		
		System.out.println("Cerrando la conexión...");
		pw.close();
		br.close();
		socketCli.close();
		System.out.println("Finalizando...");
		
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.setProperty("javax.net.ssl.keyStore", "./cer/ClienteSRV");
		System.setProperty("javax.net.ssl.keyStorePassword", "654321");
		System.setProperty("javax.net.ssl.trustStore", "./cer/ClienteSRV");
		System.setProperty("javax.net.ssl.trustStorePassword", "654321");
		
		new Cli_SSL("Alejandro");
	}

}
