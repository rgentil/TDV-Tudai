package restaurant;

public class SinSaldoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toString() {
		return "No tiene suficiente saldo";
	}
}
