package pronósticosDeportivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PronósticosDeportivos {

	public static void main(String[] args) {
		
		Lectura archivo = new Lectura();
		
		System.out.println(" -- PRONOSTICOS -- ");
		String[] archi= archivo.leerPronosticos();
		String[] letraSeparada;
		
		String equipo1 = null, equipo2 = null;
		String tipoPronostico1 = "", tipoPronostico2 = "";
		for(String palabras : archi) {
			//System.out.println(palabras);
			int indice = 0;
			letraSeparada= palabras.split(";"); //Separamos las palabras 
			
			for(String coso : letraSeparada) {
				
				switch (indice) {//Asignamos valores a las variables
					case 0:
						equipo1=coso;
					case 1:
						if(coso.contains("1") && indice==1) {
							tipoPronostico1= "gana";
							tipoPronostico2= "pierde";
						}
					case 2:
						if(coso.contains("1") && indice==2) {
							tipoPronostico1= "empata";
							tipoPronostico2= "empata";
							}
					case 3:
						
						if(coso.contains("1") && indice==3) {
							tipoPronostico1="pierde";
							tipoPronostico2="gana";
							}
					case 4:
						equipo2=coso;
				}
			
				indice++;
				
			}
			
			System.out.println("Equipo1 : " +equipo1 + " → " + tipoPronostico1);
			System.out.println("Equipo2 : " +equipo2 + " → " + tipoPronostico2);
			
			System.out.println();
			
		}
//		----------------------------------------------------------------------------------------------------------
		System.out.println("---  RESULTADOS  ---");
		
		archi= archivo.leerResultados();
		letraSeparada=null;
		
		equipo1 = null;
		equipo2 = null;
		String tipoResultado1 = "";
		String tipoResultado2 = "";
		for(String palabras : archi) {
			//System.out.println(palabras);
			int indice = 0;
			letraSeparada= palabras.split(";"); //Separamos las palabras 
			
			for(String coso : letraSeparada) {
				
				switch (indice) {//Asignamos valores a las variables
					case 0:
						equipo1=coso;
					case 1:						
						tipoResultado1= coso;													
					case 2:					
						tipoResultado2= coso;					
					case 3:
						equipo2=coso;
				}			
				indice++;				
			}
			
			System.out.println("Equipo1 : " +equipo1 + " → " + tipoResultado1);
			System.out.println("Equipo2 : " +equipo2 + " → " + tipoResultado2);
			
			System.out.println();
			
		}
		
		
		
		/*Escritura escritura = new Escritura();
		escritura.escribir();
		*/
	}	
}


class Escritura{
	public void escribir() {
		String partido ="Argentina;1;0;0;Arabia Saudita \nPolonia;0;1;0;Mexico";
		try {
			FileWriter archivo = new FileWriter("C:\\Users\\pingo\\eclipse-workspace\\ArgentinaPrograma\\src\\pronósticosDeportivos\\pronostico.csv");
			
			for(int i=0; i< partido.length(); i++) {
				archivo.write(partido.charAt(i));
			}
			archivo.close();
		} catch (IOException e) {
			System.out.println("El archivo no se pudo escribir");
			e.printStackTrace();
		}
		
	}
}

class Lectura {
	
	String[] pronosticos= new String[2];//Para guardar la cantidad de partidos con pronosticos del archivo	
	
	public String[] leerPronosticos() {
		FileReader lectura = null;
		try {
			lectura = new FileReader("C:\\Users\\pingo\\eclipse-workspace\\ArgentinaPrograma\\src\\pronósticosDeportivos\\pronostico.csv");
			BufferedReader buffer = new BufferedReader(lectura);
			String letras= "";
			int indice=0;
			
			while(letras!=null) {//null representa salto de linea
				letras = buffer.readLine();
				
				if(letras!=null) {// IF para no imprimir null
					
					pronosticos[indice]= letras; 									
					indice++;
				}
			}
			buffer.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally {
			try {
				lectura.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
		return pronosticos;		
	}
	
	public String[] leerResultados() {
		
		FileReader lectura = null;
		try {
			lectura = new FileReader("C:\\Users\\pingo\\eclipse-workspace\\ArgentinaPrograma\\src\\pronósticosDeportivos\\resultados.csv");
			BufferedReader buffer = new BufferedReader(lectura);
			String letras= "";
			int indice=0;
			
			while(letras!=null) {//null representa salto de linea
				letras = buffer.readLine();
				
				if(letras!=null) {// IF para no imprimir null
					
					pronosticos[indice]= letras; 									
					indice++;
				}
			}
			buffer.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally {
			try {
				lectura.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
		return pronosticos;		
	}
	
	
}