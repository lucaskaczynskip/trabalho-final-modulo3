package br.com.dbc.vemser.ifsultroopers.trabalhofinalmodulo3.repository;

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

    public Request create(Integer id, Request request) {
        request.setIdUser(id);
        list.add(request);
        return request;
    }

    public Request update(Integer id, Request newData) throws Exception {
        Request request = this.getById(id);
        newData.setIdRequest(id);
        newData.setIdUser(request.getIdUser());
        list.add(list.indexOf(request), newData);
        list.remove(request);
        return newData;
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
