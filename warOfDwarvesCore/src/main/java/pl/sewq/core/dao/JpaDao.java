package pl.sewq.core.dao;

import java.lang.reflect.ParameterizedType;

public class JpaDao<D, I> extends BaseJpaDao implements Dao<D, I> {
	private final Class<D> entity;

	@SuppressWarnings("unchecked")
	protected JpaDao() {
		this.entity = (Class<D>) ((ParameterizedType) getClass()
		        .getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public D read(final I id) {
		return getEntityManager().find(entity, id);
	}

	@Override
	public D update(final D dto) {
		return getEntityManager().merge(dto);
	}

	@Override
	public void flush() {
		getEntityManager().flush();
	}

	@Override
	public void delete(final I id) {
		getEntityManager().remove(getEntityManager().find(entity, id));

	}

	@Override
	public void create(final D dto) {
		getEntityManager().persist(dto);
	}

}
