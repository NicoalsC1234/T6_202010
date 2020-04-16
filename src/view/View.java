package view;

import model.data_structures.Comparendo;
import model.logic.Modelo;

public class View {
	
	    public View()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("1. Crear el arbol y leer los datos");
			System.out.println("2. Busca los datos por ObjectID");
			System.out.println("3. Busca los datos en un rango de ObjectID");
			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
		}

		public static void printMessage(String comparendo) {

			System.out.println(comparendo);
		}		
		
		public void printModelo(Modelo modelo)
		{
			System.out.print(modelo);
		}
}
