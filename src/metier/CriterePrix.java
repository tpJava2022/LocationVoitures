package metier;

public class CriterePrix implements Critere {

	private int prix;
	
	public CriterePrix(int prix) {
		this.prix = prix;
	}
	@Override
	public boolean estSatisfaitPar(Voiture v) {
		// TODO Auto-generated method stub
		return prix>=v.getPrixLocation();
	}
	public int getPrix() {
		return prix;
	}
	
}
