package ejercicio4;

public class Chequeo {

	private int max;

	public Chequeo(int max) {
		super();
		this.max = max;
	}
	
	public int chequearMaximo(int num) {
		if(num > this.max) {
			this.max = num;
		}
		return this.max;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}
	
	
	
}
