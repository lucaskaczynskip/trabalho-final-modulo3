package br.com.dbc.vemser.ifsultroopers.trabalhofinalmodulo3.repository;

import br.com.dbc.vemser.ifsultroopers.trabalhofinalmodulo3.entity.Category;
import br.com.dbc.vemser.ifsultroopers.trabalhofinalmodulo3.exception.BusinessRuleException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class CategoryRepository {

    public List<Category> list = new ArrayList<>();
    public static AtomicInteger COUNTER = new AtomicInteger();

    // TODO - criar categorias inicias com base nas vakinhas

    public List<Category> findAll() {
        return list;
    }

    public Category findById(Integer id) throws Exception {
        return list.stream()
                .filter(category -> category.getIdCategory().equals(id))
                .findFirst()
                .orElseThrow(() -> new BusinessRuleException("Categoria não encontrada."));
    }

    public Category create(Category category) {
        category.setIdCategory(COUNTER.incrementAndGet());
        list.add(category);
        return category;
    }

    public Category update(Integer id, Category category) throws Exception {
        Category exists = this.findById(id);
        exists.setName(category.getName());
        exists.setDescription(category.getDescription());
        return category;
    }

    public Category delete(Integer id) throws Exception {
        Category category = this.findById(id);
        list.remove(category);
        return category;
    }
}
