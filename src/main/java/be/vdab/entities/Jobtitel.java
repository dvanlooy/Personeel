package be.vdab.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;

@Entity
@Table(name = "jobtitels")
public class Jobtitel  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@SafeHtml
	@NotBlank
	@Length(min = 1, max = 50)
	private String naam;
	
	@Version
	private long versie;

	//CONSTRUCTORS
	protected Jobtitel() {
	}

	public Jobtitel(String naam) {
		this.naam = naam;
	}

	//GETTERS (& SETTERS)
	public long getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}

	
	//OVERRIDE METHODS
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((naam == null) ? 0 : naam.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Jobtitel))
			return false;
		Jobtitel other = (Jobtitel) obj;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equals(other.naam))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return naam;
	}
	
	
	

	
	
	
	
	
	
	

}
