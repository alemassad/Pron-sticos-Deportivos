package pronósticosDeportivos;

public class PronósticosDeportivos {

	public static void main(String[] args) {
		
		/*Escritura escritura = new Escritura();
		escritura.escribirPronostico();		// ===> PARA ESCRIBIR PRONOSTICOS
		*/
		
		Lectura archivo = new Lectura();	
		
		System.out.println(" ---- PRONOSTICOS ---- ");		
		
		archivo.leerPronosticos();
	
//		----------------------------------------------------------------------------------------------------------
		
		System.out.println("----  RESULTADOS  ----");		
		
		archivo.leerResultados();
		
//		----------------------------------------------------------------------------------------------------------
		
		System.out.println("----  PUNTAJE  ----");	
		archivo.leerPuntaje();
	}		
		
}// Game Over

