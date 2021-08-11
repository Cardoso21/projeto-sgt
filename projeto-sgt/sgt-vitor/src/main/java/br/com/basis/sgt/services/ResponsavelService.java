package br.com.basis.sgt.services;

import br.com.basis.sgt.dtos.ResponsavelDTO;
import br.com.basis.sgt.entities.Responsavel;
import br.com.basis.sgt.mapstruct.ResponsavelMapper;
import br.com.basis.sgt.repositories.ResponsavelRepository;
import br.com.basis.sgt.services.exceptions.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResponsavelService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResponsavelService.class);

    @Autowired
    private ResponsavelRepository repository;

    @Autowired
    private ResponsavelMapper responsavelMapper;

    @Transactional(readOnly = true)
    public ResponsavelDTO findById(Long id) {
        Optional<Responsavel> responsavel = repository.findById(id);
        Responsavel entity = responsavel.orElseThrow(() -> new ObjectNotFoundException("Responsavel não encontrado"));
        ResponsavelDTO dto = responsavelMapper.ToDto(entity);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<ResponsavelDTO> findAll() {
        List<Responsavel> list = repository.findAll();
        List<ResponsavelDTO> pageDTO = list.stream().map(r -> responsavelMapper.ToDto(r)).collect(Collectors.toList());
        return pageDTO;
    }

    @Transactional
    public ResponsavelDTO salvar(ResponsavelDTO dto) {
        Responsavel entity = responsavelMapper.ToEntity(dto);
        entity = repository.save(entity);
        LOGGER.info(entity.toString());
        ResponsavelDTO responsavelDTO = responsavelMapper.ToDto(entity);
        return responsavelDTO;
    }


    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }catch ( EmptyResultDataAccessException e) {
            throw new ObjectNotFoundException("Responsavel não encontrado");
        }
    }

}
