package com.AlejandroAgca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServidorHilo extends Thread {
	Socket socket;
	int id;
	String mensaje;
	
	public ServidorHilo(Socket socket, int id) {
		this.socket = socket;
		this.id = id;
		
	}
	
	@Override
	public void run() {
		
		BufferedReader br;
		PrintWriter pw = null;
		
		try {
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			pw.println("Bienvenido Cliente " + id + ", ¿Que desea hacer?");
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			String opcion = br.readLine();
			opcion = opcion.toUpperCase();;
			switch(opcion) {
			case "1":
				pw.println("Introduce el número al que desea hacer la raiz cuadrada: ");
				opcion = br.readLine();
				pw.println("La raiz es: " + CalcularRaiz(Double.parseDouble(opcion)));
				break;
			case "2":
				pw.println("Introduce el número al que desea hacer la potencia: ");
				opcion = br.readLine();
				pw.println("La potencia es: " + CalcularPotencia(Double.parseDouble(opcion)));
				break;
			case "3":
				pw.println("Introduce el número del que desea saber el siguiente numero primo: ");
				opcion = br.readLine();
				pw.println("El siguiente numero primo es: " + SiguientePrimo(Integer.parseInt(opcion)));
				break;
			case "Q":
				pw.println("Conexión finalizada por el cliente");
				break;
			default:
				break;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}
	}
	
	private double CalcularRaiz(double numero) {
		return Math.sqrt(numero);
		
	}
	
	private double CalcularPotencia(double numero) {
		return Math.pow(numero, 2);
		
	}
	
	private int SiguientePrimo(int numero) {
		if(numero < 2) {
			return 2;
		}
		else {
			int candidato = numero;
			boolean primo = false;
			while(!primo) {
				candidato++;
				primo = esPrimo(candidato);
			}
			return candidato;
		}
	}
	
	private boolean esPrimo(int candidato) {
		for (int i = 2; i < candidato; i++) {
			if (candidato%i == 0) {
				return false;
			}
		}
		return true;
	}
}
