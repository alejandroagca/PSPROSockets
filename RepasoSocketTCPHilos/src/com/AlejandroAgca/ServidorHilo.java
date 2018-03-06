package com.AlejandroAgca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class ServidorHilo extends Thread {
	
	Socket atencion;
	public ServidorHilo(Socket atencion) {
		this.atencion = atencion;
	}
	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(atencion.getInputStream(), "utf-8"));
			String mensaje = br.readLine();
			System.out.println(mensaje);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
