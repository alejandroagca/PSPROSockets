package com.AlejandroAgca;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MatesCliente {
	
	static final int PUERTO = 8888;
	static final String HOST = "localhost";
	
	public static void main(String[] args) throws RemoteException {
		RMIMates mates;
		Registry registro = LocateRegistry.getRegistry(HOST,PUERTO);
		try {
			mates = (RMIMates)registro.lookup("Mates");
			System.out.println(mates.esPrimo(97));
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

}
