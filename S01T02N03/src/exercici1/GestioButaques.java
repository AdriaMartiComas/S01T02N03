package exercici1;

import java.util.ArrayList;

public class GestioButaques {

	private ArrayList<Butaca> butaques;

	public GestioButaques() {
		this.butaques = new ArrayList<Butaca>();
	}

	public ArrayList<Butaca> getButaques() {
		return butaques;
	}

	public void afegirButaca(Butaca butacaAfegir) {

		try {

			if (cercarButaca(butacaAfegir) == null) {
				butaques.add(butacaAfegir);
			} else {
				throw new ExcepcioButacaOcupada();
			}
		} catch (ExcepcioButacaOcupada ebo) {
			System.out.println(ebo);
		}
	}

	public void eliminarButaca(Butaca butacaEliminar) {

		try {

			if (cercarButaca(butacaEliminar) == null) {
				throw new ExcepcioButacaLliure();
			} else {
				butaques.remove(cercarButaca(butacaEliminar));

			}
		} catch (ExcepcioButacaLliure ebl) {
			System.out.println(ebl);
		}
	}

	public Butaca cercarButaca(Butaca b) {
		Butaca auxButaca = null;
		int i = 0, size = this.getButaques().size();

		while (auxButaca == null && i < size) {
			if (butaques.get(i).equals(b)) {
				auxButaca = butaques.get(i);
				i++;
			} else {
				i++;
			}

		}
		return auxButaca;
	}

	
}
