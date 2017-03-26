package pl.sewq.core.dao;

public interface Dao<D, I> {

	D read(I id);

	D update(D dto);

	void create(D dto);

	void flush();

	void delete(I id);
}
