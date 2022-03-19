package br.com.dbc.vemser.ifsultroopers.trabalhofinalmodulo3.service;

import br.com.dbc.vemser.ifsultroopers.trabalhofinalmodulo3.dto.userdto.UsersDTO;
import br.com.dbc.vemser.ifsultroopers.trabalhofinalmodulo3.exception.BusinessRuleException;
import br.com.dbc.vemser.ifsultroopers.trabalhofinalmodulo3.repository.UsersRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public List<UsersDTO> list () {
        return usersRepository.list().stream()
                .map(users -> objectMapper.convertValue(users, UsersDTO.class))
                .toList();
    }

    public UsersDTO getById (Integer id) throws BusinessRuleException {
        return objectMapper.convertValue(usersRepository.getById(id), UsersDTO.class);
    }
}
