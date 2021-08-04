package gonzalez.ignacio;

import java.util.Objects;

public abstract class Persona implements Comparable<Persona>{
	private String nombre;
	private String apellido;
	protected Integer documento;
	
	public Persona(String nombre, String apellido, Integer documento) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getDocumento() {
		return documento;
	}

	public void setDocumento(Integer documento) {
		this.documento = documento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, documento, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Persona))
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(documento, other.documento)
				&& Objects.equals(nombre, other.nombre);
	}

	
}
