package pl.sewq.model.dwarf;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WAR_STATS")
public class Stats implements Serializable {

	private static final long serialVersionUID = 6092879315333443119L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int str;
	private int agi;
	private int inte;

	public Stats() {

	}

	public Stats(final int str, final int agi, final int inte) {
		this.str = str;
		this.agi = agi;
		this.inte = inte;
	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public int getStr() {
		return str;
	}

	public void setStr(final int str) {
		this.str = str;
	}

	public int getAgi() {
		return agi;
	}

	public void setAgi(final int agi) {
		this.agi = agi;
	}

	public int getInte() {
		return inte;
	}

	public void setInte(final int inte) {
		this.inte = inte;
	}

}
