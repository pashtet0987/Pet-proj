package org.example.petproj.service;


import org.example.petproj.dao.MaterialsDAO;
import org.example.petproj.entity.Material;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MaterialsService {

    private final MaterialsDAO materialsDAO;

    public MaterialsService(MaterialsDAO materialsDAO) {
        this.materialsDAO = materialsDAO;
    }

    public void save(Material material) {
        Material newmaterial = materialsDAO.save(material);
    }

    public List<Material> getAllMaterials() {
        List<Material> list = materialsDAO.findAll();
        return list;
    }

    public Set<String> getMaterialsNames(){
        Set<String> materialNames = new HashSet<>();
        for(Material material: getAllMaterials()){
            materialNames.add(material.getName());
        }
        return materialNames;
    }

    public List<Material> getMaterialsByNameOrderById(String key) {
        return materialsDAO.findAllByNameOrderById(key);
    }

    public void delete(Material material){
        materialsDAO.delete(material);
    }
}
