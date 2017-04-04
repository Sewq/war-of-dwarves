package pl.sewq.core.dao;

import java.util.List;

import javax.ejb.Local;

import pl.sewq.core.jpa.model.Dwarf;

@Local
public interface DwarfDao extends Dao<Dwarf, Long> {

	public Dwarf getDwarfByName(final String name);

	public List<Dwarf> getAllDwarfs();

}
