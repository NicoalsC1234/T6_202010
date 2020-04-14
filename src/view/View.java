package view;

import model.logic.Modelo;

public class View {
	
	    public View()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("1. Crear el arbol y leer los datos");
			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
		}

		public static void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		public void printModelo(Modelo modelo)
		{
			System.out.print(modelo);
		}
}
