package AmethystKeyBoard;

public class Action {
	private int comportamento;
	private int quantidade;
	private int state;
	
	public Action(int comportamento) {
		this.comportamento = comportamento;
		this.quantidade = 0;
		this.state = 0;
	}
	
	public synchronized void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public synchronized void press() {
		this.press(1);
	}
	public synchronized void press(int quantia) {
		if(this.state != 2) {
			this.quantidade += quantia;
			this.state = 1;
		}
	}
	public synchronized void release() {
		this.state =0;
	}
	public synchronized boolean  isPressed() {
		return this.getAmount() != 0;
	}
	public synchronized int getAmount() {
		int quant = this.quantidade;
		if(quant !=0) {
			if(this.state == 0) {
				this.quantidade =0;
				
			}else if(this.comportamento == 1) {
				this.state = 2;
				this.quantidade = 0;
			}
		}
		return quant;
	}
}
