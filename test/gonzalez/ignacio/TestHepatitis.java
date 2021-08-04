package gonzalez.ignacio;

import static org.junit.Assert.*;


public class TestHepatitis {

	@org.junit.Test
	public void queSePuedaAplicarHepatitis() throws NoMoreVaccineException  {
		CentroVacunacion centro = new CentroVacunacion("nombreCentro", "direccionCentro");
		Paciente paciente = new Paciente("Pedro", "Varela", 11222333);
		Boolean hepatitisA = centro.aplicarHepatitis(paciente, TipoVacuna.HEPATITISA);
		Boolean hepatitisB = centro.aplicarHepatitis(paciente, TipoVacuna.HEPATITISB);
		
		assertTrue(hepatitisA);
		assertTrue(hepatitisB);
	}
	
	@org.junit.Test(expected = NoMoreVaccineException.class)
	public void queNoSePUedaAplicarMasDeDosVacunas() throws NoMoreVaccineException  {
		CentroVacunacion centro = new CentroVacunacion("nombreCentro", "direccionCentro");
		Paciente paciente = new Paciente("Pedro", "Varela", 11222333);
		centro.aplicarHepatitis(paciente, TipoVacuna.HEPATITISA);
		centro.aplicarHepatitis(paciente, TipoVacuna.HEPATITISB);
		Boolean tercerVacuna = centro.aplicarHepatitis(paciente, TipoVacuna.HEPATITISC);
		assertFalse(tercerVacuna);
	}
	
	@org.junit.Test
	public void queNoSePuedaAplicarLaDeHepatitisSiTuvoLaEnfermedad() throws NoMoreVaccineException  {
		CentroVacunacion centro = new CentroVacunacion("nombreCentro", "direccionCentro");
		Paciente paciente = new Paciente("Pedro", "Varela", 11222333);
		paciente.setEnfermoHepatitis(true);
		Boolean aplicarHepatitis = centro.aplicarHepatitis(paciente, TipoVacuna.HEPATITISA);
		assertFalse(aplicarHepatitis);
	}

}
