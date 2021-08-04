package gonzalez.ignacio;

import java.util.TreeSet;

public class CentroVacunacion {

	private String nombreCentro;
	private String direccion;
	private TreeSet<Paciente> listaOrdenada;

	public CentroVacunacion(String nombreCentro, String direccion) {
		super();
		this.nombreCentro = nombreCentro;
		this.direccion = direccion;
		listaOrdenada = new TreeSet<Paciente>();
	}

	public String getNombreCentro() {
		return nombreCentro;
	}

	public void setNombreCentro(String nombreCentro) {
		this.nombreCentro = nombreCentro;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Boolean aplicarPrimeraDosis(Paciente paciente) throws NoMoreVaccineException {
		if (verificarDosVacunas(paciente)) {
			throw new NoMoreVaccineException("No puede aplicarse mas de dos vacunas");
		}
		if (paciente.getPrimeraDosis().equals(false)) {
			if (paciente.primeraDosis.equals(false)) {
				paciente.setPrimeraDosis(true);
				paciente.agregarVacuna(new Vacuna(TipoVacuna.COVID19PRIMERA));
				listaOrdenada.add(paciente);
			}
		}
		return paciente.getPrimeraDosis();
	}

	public Boolean aplicarSegundaDosis(Paciente paciente) throws NoCovidVaccineException, NoMoreVaccineException {
		if (verificarDosVacunas(paciente)) {
			throw new NoMoreVaccineException("No puede aplicarse mas de dos vacunas");
		}
		if (paciente.getPrimeraDosis().equals(true)) {
			if (paciente.segundaDosis.equals(false)) {
				paciente.setSegundaDosis(true);
				paciente.agregarVacuna(new Vacuna(TipoVacuna.COVID19SEGUNDA));
				listaOrdenada.add(paciente);
			}
		} else
			throw new NoCovidVaccineException("No tiene aplicada la primera dosis de covid");
		;
		return paciente.getSegundaDosis();
	}

	public Boolean aplicarRubeola(Paciente paciente) throws NoMoreVaccineException {
		if (verificarDosVacunas(paciente)) {
			throw new NoMoreVaccineException("No puede aplicarse mas de dos vacunas");
		}
		if (paciente.getEnfermoRubeola().equals(true)) {
			return false;
		} else
			listaOrdenada.add(paciente);
			return paciente.agregarVacuna(new Vacuna(TipoVacuna.RUBEOLA));
	}

	public Boolean aplicarHepatitis(Paciente paciente, TipoVacuna tipoHepatitis) throws NoMoreVaccineException {
		if (verificarDosVacunas(paciente)) {
			throw new NoMoreVaccineException("No puede aplicarse mas de dos vacunas");
		}
		
		if (paciente.getEnfermoHepatitis().equals(true)) {
			return false;
		} else
			switch (tipoHepatitis) {
			case HEPATITISA: {
				if (paciente.getVacunaHepatitisA()) {
					return paciente.getVacunaHepatitisA();
				} else
					paciente.agregarVacuna(new Vacuna(TipoVacuna.HEPATITISA));
				paciente.setVacunaHepatitisA(true);
				listaOrdenada.add(paciente);
				return paciente.getVacunaHepatitisA();
			}
			
			case HEPATITISB: {
				if (paciente.getVacunaHepatitisB()) {
					return paciente.getVacunaHepatitisB();
				} else
					paciente.agregarVacuna(new Vacuna(TipoVacuna.HEPATITISB));
				paciente.setVacunaHepatitisB(true);
				listaOrdenada.add(paciente);
				return paciente.getVacunaHepatitisB();
			}
			
			case HEPATITISC: {
				if (paciente.getVacunaHepatitisC()) {
					return paciente.getVacunaHepatitisC();
				} else
					paciente.agregarVacuna(new Vacuna(TipoVacuna.HEPATITISC));
				paciente.setVacunaHepatitisC(true);
				listaOrdenada.add(paciente);
				return paciente.getVacunaHepatitisC();
			}
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + tipoHepatitis);
			}
	}
	
	public Boolean verificarDosVacunas(Paciente paciente) {
		if (paciente.vacunadoCovid19().equals(true) && paciente.getVacunasAplicadas().size()>=3) {
			return true;
		}
		
		if (paciente.vacunadoCovid19().equals(false) && paciente.getVacunasAplicadas().size()>=2) {
			return true;
		}
		
		return false;
	}

	public TreeSet<Paciente> getListaOrdenada() {
		return listaOrdenada;
	}

	public void setListaOrdenada(TreeSet<Paciente> listaOrdenada) {
		this.listaOrdenada = listaOrdenada;
	}
	
}
