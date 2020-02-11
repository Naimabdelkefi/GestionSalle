import java.util.Observable;

public class Model extends Observable{
	private double v;
	
	public double getV() {
		return v;
	}
	public void setV(double v) {
		this.v = v;
		setChanged();
		notifyObservers();
	}
	
	public Model() {
		
	}
}
