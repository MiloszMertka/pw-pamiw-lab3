package com.example.client.service.internal;

import com.example.client.model.Engine;
import com.example.client.service.EngineService;

import java.util.List;

public class EngineServiceImpl implements EngineService {

    private static final String BASE_URL = "http://localhost:8080/api/engines";
    private final CrudService<Engine> crudService = new CrudService<>();

    @Override
    public List<Engine> getAllEngines() {
        return crudService.getAll(BASE_URL, Engine.class);
    }

    @Override
    public void createEngine(Engine engine) {
        crudService.create(BASE_URL, engine);
    }

    @Override
    public void updateEngine(Long id, Engine engine) {
        crudService.update(BASE_URL + "/" + id, engine);
    }

    @Override
    public void deleteEngine(Long id) {
        crudService.delete(BASE_URL + "/" + id);
    }

}
