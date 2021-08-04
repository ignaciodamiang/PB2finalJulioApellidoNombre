package gonzalez.ignacio;

import static org.junit.Assert.*;

import java.util.TreeSet;

public class Otro {

	@org.junit.Test
	public void unPacienteNoTieneNingunaVacunaCuandoSeCrea() {
		Paciente paciente = new Paciente("Pedro", "Varela", 11222333);
		Integer cantidadVacunas = paciente.getVacunasAplicadas().size();
		assertTrue(cantidadVacunas.equals(0));
	}
	
	@org.junit.Test
	public void vacunadoCovid19() throws NoMoreVaccineException, NoCovidVaccineException{
		CentroVacunacion centro = new CentroVacunacion("nombreCentro", "direccionCentro");
		Paciente paciente = new Paciente("Pedro", "Varela", 11222333);
		centro.aplicarPrimeraDosis(paciente);
		centro.aplicarSegundaDosis(paciente);
		assertTrue(paciente.vacunadoCovid19());
	}
	
	@org.junit.Test
	public void noPuedeAplicarDosVecesLaMismaVacuna() throws NoMoreVaccineException{
		CentroVacunacion centro = new CentroVacunacion("nombreCentro", "direccionCentro");
		Paciente paciente = new Paciente("Pedro", "Varela", 11222333);
		centro.aplicarRubeola(paciente);
		Boolean segundaAplicacion = centro.aplicarRubeola(paciente);
		assertFalse(segundaAplicacion);
	}
	
	@org.junit.Test
	public void listaOrdenadaPorDNI() throws NoMoreVaccineException{
		CentroVacunacion centro = new CentroVacunacion("nombreCentro", "direccionCentro");
		Paciente paciente2 = new Paciente("Belen", "Varela", 22111333);
		Paciente paciente1 = new Paciente("Ana", "Varela", 11222333);
		Paciente paciente3 = new Paciente("Carlos", "Varela", 33222333);
		
		centro.aplicarRubeola(paciente2);
		centro.aplicarRubeola(paciente3);
		centro.aplicarRubeola(paciente1);
		
		TreeSet<Paciente> listaOrdenada = centro.getListaOrdenada();
		
		assertTrue(listaOrdenada.first().equals(paciente3));
	}

}
