package br.com.dbc.vemser.ifsultroopers.trabalhofinalmodulo3.service;

import br.com.dbc.vemser.ifsultroopers.trabalhofinalmodulo3.dto.DonateCreateDTO;
import br.com.dbc.vemser.ifsultroopers.trabalhofinalmodulo3.dto.DonateDTO;
import br.com.dbc.vemser.ifsultroopers.trabalhofinalmodulo3.entity.Donate;
import br.com.dbc.vemser.ifsultroopers.trabalhofinalmodulo3.repository.DonateRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonateService {
    @Autowired
    private DonateRepository donateRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public DonateDTO create(DonateCreateDTO donateCreate) throws Exception {

        Donate donate = objectMapper.convertValue(donateCreate, Donate.class);
        Donate donateCreated = donateRepository.create(donate);
        DonateDTO donateDTO = objectMapper.convertValue(donateCreated, DonateDTO.class);

        return donateDTO;
    }

    public DonateDTO update(Integer id,
                            DonateDTO donateUpdate) throws Exception {
        Donate pessoa = objectMapper.convertValue(donateUpdate, Donate.class);
        donateRepository.update(id, pessoa);
        return donateUpdate;
    }

    public List<DonateDTO>list(){
        return donateRepository.list()
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, DonateDTO.class))
                .collect(Collectors.toList());
    }

    public DonateDTO getDonateById(Integer id) throws Exception {
        Donate donate= donateRepository.getDonataById(id);
        DonateDTO donateDTO = objectMapper.convertValue(donate, DonateDTO.class);
        return  donateDTO;
    }

    public DonateDTO delete(Integer id) throws Exception {
        Donate donate = donateRepository.delete(id);
        DonateDTO donateDTO = objectMapper.convertValue(donate, DonateDTO.class);
        return donateDTO;
    }
}