package fr.univ.savoie.jee.tp.interfaces;



import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;


public interface ChatManagerHome extends EJBHome {
	/**
	 * Création d'une instance du bean session.
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws CreateException
	 */
	ChatManager create() throws RemoteException, CreateException;
}
