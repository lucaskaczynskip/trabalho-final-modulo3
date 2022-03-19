package br.com.dbc.vemser.ifsultroopers.trabalhofinalmodulo3.service;

import br.com.dbc.vemser.ifsultroopers.trabalhofinalmodulo3.dto.userdto.UsersCreateDTO;
import br.com.dbc.vemser.ifsultroopers.trabalhofinalmodulo3.dto.userdto.UsersDTO;
import br.com.dbc.vemser.ifsultroopers.trabalhofinalmodulo3.entity.Users;
import br.com.dbc.vemser.ifsultroopers.trabalhofinalmodulo3.exception.BusinessRuleException;
import br.com.dbc.vemser.ifsultroopers.trabalhofinalmodulo3.repository.UsersRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
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

    @Validated
    public UsersDTO create (UsersCreateDTO usersCreateDTO) {
//        if (usersCreateDTO.getType()){
//            CNPJDocument cnpjDocument = new CNPJDocument(usersCreateDTO.getDocument());
//            cnpjTest(@Valid cnpjDocument);
//        } else {
//            @Valid
//            CPFDocument cpfDocument = new CPFDocument(usersCreateDTO.getDocument());
//        }

        return objectMapper.convertValue(usersRepository.create(objectMapper.convertValue(usersCreateDTO, Users.class)), UsersDTO.class);
    }

    public UsersDTO update (Integer id, UsersCreateDTO usersCreateDTO) throws BusinessRuleException {
        if (usersCreateDTO.getType()){
            @Valid @CNPJ
            String s = usersCreateDTO.getDocument();
        } else {
            @Valid @CPF
            String s = usersCreateDTO.getDocument();
        }

        return objectMapper.convertValue(usersRepository.update(id, objectMapper.convertValue(usersCreateDTO, Users.class)), UsersDTO.class);
    }

    public UsersDTO delete (Integer id) throws BusinessRuleException {
        return objectMapper.convertValue(usersRepository.delete(id), UsersDTO.class);
    }

    private void cpfTest(CPFDocument cpfDocument) {

    }
    private void cnpjTest(CNPJDocument cpfDocument) {

    }

    @Data
    @AllArgsConstructor
    private class CPFDocument {
        @CPF
        private String cpf;
    }

    @Data
    @AllArgsConstructor
    private class CNPJDocument {
        @CNPJ
        private String cnpj;
    }
}
