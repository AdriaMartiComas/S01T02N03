package exercici1;

public class Butaca {
	private int numFila;
	private int numSeient;
	private String nomReserva;

	public Butaca(int numFila, int numSeient, String nomReserva) {
		super();
		this.numFila = numFila;
		this.numSeient = numSeient;
		this.nomReserva = nomReserva;
	}

	public int getNumFila() {
		return numFila;
	}

	public int getNumSeient() {
		return numSeient;
	}

	public String getNomReserva() {
		return nomReserva;
	}

	public boolean equals(Butaca altreButaca) {
		boolean iguals = false;

		if (this.numFila == altreButaca.getNumFila()) {
			if (this.numSeient == altreButaca.getNumSeient()) {
				iguals = true;
			}
		}

		return iguals;
	}

	@Override
	public String toString() {
		return "Fila: " + numFila + ", Seient: " + numSeient + ", Persona: " + nomReserva;
	}
	
	

}
