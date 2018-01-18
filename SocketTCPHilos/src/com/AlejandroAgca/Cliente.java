package com.AlejandroAgca;

import java.awt.event.MouseWheelEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Cliente {

	static final String HOST = "localhost";
	static final int PUERTO = 5000;
	Scanner entrada;
	
	/*private String LeerMensaje() {
		System.out.println("Introduce el mensaje para enviar: ");
		String mensaje = entrada.nextLine();
		return mensaje;
	}*/
	
	
	
	public Cliente() {
		try {
			Socket skCLI = new Socket(HOST, PUERTO);
			BufferedReader br = new BufferedReader(new InputStreamReader(skCLI.getInputStream(), "utf-8"));
			BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(skCLI.getOutputStream(), "utf-8"), true);

			System.out.println(br.readLine()); //Recibimos el saludo del servidor
			
			//enviar mensaje pedido por consola al servidor
			System.out.println("Mensaje para enviar?");
			String mensaje = teclado.readLine();
			System.out.println("Enviando al servidor el mensaje: " + mensaje);
			pw.println(mensaje);
			
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
