package com.AlejandroAgca;

import java.io.IOException;
import java.util.concurrent.SynchronousQueue;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class Srv_SSL {

	static int PUERTO = 5555;
	
	public Srv_SSL() throws IOException {
		System.out.println("Obteniendo factoría del socket para el servidor...");
		SSLServerSocketFactory socketSRVFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
		System.out.println("Creando el socket...");
		SSLServerSocket socketSRV = (SSLServerSocket) socketSRVFactory.createServerSocket(PUERTO);
		while (true) {
			System.out.println("Aceptando conexiones...");
			SSLSocket socketAtencion = (SSLSocket) socketSRV.accept();
			System.out.println("Atendiendo a la conexion nueva con un hilo dedicado");
			new Srv_SSL_Hilo(socketAtencion).start();
		}
	}
	public static void main(String[] args) throws IOException {
		System.setProperty("javax.net.ssl.keyStore", "./cer/AlmacenSRV");
		System.setProperty("javax.net.ssl.keyStorePassword", "123456");
		System.setProperty("javax.net.ssl.trustStore", "./cer/AlmacenSRV");
		System.setProperty("javax.net.ssl.trustStorePassword", "123456");
		
		new Srv_SSL();
	}

}
