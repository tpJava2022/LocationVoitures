package metier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Agence implements Serializable{
	
	private ArrayList<Voiture> voitures;
	private Map<Client, Voiture> locations=new HashMap<Client,Voiture>();

	public Agence(ArrayList<Voiture> voitures) {
		this.voitures = voitures;
	}

	public Agence() {
		// TODO Auto-generated constructor stub
		voitures=new ArrayList<Voiture>();
	}
	public ArrayList<Voiture> Voiture_agence()
	{
		return voitures;
	}
	
	
	public void louerVoiture(Client c,Voiture v) {
		try {
			int index;
			index=voitures.indexOf(v);
			try {
				locations.put(c, voitures.get(index));
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("la voiture est deja louee.");
			}	
		}catch(Exception e) {
			System.out.println("La voiture n'existe pas.");
		}
				
	}
	
	public boolean estLoueur(Client c) {
		return locations.containsKey(c);
	}
	
	
	public boolean estLoue(Voiture v) {
		return locations.containsValue(v);
	}
	
	public void  rendVoiture(Client client) {
		locations.remove(client);
	}
	
	public void add(Voiture v) {
		voitures.add(v);
	}
	
	public boolean remove(Voiture v) {
		return voitures.remove(v);
	}
	public boolean remove(int id)
	{
		for(Voiture v : voitures)
		{
			if (v.getId() == id)
				return voitures.remove(v);
		}
		return false;
	}
	
	public Iterator<Voiture> selectionne(Critere c){
		Iterator<Voiture> iVoitures;
		ArrayList<Voiture> voituresSelected=new ArrayList<Voiture>();
		for(Voiture voiture:voitures) {
			
			if(c.estSatisfaitPar(voiture))
				voituresSelected.add(voiture);
			
		}
		iVoitures=voituresSelected.iterator();
		return iVoitures;
	}
	
	public void afficheSelection(Critere c) {
		Iterator<Voiture> it=this.selectionne(c);
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public Client getClient(String cin) {
		Iterator<Client> it= locations.keySet().iterator();
		while(it.hasNext()) {
			Client cli=it.next();
			if(cli.getCin().equals(cin))
				return cli;
		}
		return null;
	}
	
	public Iterator<Voiture> voituresLouees(){
		Iterator<Voiture> it;
		
		ArrayList<Voiture> voitures=new ArrayList<Voiture>();
		
		Set<Client> clients=locations.keySet();
		Iterator<Client> loueurs=clients.iterator();
		
		while (loueurs.hasNext()) {
			voitures.add(locations.get(loueurs.next()));
			
		}
		
		it=voitures.iterator();
		
		return it;
	}

}
