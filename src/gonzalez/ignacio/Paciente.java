package gonzalez.ignacio;

import java.util.HashSet;

public class Paciente extends Persona {

	private HashSet<Vacuna> vacunasAplicadas;
	Boolean primeraDosis = false;
	Boolean segundaDosis = false;
	Boolean vacunaHepatitisA = false;
	Boolean vacunaHepatitisB = false;
	Boolean vacunaHepatitisC = false;
	Boolean enfermoRubeola = false;
	Boolean enfermoHepatitis = false;

	public Paciente(String nombre, String apellido, Integer documento) {
		super(nombre, apellido, documento);
		vacunasAplicadas = new HashSet<Vacuna>();
	}

	public Boolean vacunadoCovid19() {
		if (this.primeraDosis && this.segundaDosis) {
			return true;
		} else
			return false;
	}

	public HashSet<Vacuna> getVacunasAplicadas() {
		return vacunasAplicadas;
	}

	public void setVacunasAplicadas(HashSet<Vacuna> vacunasAplicadas) {
		this.vacunasAplicadas = vacunasAplicadas;
	}

	public Boolean getPrimeraDosis() {
		return primeraDosis;
	}

	public void setPrimeraDosis(Boolean primeraDosis) {
		this.primeraDosis = primeraDosis;
	}

	public Boolean getSegundaDosis() {
		return segundaDosis;
	}

	public void setSegundaDosis(Boolean segundaDosis) {
		this.segundaDosis = segundaDosis;
	}
	
	public Boolean agregarVacuna(Vacuna vacuna) {
		return this.vacunasAplicadas.add(vacuna);
	}

	public Boolean getEnfermoRubeola() {
		return enfermoRubeola;
	}

	public void setEnfermoRubeola(Boolean enfermoRubeola) {
		this.enfermoRubeola = enfermoRubeola;
	}

	public Boolean getEnfermoHepatitis() {
		return enfermoHepatitis;
	}

	public void setEnfermoHepatitis(Boolean enfermoHepatitis) {
		this.enfermoHepatitis = enfermoHepatitis;
	}

	public Boolean getVacunaHepatitisA() {
		return vacunaHepatitisA;
	}

	public void setVacunaHepatitisA(Boolean vacunaHepatitisA) {
		this.vacunaHepatitisA = vacunaHepatitisA;
	}

	public Boolean getVacunaHepatitisB() {
		return vacunaHepatitisB;
	}

	public void setVacunaHepatitisB(Boolean vacunaHepatitisB) {
		this.vacunaHepatitisB = vacunaHepatitisB;
	}

	public Boolean getVacunaHepatitisC() {
		return vacunaHepatitisC;
	}

	public void setVacunaHepatitisC(Boolean vacunaHepatitisC) {
		this.vacunaHepatitisC = vacunaHepatitisC;
	}

	@Override
	public int compareTo(Persona o) {
		return o.getDocumento().compareTo(documento);
	}
	
}
