package gonzalez.ignacio;

import static org.junit.Assert.*;

public class TestRubeola {

	@org.junit.Test
	public void queSePuedaAplicarVacunaRubeola() throws NoMoreVaccineException {
		CentroVacunacion centro = new CentroVacunacion("nombreCentro", "direccionCentro");
		Paciente paciente = new Paciente("Pedro", "Varela", 11222333);
		Boolean aplicarRubeola = centro.aplicarRubeola(paciente);
		assertTrue(aplicarRubeola);
	}
	
	@org.junit.Test
	public void queNoSePuedaAplicarLaDeRubeolaSiTuvoLaEnfermedad() throws NoMoreVaccineException{
		CentroVacunacion centro = new CentroVacunacion("nombreCentro", "direccionCentro");
		Paciente paciente = new Paciente("Pedro", "Varela", 11222333);
		paciente.setEnfermoRubeola(true);
		Boolean aplicarRubeola = centro.aplicarRubeola(paciente);
		assertFalse(aplicarRubeola);
	}

}
