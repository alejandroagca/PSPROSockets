package com.AlejandroAgca;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServidorHilo extends Thread{
	
	Socket socket = null;
	int id = 0;
	String mensaje = "Bienvenido/a a mi canal";
	public ServidorHilo(Socket socket, int id) {
		this.socket = socket;
		this.id = id;
	}
	
	@Override
	public void run() {
		BufferedOutputStream bo;
		PrintWriter pw = null;
		BufferedInputStream is;
		BufferedReader br = null;
		
		try {
			bo = new BufferedOutputStream(socket.getOutputStream());
			pw = new PrintWriter(bo, true);
			pw.print(id + ":" + mensaje);
			
			//y espera una respuesta en forma de string desde el cliente
			
			//br = new BufferedReader(new InputStreamReader(System.in));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (pw != null) {
			pw.flush(); //nunca deberia hacer falta esto
			pw.close();
		}
	}
}
