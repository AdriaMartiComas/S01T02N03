package exercici1;

import java.util.Iterator;
import java.util.Scanner;

@SuppressWarnings("resource")
public class Cine {
	private int nfiles;
	private int nButaquesPerFila;
	private GestioButaques gestioButaques;

	public Cine() {
		gestioButaques = new GestioButaques();
		demanarDadesInicials();

		// Proves
		gestioButaques.getButaques().add(new Butaca(4, 4, "Adria"));
		gestioButaques.getButaques().add(new Butaca(4, 5, "Adria"));
		gestioButaques.getButaques().add(new Butaca(4, 6, "Adria"));
		gestioButaques.getButaques().add(new Butaca(3, 7, "Maria"));
		gestioButaques.getButaques().add(new Butaca(5, 4, "Andrea"));

	}

	private void demanarDadesInicials() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introdueix el numero de files: ");
		this.nfiles = sc.nextInt();
		System.out.println("Introdueix el numero de butaques per fila: ");
		this.nButaquesPerFila = sc.nextInt();
	}

	public void iniciar() {
		boolean sortir = false;

		do {
			switch (menu()) {
			case 0:
				System.out.println("Gracies per utilitzar l'aplicació");
				sortir = true;
				break;
			case 1:
				mostrarButaques(gestioButaques);
				break;
			case 2:
				mostrarButaquesPersona(gestioButaques);
				break;
			case 3:
				reservarButaca(gestioButaques);
				break;
			case 4:
				anularReserva(gestioButaques);
				break;
			case 5:
				anularReservaPersona(gestioButaques);
			}
		} while (!sortir);
	}

	private void anularReservaPersona(GestioButaques gestioButaques) {

		String nom = introduirPersona();

		Iterator<Butaca> it = gestioButaques.getButaques().iterator();

		while (it.hasNext()) {
			Butaca b = it.next();
			if (b.getNomReserva().equalsIgnoreCase(nom)) {
				it.remove();
			}
		}

	}

	private void anularReserva(GestioButaques gestioButaques) {

		Butaca bAux = new Butaca(introduirFila(), introduirSeient(), "aux");

		gestioButaques.eliminarButaca(bAux);
	}

	private void reservarButaca(GestioButaques gestioButaques) {

		gestioButaques.afegirButaca(new Butaca(introduirFila(), introduirSeient(), introduirPersona()));

	}

	private void mostrarButaquesPersona(GestioButaques gestioButaques2) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introdueix el nom de la persona que ha fet la reserva:");
		String nom = sc.nextLine();
		for (Butaca b : gestioButaques.getButaques()) {
			if (b.getNomReserva().equalsIgnoreCase(nom)) {
				System.out.println(b);
			}
		}

	}

	private void mostrarButaques(GestioButaques gestioButaques) {
		for (Butaca b : gestioButaques.getButaques()) {
			System.out.println(b);
		}
	}

	private int menu() {
		Scanner entrada = new Scanner(System.in);
		int opcio;
		final int MINIMO = 0;
		final int MAXIMO = 5;

		do {
			System.out.println("\nMENú PRINCIPAL");
			System.out.println("1. Mostrar butaques reservades ");
			System.out.println("2. Mostrar butaques reservades per una persona ");
			System.out.println("3. Reservar una butaca ");
			System.out.println("4. Anul·lar la reserva d'una butaca");
			System.out.println("5. Anul·lar totes les reserves d'una persona");

			System.out.println("0. Sortir de l'aplicacio");

			opcio = entrada.nextInt();
			if (opcio < MINIMO || opcio > MAXIMO) {
				System.out.println("Escull una opció vàlida");
			}
		} while (opcio < MINIMO || opcio > MAXIMO);

		return opcio;
	}

	private String introduirPersona() {
		Scanner sc = new Scanner(System.in);
		String out = "";
		boolean validInput = false;

		do {
			System.out.println("Introdueix el nom: ");
			String nom = sc.nextLine();

			try {
				if (!nom.matches(".*[0-9].*")) {
					out = nom;
					validInput = true;
				} else {
					throw new ExcepcioNomPersonaIncorrecte();
				}
			} catch (ExcepcioNomPersonaIncorrecte enpi) {
				System.out.println(enpi);
			}
		} while (!validInput);
		return out;

	}

	public int introduirSeient() {
		Scanner sc = new Scanner(System.in);
		int butaca = 0;
		boolean validInput = false;

		do {
			System.out.println("Introdueix el numero del seient: ");
			int aux = sc.nextInt();

			try {
				if (aux > 0 && aux <= nButaquesPerFila) {
					butaca = aux;
					validInput = true;
				} else {
					throw new ExcepcioSeientIncorrecte();
				}
			} catch (ExcepcioSeientIncorrecte esi) {
				System.out.println(esi);
			}
		} while (!validInput);

		return butaca;
	}

	public int introduirFila() {
		Scanner sc = new Scanner(System.in);
		int fila = 0;
		boolean validInput = false;

		do {

			System.out.println("Introdueix el numero de la fila: ");
			int aux = sc.nextInt();

			try {
				if (aux > 0 && aux <= this.nfiles) {
					fila = aux;
					validInput = true;
				} else {
					throw new ExcepcioFilaIncorrecta();
				}
			} catch (ExcepcioFilaIncorrecta efi) {
				System.out.println(efi);
			}
		} while (!validInput);

		return fila;
	}
}
