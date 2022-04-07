package com.ksprogramming.model;

import java.sql.Connection;
import java.util.List;

public class ModelService {
    private Connection connection;
    private ModelRepository modelRepository;

    public ModelService(Connection connection) {
        this.connection = connection;
        modelRepository = new ModelRepository(connection);
    }

    public Model getId(Integer id){
        return modelRepository.getId(id);
    }

    public List<Model> find(Model model){
        return modelRepository.find(model);
    }

    public Integer create(Model model){
        return modelRepository.create(model);
    }

    public void update(Integer id, Model model){
        modelRepository.update(id, model);
    }

    public void remove(Integer id){
        modelRepository.remove(id);
    }
}
