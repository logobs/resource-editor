package com.logo.data.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RE_TURKMENTM", indexes = { @Index(name = "I_TURKMENTM_INFO", columnList = "INFO,ID", unique = true),
		@Index(name = "I_TURKMENTM_RESITEMREF", columnList = "RESOURCEITEMREF", unique = false) })
public class ReTurkmentm extends ReLanguageTable implements Serializable {

	private static final long serialVersionUID = 1L;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RESOURCEITEMREF", referencedColumnName = "ID", insertable = false, updatable = false)
	public ReResourceitem reResourceitem;

	public ReTurkmentm() {
		/* */
	}

	public ReTurkmentm cloneTurkmentm(ReResourceitem item) {
		ReTurkmentm turkmentm = new ReTurkmentm();
		turkmentm = cloneLanguage(item, turkmentm);
		return turkmentm;
	}

}
