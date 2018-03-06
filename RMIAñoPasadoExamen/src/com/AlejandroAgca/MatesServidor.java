package com.AlejandroAgca;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MatesServidor implements RMIMates {

	@Override
	public boolean esPrimo(int n) throws RemoteException {
		for (int i = 2; i < n/2; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public MatesServidor(Registry registro) {
		try {
			registro.bind("Mates", (RMIMates) UnicastRemoteObject.exportObject(this, 0));
		} catch (RemoteException | AlreadyBoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws RemoteException {
		final int PUERTO = 8888;
		System.setProperty("java.rmi.server.hostname", "localhost");
		System.setProperty("java.net.preferIPv4Stack", "true");
		Registry registro = LocateRegistry.createRegistry(PUERTO);
		new MatesServidor(registro);
	}
}
