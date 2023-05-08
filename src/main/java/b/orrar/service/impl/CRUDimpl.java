package b.orrar.service.impl;

import java.util.List;

import b.orrar.exceptions.ModelNotFoundException;
import b.orrar.repository.IGenericRepo;
import b.orrar.service.ICRUD;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class CRUDimpl<T, I> implements ICRUD<T, I> {

    protected abstract IGenericRepo<T, I> repo();
    protected static final String msg = "ID WAS NOT FOUND";

    @Override
    public List<T> findAll() {
        
        return repo().findAll();
    }

    @Override
    public T findById(I id) {
        
        return repo().findById(id).orElseThrow(() -> new ModelNotFoundException(msg + id));
    }

    @Override
    public T save(T t) {
        return repo().save(t);
    }

    @Override
    public T update(I id, T t) {
        repo().findById(id).orElseThrow(() -> new ModelNotFoundException(msg + id));
        return repo().save(t);
    }

    @Override
    public void delete(I id) {
        repo().findById(id).orElseThrow(() -> new ModelNotFoundException(msg + id));
        repo().deleteById(id);

    }
}
