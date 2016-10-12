package be.vdab.web;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class OpslagForm {

	@NotNull
	@Min(1)
	private BigDecimal bedrag;

	public BigDecimal getBedrag() {
		return bedrag;
	}
	

}
