package exercici1;

public class ExcepcioNomPersonaIncorrecte extends Exception {
	
	public ExcepcioNomPersonaIncorrecte() {
		super("El nom d'una persona no pot contenir numeros");
	}

}
