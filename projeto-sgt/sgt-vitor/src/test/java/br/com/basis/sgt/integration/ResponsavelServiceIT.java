package br.com.basis.sgt.integration;

import br.com.basis.sgt.dtos.ResponsavelDTO;
import br.com.basis.sgt.services.ResponsavelService;
import br.com.basis.sgt.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@Transactional
public class ResponsavelServiceIT {


    @Autowired
    private ResponsavelService service;

    private long idExistente;
    private long idNaoExistente;
    private int qtdResponsavel;

    private PageRequest pageRequest;

    @BeforeEach
    void setUp() throws  Exception{
        idExistente = 1L;
        idNaoExistente = 1000L;
        pageRequest = PageRequest.of(0, 10, Sort.Direction.ASC, "nome");
        qtdResponsavel = 3;
    }

    @Test
    public void deleteDeveriaLancarObjectNotFoundExceptionCasoIdNaoExista(){
        Assertions.assertThrows(ObjectNotFoundException.class, ()->{
            service.delete(idNaoExistente);
        });
    }

    @Test
    public void deleteDeveriaNaoFazerNadaCasoIdExistente(){
        Assertions.assertDoesNotThrow(() ->{
            service.delete(idExistente);
        });
    }

    @Test
    public void findByIdDeveriaLancaObjectNotFoundExceptionCasoIdNaoExista(){
        Assertions.assertThrows(ObjectNotFoundException.class, () -> {
            service.findById(idNaoExistente);
        });
    }

    @Test
    public void findByIdDeveriaTrazerResponsavelQuandoIdExiste(){
        ResponsavelDTO dto = service.findById(idExistente);
        Assertions.assertNotNull(dto);
    }

    @Test
    public void findAllPageDeveriaTrazerResponsavel(){
        List<ResponsavelDTO> list = service.findAll();
        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(qtdResponsavel, list.size());
    }

    @Test
    public void salvaDeveriaPersistirNovaEntidadeComIdAutoIncrementavel(){
        ResponsavelDTO res = criaResponsavel();

        res.setId(null);
        res = service.salvar(res);
        ResponsavelDTO result = service.findById(res.getId());

        Assertions.assertNotNull(res.getId());

    }

    private ResponsavelDTO criaResponsavel(){
        ResponsavelDTO dto = new ResponsavelDTO();
        dto.setNome("Wanderson");
        dto.setEmail("wanderson@gmail.com");
        dto.setTarefas(new ArrayList<>());
        return dto;
    }


}
