package metier;

import java.io.Serializable;
import java.util.*;
public class Clients implements Serializable {
	private List<Client> clients;

	public Clients(List<Client> clients) {
		this.clients = clients;
	}

	public Clients() {
		clients=new ArrayList<Client>();
	}
	public void add(Client c) {
		clients.add(c);
	}
	
	public boolean delete(String cin) {
		Client cl=null;
		boolean var=false;
		for(Client c:clients) {
			if(c.getCin().equals(cin)) {
				cl=c;
				break;
			}
		
		}
		if(cl!=null) {
			clients.remove(cl);
			return true;
		}
		return false;
		
	}
	public List<Client> lesClients()
	{
		return clients;
	}
}
