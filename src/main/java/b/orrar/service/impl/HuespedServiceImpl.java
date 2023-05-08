package b.orrar.service.impl;

import org.springframework.stereotype.Service;

import b.orrar.model.Huesped;
import b.orrar.repository.HuespedRepo;
import b.orrar.repository.IGenericRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HuespedServiceImpl extends CRUDimpl<Huesped,Integer> {
    
    private final HuespedRepo repo;

    @Override
    protected IGenericRepo<Huesped, Integer> repo() {
        return repo;
    }

    
    
}
