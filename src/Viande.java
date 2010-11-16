
public class Viande extends Nonneuneu{
	public Viande(){
		this.setValeurEnergetique(7);
		this.masse = (int) (Math.random()*9) + 1;
	}

	public Viande(int m) {
		this.setValeurEnergetique(7);
		if (m >= 1) {
			this.masse = m;
		} else {
			this.masse = 1;
		}
	}
}
