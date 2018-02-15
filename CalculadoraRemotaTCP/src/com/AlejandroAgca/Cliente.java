package com.AlejandroAgca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	static final String HOST = "localhost";
	static final int PUERTO = 8888;

	public Cliente() {
		try {
			Socket skCLI = new Socket(HOST, PUERTO);
			BufferedReader br = new BufferedReader(new InputStreamReader(skCLI.getInputStream(), "utf-8"));
			BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(skCLI.getOutputStream(), "utf-8"), true);
			String opcion;

			System.out.println(br.readLine()); 
			System.out.println("1. Raiz cuadrada");
			System.out.println("2. Potencia");
			System.out.println("3. Siguiente numero primo");
			System.out.println("Q. Salir");
			System.out.print("Selecciona una opción: ");
			
			opcion = teclado.readLine().toString();
			opcion = opcion.toUpperCase();
			while(!opcion.equals("1")&& !opcion.equals("2")&& !opcion.equals("3") && !opcion.equals("Q")) 
			{
				System.out.println("Has seleccionado una opción no válida");
				System.out.print("Selecciona otra opción: ");
				opcion = teclado.readLine();
				opcion = opcion.toUpperCase();
			}
			
			pw.println(opcion);
			System.out.print(br.readLine());
			if(!opcion.equals("Q")) {
				opcion = teclado.readLine();
				pw.println(opcion);
				System.out.println(br.readLine());
			}
			
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
