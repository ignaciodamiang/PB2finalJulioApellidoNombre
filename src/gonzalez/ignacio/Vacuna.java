package gonzalez.ignacio;

import java.util.Objects;

public class Vacuna {

	private TipoVacuna tipoVacuna;
	private String observacion;
	
	public Vacuna(TipoVacuna tipoVacuna) {
		super();
		this.tipoVacuna=tipoVacuna;
	}
	
	public TipoVacuna getTipoVacuna() {
		return tipoVacuna;
	}
	
	public void setTipoVacuna(TipoVacuna tipoVacuna) {
		this.tipoVacuna = tipoVacuna;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tipoVacuna);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vacuna other = (Vacuna) obj;
		return tipoVacuna == other.tipoVacuna;
	}
}
