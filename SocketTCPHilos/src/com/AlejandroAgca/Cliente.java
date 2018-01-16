package com.AlejandroAgca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.xml.stream.util.EventReaderDelegate;

public class Cliente {

	static final String HOST = "192.168.3.57";
	static final int PUERTO = 5000;
	Scanner entrada;
	
	private String LeerMensaje() {
		System.out.println("Introduce el mensaje para enviar: ");
		String mensaje = entrada.nextLine();
		return mensaje;
	}
	
	
	
	public Cliente() {
		try {
			Socket skCLI = new Socket(HOST, PUERTO);
			InputStreamReader is = new InputStreamReader(skCLI.getInputStream(), "utf-8");
			BufferedReader br = new BufferedReader(is);
			System.out.println(br.readLine()); //Recibimos el saludo del servidor
			
			//enviar mensaje pedido por consola al servidor
			
			skCLI.close();
			
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
