package b.orrar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import b.orrar.dto.HuespedDTO;
import b.orrar.model.Huesped;
import b.orrar.service.impl.HuespedServiceImpl;
import lombok.RequiredArgsConstructor;

import java.net.URI;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/v1/huespedes")
@RequiredArgsConstructor
public class HuespedController {
    
    private final HuespedServiceImpl service;

    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<HuespedDTO>> listAll() {
        List<HuespedDTO> list = service.findAll().stream().map(this::convertToDto).toList();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @GetMapping(value="/{id}")
    public ResponseEntity<HuespedDTO> findById(@PathVariable Integer id) {
        HuespedDTO dto = this.convertToDto(service.findById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody HuespedDTO dto) {
        Huesped obj = service.save(this.convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    
    @PutMapping(value="/{id}")
    public ResponseEntity<HuespedDTO> update(@PathVariable Integer id, @RequestBody HuespedDTO dto) {
        dto.setId(id);
        Huesped obj = service.update(	id, this.convertToEntity(dto));
        return new ResponseEntity<>(this.convertToDto(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // HATEOAS
    @GetMapping(value="/hateoas/{id}")
    public EntityModel<HuespedDTO> findByHateoas(@PathVariable Integer id) {
        
        EntityModel<HuespedDTO> resource = EntityModel.of(this.convertToDto(service.findById(id)));

        WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).findByHateoas(id));
        WebMvcLinkBuilder link2 = linkTo(methodOn(ReservaController.class).listAll());
        resource.add(link1.withRel("huesped-info"));
        resource.add(link2.withRel("reserva-info"));
        return null;
    }
    

    // DTO
    public HuespedDTO convertToDto(Huesped obj){
        return mapper.map(obj, HuespedDTO.class);
    }
    
    public Huesped convertToEntity(HuespedDTO obj){
        return mapper.map(obj, Huesped.class);
    }
}
