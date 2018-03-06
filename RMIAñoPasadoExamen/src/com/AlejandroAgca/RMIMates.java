package com.AlejandroAgca;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIMates extends Remote{

	public boolean esPrimo(int n) throws RemoteException;
}
