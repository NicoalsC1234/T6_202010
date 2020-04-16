package controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.data_structures.*;

import model.logic.Modelo;
import view.View;

public class Controller <T extends Comparable<T>>{

	private Modelo modelo;

	private View view;

	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}

	public void run() throws InputMismatchException {

		try {

			Scanner reader = new Scanner(System.in);

			boolean end = false;



			while (!end) {

				view.printMenu();

				int option = reader.nextInt();

				switch (option) {



				case 1:
					view.printMessage(modelo.cargarDatos());
					view.printMessage("Se han cargado los datos");
					view.printMessage("El numero de datos leidos es : " + modelo.darTamano());
					view.printMessage("El OBJECTID minimo es: "+ modelo.minOBJECTID());
					view.printMessage("El OBJECTID maximo es: "+ modelo.maxOBJECTID());

				case 2:
					view.printMessage("Escribir el numero de Object ID");
					int objectid = Integer.parseInt(reader.next());
					view.printMessage(modelo.consultarComparendoID(objectid).toString());;
				case 3:
					view.printMessage("Escribe el primer ObjectID");
					int objectid1 = Integer.parseInt(reader.next());
					view.printMessage("Escribe el segundo ObjectID");
					int objectid2 = Integer.parseInt(reader.next());
					view.printMessage(modelo.consultarComparendoEnRangoID(objectid1, objectid2).toString());

				} 


			}
		}


		catch (InputMismatchException e) {

			run();

		}

	}

}