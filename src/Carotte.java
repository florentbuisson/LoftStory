
public class Carotte extends Nonneuneu {
	public Carotte(){
		this.setValeurEnergetique(3);
		this.masse = (int) (Math.random()*9) + 1;
	}

	public Carotte(int m) {
		this.setValeurEnergetique(3);
		if (m >= 1) {
			this.masse = m;
		} else {
			this.masse = 1;
		}
	}
}
