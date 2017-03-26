package pl.sewq.model.dwarf;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import pl.sewq.core.model.item.Item;

@Entity
@Table(name = "WAR_DWARFS")
public class Dwarf implements Serializable {

	private static final long serialVersionUID = -3740547296489808552L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(unique = true)
	private String name;

	@Enumerated(EnumType.STRING)
	private DwarfClass dwarfClass;

	@OneToOne(cascade = { CascadeType.ALL })
	private Stats stats;

	@OneToMany(mappedBy = "dwarf", cascade = { CascadeType.ALL,
	        CascadeType.MERGE, CascadeType.PERSIST })
	private List<Item> items;

	private String password;

	public Dwarf() {

	}

	public Dwarf(final String name, final DwarfClass dwarfClass,
	        final Stats stats, final String password) {
		this.name = name;
		this.dwarfClass = dwarfClass;
		this.stats = stats;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public DwarfClass getDwarfClass() {
		return dwarfClass;
	}

	public void setDwarfClass(final DwarfClass dwarfClass) {
		this.dwarfClass = dwarfClass;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(final List<Item> items) {
		this.items = items;
	}
}
