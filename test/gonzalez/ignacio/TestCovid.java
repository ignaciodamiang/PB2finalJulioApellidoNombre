package gonzalez.ignacio;

import static org.junit.Assert.*;

public class TestCovid {

	@org.junit.Test
	public void testQueSePuedaVacunarAlguienConLasDosDosisParaCovid() throws NoMoreVaccineException, NoCovidVaccineException {
		CentroVacunacion centro = new CentroVacunacion("nombreCentro", "direccionCentro");
		Paciente paciente = new Paciente("Pedro", "Varela", 11222333);
		Boolean primeraDosis = centro.aplicarPrimeraDosis(paciente);
		Boolean segundaDosis = centro.aplicarSegundaDosis(paciente);
		assertTrue(primeraDosis);
		assertTrue(segundaDosis);
	}
	
	@org.junit.Test(expected = NoCovidVaccineException.class)
	public void testQueNoSePuedaDarLaSegundaDosisSinLaPrimera() throws NoCovidVaccineException, NoMoreVaccineException {
		CentroVacunacion centro = new CentroVacunacion("nombreCentro", "direccionCentro");
		Paciente paciente = new Paciente("Pedro", "Varela", 11222333);
		Boolean segundaDosis = centro.aplicarSegundaDosis(paciente);
		assertFalse(segundaDosis);
	}
	
	@org.junit.Test
	public void vacunadoCovid19() throws NoMoreVaccineException, NoCovidVaccineException{
		CentroVacunacion centro = new CentroVacunacion("nombreCentro", "direccionCentro");
		Paciente paciente = new Paciente("Pedro", "Varela", 11222333);
		centro.aplicarPrimeraDosis(paciente);
		centro.aplicarSegundaDosis(paciente);
		assertTrue(paciente.vacunadoCovid19());
	}

}
