package br.com.dbc.vemser.ifsultroopers.trabalhofinalmodulo3.repository;

import br.com.dbc.vemser.ifsultroopers.trabalhofinalmodulo3.entity.Users;
import br.com.dbc.vemser.ifsultroopers.trabalhofinalmodulo3.exception.BusinessRuleException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UsersRepository {
    private static List<Users> usersList = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public UsersRepository () {
        usersList.add(new Users(COUNTER.incrementAndGet(), "ana", "ana@ana.com", "12345678", false, "818.411.730-29"));
        usersList.add(new Users(COUNTER.incrementAndGet(), "nicolas", "nicoals@nicolas.com", "12345678", true, "76.161.136/0001-45"));
        usersList.add(new Users(COUNTER.incrementAndGet(), "maicon", "maicon@maicon.com", "12345678", false, "014.593.670-81"));
        usersList.add(new Users(COUNTER.incrementAndGet(), "augusto", "augusto@augusto.com", "12345678", true, "54.809.381/0001-83"));
    }

    public List<Users> list () {
        return usersList;
    }

    public Users getById (Integer id) throws BusinessRuleException {
        return list().stream()
                .filter(users -> users.getIdUser().equals(id))
                .findFirst()
                .orElseThrow(() -> new BusinessRuleException("Pessoa nao encontrada"));
    }
}
