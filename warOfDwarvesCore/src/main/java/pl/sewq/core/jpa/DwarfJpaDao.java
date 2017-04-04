package pl.sewq.core.jpa;

import java.util.List;

import javax.ejb.Stateless;

import com.google.common.collect.ImmutableMap;

import pl.sewq.core.dao.DwarfDao;
import pl.sewq.core.dao.JpaDao;
import pl.sewq.core.jpa.model.Dwarf;

@Stateless
public class DwarfJpaDao extends JpaDao<Dwarf, Long> implements DwarfDao {

	@Override
	public Dwarf getDwarfByName(final String name) {
		return findSingle(Dwarf.GET_DWARF_BY_NAME,
		        ImmutableMap.<String, Object> of("name", name));
	}

	@Override
	public List<Dwarf> getAllDwarfs() {
		return find(Dwarf.GET_DWARFS, null);
	}

}
