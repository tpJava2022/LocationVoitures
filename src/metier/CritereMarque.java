package metier;

public class CritereMarque implements Critere{
	private String marque;
	@Override
	public boolean estSatisfaitPar(Voiture v) {
		// TODO Auto-generated method stub
		return marque.equals(v.getMarque());
	}
	public CritereMarque(String marque) {
		this.marque = marque;
	}

}
