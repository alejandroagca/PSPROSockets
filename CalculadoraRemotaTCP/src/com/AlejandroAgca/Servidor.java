package com.AlejandroAgca;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

static final int PUERTO = 8888;
	
	public Servidor() {
		ServerSocket skSRV;
		try {
			skSRV = new ServerSocket(PUERTO);
			System.out.println("Servidor escuchando en: " + skSRV.getLocalSocketAddress().toString());
			int nCli = 0;
			while (true) {
				Socket skAtencion = skSRV.accept();
				nCli++;
				System.out.println("Estoy atendiendo al nuevo cliente: " + nCli);
				
				new ServidorHilo(skAtencion, nCli).start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Servidor();
	}

}
