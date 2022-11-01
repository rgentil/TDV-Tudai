package clases;

public class Arco {

	private Nodo i;
	private Nodo j;
	private float w;
	
	public Arco (Nodo i, Nodo j, float w) {
		this.i = i;
		this.j = j;
		this.w = w;
	}
	
	public Arco() {
		// TODO Auto-generated constructor stub
	}

	public void setExtremos(Nodo i, Nodo j, float w) throws Exception {
		if(i.getId()<j.getId()) {
				this.i = i;
				this.j = j;
				this.w = w;
		} else {
			throw new IdMayorException();
		}
	}
	}
