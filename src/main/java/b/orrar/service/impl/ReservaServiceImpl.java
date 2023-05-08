package b.orrar.service.impl;

import org.springframework.stereotype.Service;

import b.orrar.model.Reserva;
import b.orrar.repository.ReservaRepo;
import b.orrar.repository.IGenericRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservaServiceImpl extends CRUDimpl<Reserva,Integer> {
    
    private final ReservaRepo repo;

    @Override
    protected IGenericRepo<Reserva, Integer> repo() {
        return repo;
    }

    
    
}
