package metier;

import java.util.ArrayList;

public class InterCriteres implements Critere {
	
	private ArrayList<Critere> criteres;
	
	
	
	public InterCriteres() {
		criteres=new ArrayList<Critere>();
	}

	
	public void add(Critere c) {
		criteres.add(c);
	}


	@Override
	public boolean estSatisfaitPar(Voiture v) {
		// TODO Auto-generated method stub
		
		for(Critere c:criteres) {
			if(!c.estSatisfaitPar(v))
				return false;
		}
		return true;
	}

}
