package fr.univ.savoie.jee.tp.interfaces;



import java.rmi.RemoteException;
import java.util.Collection;

import javax.ejb.EJBObject;
import javax.ejb.FinderException;


public interface ChatManager extends EJBObject {

	public void creerChat(int id, String nom)
		throws RemoteException;

	
}
