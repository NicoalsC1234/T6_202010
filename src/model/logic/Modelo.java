
package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.sun.corba.se.impl.orbutil.RepositoryIdUtility;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import model.data_structures.Comparendo;
import model.data_structures.RedBlackBST;



public class Modelo {

	public static String PATH = "./data/comparendos_dei_2018_small.geojson"; 

	public RedBlackBST<Integer,Comparendo> arbolRN;

	public int tamano;

	int max;

	public Modelo()
	{
		tamano = 0;
		arbolRN = new RedBlackBST<Integer,Comparendo>();
	}


	public String cargarDatos() 
	{
		Comparendo mayor = new Comparendo();
		if(arbolRN.isEmpty()){
			JsonReader reader;
			try {
				reader = new JsonReader(new FileReader(PATH));
				JsonElement elem = JsonParser.parseReader(reader);
				JsonArray e2 = elem.getAsJsonObject().get("features").getAsJsonArray();


				SimpleDateFormat parser=new SimpleDateFormat("yyyy/MM/dd");

				for(JsonElement e: e2) {

					Comparendo c = new Comparendo();
					c.OBJECTID = e.getAsJsonObject().get("properties").getAsJsonObject().get("OBJECTID").getAsInt();

					String s = e.getAsJsonObject().get("properties").getAsJsonObject().get("FECHA_HORA").getAsString();	
					SimpleDateFormat dateParser=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
					c.FECHA_HORA = dateParser; 


					c.MEDIO_DETE = e.getAsJsonObject().get("properties").getAsJsonObject().get("MEDIO_DETE").getAsString();
					c.CLASE_VEHI = e.getAsJsonObject().get("properties").getAsJsonObject().get("CLASE_VEHI").getAsString();
					c.TIPO_SERVI = e.getAsJsonObject().get("properties").getAsJsonObject().get("TIPO_SERVI").getAsString();
					c.INFRACCION = e.getAsJsonObject().get("properties").getAsJsonObject().get("INFRACCION").getAsString();
					c.DES_INFRAC = e.getAsJsonObject().get("properties").getAsJsonObject().get("DES_INFRAC").getAsString();	
					c.LOCALIDAD = e.getAsJsonObject().get("properties").getAsJsonObject().get("LOCALIDAD").getAsString();

					c.longitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
							.get(0).getAsDouble();

					c.latitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
							.get(1).getAsDouble();

					if(c.compareTo(mayor) > 0) mayor = c;

					for (int i = 0; i < e2.size(); i++) {
						
						arbolRN.put(c.OBJECTID, c);
						tamano ++;
					}
					
					

				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return mayor.toString();
		}
		else
			System.out.println("---");
		return null;
	}

	public int darTamano() {
		return arbolRN.size();
	}
	
	public int minOBJECTID()
	{
		return arbolRN.min();
	}
	
	public int maxOBJECTID()
	{
		return arbolRN.max();
	}
	
	public Comparendo consultarComparendoID(int objid)
	{
		if(arbolRN.contains(objid))
		{
			return arbolRN.get(objid);
		}
		
		return null;
	}
	
	public Comparendo consultarComparendoEnRangoID(int objid1, int objid2 )
	{
		// falta piruca
		return 
	}

}