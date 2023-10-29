package com.example.client.service.internal;

import com.example.client.model.EquipmentOption;
import com.example.client.service.EquipmentOptionService;

import java.util.List;

public class EquipmentOptionServiceImpl implements EquipmentOptionService {

    private static final String BASE_URL = "http://localhost:8080/api/equipment-options";
    private final CrudService<EquipmentOption> crudService = new CrudService<>();

    @Override
    public List<EquipmentOption> getAllEquipmentOptions() {
        return crudService.getAll(BASE_URL, EquipmentOption.class);
    }

    @Override
    public void createEquipmentOption(EquipmentOption equipmentOption) {
        crudService.create(BASE_URL, equipmentOption);
    }

    @Override
    public void updateEquipmentOption(Long id, EquipmentOption equipmentOption) {
        crudService.update(BASE_URL + "/" + id, equipmentOption);
    }

    @Override
    public void deleteEquipmentOption(Long id) {
        crudService.delete(BASE_URL + "/" + id);
    }

}
