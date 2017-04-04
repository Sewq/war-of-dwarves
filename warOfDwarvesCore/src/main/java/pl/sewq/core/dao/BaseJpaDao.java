package pl.sewq.core.dao;

import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class BaseJpaDao {

	@PersistenceContext
	private EntityManager entityManager;

	public final EntityManager getEntityManager() {
		return entityManager;
	}

	protected final Query prepareQuery(final String query,
	        final Map<String, Object> params) {
		final Query q = getEntityManager().createQuery(query);
		setQueryParameters(q, params);
		return q;
	}

	protected final Query prepareNamedQuery(final String query,
	        final Map<String, Object> params) {
		final Query q = getEntityManager().createNamedQuery(query);
		setQueryParameters(q, params);
		return q;
	}

	private void setQueryParameters(final Query query,
	        final Map<String, Object> params) {
		if ((params != null) && !params.isEmpty()) {
			for (final Entry<String, Object> entry : params.entrySet()) {
				query.setParameter(entry.getKey(), entry.getValue());
			}
		}
	}
}
