package pl.sewq.core.model.item;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import pl.sewq.model.dwarf.Dwarf;

@Entity
@Table(name = "WAR_ITEMS")
public class Item implements Serializable {

	private static final long serialVersionUID = 123782772079855223L;

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Dwarf dwarf;

	private String name;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public Dwarf getDwarf() {
		return dwarf;
	}

	public void setDwarf(final Dwarf dwarf) {
		this.dwarf = dwarf;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

}
