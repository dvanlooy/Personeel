package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name = "werknemers")
public class Werknemer implements Serializable, Comparable<Werknemer> {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@SafeHtml
	@NotBlank
	@Length(min = 1, max = 50)
	private String familienaam;

	@SafeHtml
	@NotBlank
	@Length(min = 1, max = 50)
	private String voornaam;

	@Email
	@NotBlank
	@Length(min = 1, max = 100)
	private String email;

	// bi-directionele relatie tussen werknemers (chef-ondergeschikten)
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "chefid")
	private Werknemer chef;
	@OneToMany(mappedBy = "chef")
	private Set<Werknemer> ondergeschikten;

	@Valid
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "jobtitelid")
	private Jobtitel jobtitel;

	@NumberFormat(style = Style.NUMBER)
	@NotNull
	@Min(1)
	@Digits(integer = 10, fraction = 2)
	private BigDecimal salaris;

	@Version
	private long versie;

	// CONSTRUCTORS
	protected Werknemer() {
	}

	public Werknemer(String familienaam, String voornaam, Werknemer chef, String email, Jobtitel jobtitel, BigDecimal salaris) {
		this.familienaam = familienaam;
		this.voornaam = voornaam;
		this.chef = chef;
		this.email = email;
		this.jobtitel = jobtitel;
		this.salaris = salaris;
		ondergeschikten = new HashSet<>();
	}

	// GETTERS (& SETTERS)
	public long getId() {
		return id;
	}

	public String getFamilienaam() {
		return familienaam;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public String getEmail() {
		return email;
	}

	public Werknemer getChef() {
		return chef;
	}

	public void setChef(Werknemer chef) {
		this.chef = chef;
	}

	public Set<Werknemer> getOndergeschikten() {
		return ondergeschikten;
	}

	public Jobtitel getJobtitel() {
		return jobtitel;
	}

	public void setJobtitel(Jobtitel jobtitel) {
		this.jobtitel = jobtitel;
	}

	public BigDecimal getSalaris() {
		return salaris;
	}

	public void setSalaris(BigDecimal salaris) {
		this.salaris = salaris;
	}

	// OVERRIDE METHODS
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Werknemer))
			return false;
		Werknemer other = (Werknemer) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return voornaam + " " + familienaam;
	}

	// alfabetische rangschikking van de werkenemers in Set ondergeschikten op
	// familienaam > voornaam
	@Override
	public int compareTo(Werknemer o) {
		if (this.familienaam == o.familienaam) {
			return this.voornaam.compareTo(o.voornaam);
		}
		return this.familienaam.compareTo(o.familienaam);
	}

}
