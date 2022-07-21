package exercici1;

public class ExcepcioFilaIncorrecta extends Exception{
	public ExcepcioFilaIncorrecta() {
		super("La fila introduida no existeix");
	}

}
