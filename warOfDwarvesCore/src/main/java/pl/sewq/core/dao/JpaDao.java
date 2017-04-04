package pl.sewq.core.dao;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;

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

	protected Class<D> getEntityClass() {
		return entity;
	}

	protected D findSingle(final String queryName,
	        final Map<String, Object> params) {
		return findSingle(queryName, getEntityClass(), params);
	}

	protected List<D> find(final String queryName,
	        final Map<String, Object> params) {
		return find(queryName, getEntityClass(), params);
	}

	@SuppressWarnings("unchecked")
	protected <T> T findSingle(final String queryName,
	        final Class<T> returnType, final Map<String, Object> params) {
		try {
			return (T) prepareNamedQuery(queryName, params).getSingleResult();
		} catch (final NoResultException ex) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	protected <T> List<T> find(final String queryName,
	        final Class<T> entityClass, final Map<String, Object> params) {
		try {
			return prepareNamedQuery(queryName, params).getResultList();
		} catch (final NoResultException ex) {
			return Collections.EMPTY_LIST;
		}
	}
}
