package fr.univsavoie.cours.exemplej2ee.interfaces;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;

/**
 * @author St�phane Talbot
 *
 * Interface Home du bean session pour manipuler les comptes.
 * 
 * 
 */
public interface OperationHome extends EJBHome {
	/**
	 * Cr�ation d'une instance du bean session.
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws CreateException
	 */
	Operation create() throws RemoteException, CreateException;
}
