package br.com.dbc.vemser.ifsultroopers.trabalhofinalmodulo3.repository;

import br.com.dbc.vemser.ifsultroopers.trabalhofinalmodulo3.dto.request.RequestUpdateDTO;
import br.com.dbc.vemser.ifsultroopers.trabalhofinalmodulo3.entity.Request;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class RequestRepository {

    public static List<Request> list = new ArrayList<>();
    public static AtomicInteger COUNTER = new AtomicInteger();

    public List<Request> getAll() {
        return list;
    }

    public Request getById(Integer id) throws Exception {
        return list.stream()
                .filter(request -> request.getIdRequest().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Vakinha não encontrada."));
    }

    // TODO - adicionar o get do User
    public Request create(Integer id, Request request) {
        request.setIdUser(id);
        request.setReachedValue(0.0);
        list.add(request);
        return request;
    }

    public Request update(Integer id, RequestUpdateDTO newData) throws Exception {
        Request request = this.getById(id);

        String updatedTitle = newData.getTitle();
        String updatedDescription = newData.getDescription();
        Double updatedGoal = newData.getGoal();

        if (updatedTitle != null) {
            request.setTitle(updatedTitle);
        }

        if (updatedDescription != null) {
            request.setDescription(updatedDescription);
        }

        if (updatedGoal != null) {
            request.setGoal(updatedGoal);
        }

        return request;
    }

    public Request delete(Integer id) throws Exception {
        Request request = this.getById(id);
        list.remove(request);
        return request;
    }

    public List<Request> deleteAll(Integer id) throws Exception {
        List<Request> removeds = new ArrayList<>();
        list.stream()
                .filter(request -> request.getIdUser().equals(id))
                .forEach(request -> list.add(request));
        list.removeAll(removeds);
        return removeds;
    }
}
