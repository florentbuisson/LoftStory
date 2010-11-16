
public class Alcool extends Nonneuneu{
	public Alcool(){
		this.setValeurEnergetique(5);
		this.masse = (int) (Math.random()*9) + 1;
	}

	public Alcool(int m) {
		this.setValeurEnergetique(5);
		if (m >= 1) {
			this.masse = m;
		} else {
			this.masse = 1;
		}
	}
}
