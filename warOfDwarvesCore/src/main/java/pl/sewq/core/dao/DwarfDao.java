package pl.sewq.core.dao;

import javax.ejb.Local;

import pl.sewq.core.jpa.model.Dwarf;

@Local
public interface DwarfDao extends Dao<Dwarf, Long> {

}
