package pronósticosDeportivos;

public class PronósticosDeportivos {

	public static void main(String[] args) {
		
		/*Escritura escritura = new Escritura();
		escritura.escribirPronostico();		// ===> PARA ESCRIBIR PRONOSTICOS
		*/
		
		int puntaje = 0;
		String resultado1 = "0";
		String resultado2 = "0";
		String prono1="";
		String prono2="";
		String resp1="";
		String resp2="";
		String resp3="";
		
		Lectura archivo = new Lectura();
		
		System.out.println(" ---- PRONOSTICOS ---- ");
		String[] archi= archivo.leerPronosticos();
		String[] letraSeparada;
		int i = 0;
		String equipo1 = null, equipo2 = null;
		String tipoPronostico1 = "", tipoPronostico2 = "";
		
		for(String palabras : archi) { // Ciclo donde leemos las lineas
			
			int indice = 0;
			
			letraSeparada= palabras.split(";"); // Separamos las palabras 
			
			for(String coso : letraSeparada) {// Cliclo donde leemos las palabras
				
				switch (indice) {// Asignamos valores a las variables
					case 0:
						equipo1=coso;
					case 1:
						if(coso.contains("1") && indice==1) {
							tipoPronostico1 = "GANA";
							tipoPronostico2 = "PIERDE";
						}
					case 2:
						if(coso.contains("1") && indice==2) {
							tipoPronostico1 = "EMPATA";
							tipoPronostico2 = "EMPATA";
							}
					case 3:						
						if(coso.contains("1") && indice==3) {
							tipoPronostico1 = "PIERDE";
							tipoPronostico2 = "GANA";
							}
					case 4:
						equipo2=coso;
				}
			
				indice++;				
				
			}			
			System.out.println("Equipo1 : " +equipo1 + " → " + tipoPronostico1);
			System.out.println("Equipo2 : " +equipo2 + " → " + tipoPronostico2);
			
			if(i==0) {
				prono1=tipoPronostico1+tipoPronostico2;// Combinamos los resultados de ambos equipos
				System.out.println("pronostico 1: "+prono1);				
				i++;
			}else if(i==1) {
				prono2=tipoPronostico1+tipoPronostico2;
				
				System.out.println("pronostico 2: "+prono2);
				i++;
			}
			
			System.out.println();
			
			
		}
		
//		----------------------------------------------------------------------------------------------------------
		
		System.out.println("----  RESULTADOS  ----");
		
		archi= archivo.leerResultados();
		letraSeparada=null;		
		equipo1 = "";
		equipo2 = "";
		
		for(String palabras : archi) {
			
			int indice = 0;
			letraSeparada= palabras.split(";"); // Separamos las palabras 
			
			for(String coso : letraSeparada) {
				
				switch (indice) {// Asignamos valores a las variables
					case 0:
						equipo1=coso;
					case 1:						
						resultado1= coso;						
					case 2:					
						resultado2= coso;						
					case 3:
						equipo2=coso;
				}			
				indice++;		
			
			}
			int resul1 = Integer.parseInt(resultado1); // Pasamos los resultados a Enteros
			int resul2 = Integer.parseInt(resultado2); // para despues poder compararlos
			
			System.out.println("Equipo1 : " + equipo1 + " → "+ resul1);
			System.out.println("Equipo2 : " + equipo2 + " → "+ resul2);
			
			if(resul1 > resul2) {
				resultado1 = "GANA";
				resultado2 = "PIERDE";
				System.out.println(equipo1 +" "+ resultado1);
				System.out.println(equipo2 +" "+ resultado2);
				resp1 = resultado1 + resultado2;
								
				
			}else if(resul1 < resul2) {
				resultado1 = "PIERDE";
				resultado2 = "GANA";
				System.out.println(equipo1 +" "+ resultado1);
				System.out.println(equipo2 +" "+ resultado2);
				resp2 = resultado1 + resultado2;
				
			}else {
				resultado1 = "EMPATA";
				resultado2 = "EMPATA";
				System.out.println(equipo1 +" "+ resultado1);
				System.out.println(equipo2 +" "+ resultado2);
				resp3 = resultado1 + resultado2;				
				
			}	
			//Ordenamos la variable con resultado vacío al final
			if(resp1 == "") {
				resp1 = resp2;
				resp2 = resp3;
			}else if(resp2 == "") {
				resp2 = resp3;
				resp3 = "";
			}
			// Comparamos los Resultados con los Pronosticos para asignar puntaje
			if(prono1.equals(resp1)) {
				puntaje++;						
			}else if(prono2.equals(resp2)) {
				puntaje++;
			}
			
			System.out.println("");
			
		}
				
		System.out.println("----  PUNTAJE ------");	
		if(puntaje == 1 || puntaje == 0) {// Verificamos si el resultado es plural o singular para mostrarlo
			System.out.println("Acierto : "+puntaje+ " punto");
		}else {
			System.out.println("Aciertos: " +puntaje+ " puntos ");
		}
		
	}		
		
}

