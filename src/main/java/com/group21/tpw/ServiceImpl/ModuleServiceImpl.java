package com.group21.tpw.ServiceImpl;

import com.group21.tpw.Entity.ModuleEntity;
import com.group21.tpw.Repository.ModuleRepository;
import com.group21.tpw.Service.ModuleService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ModuleServiceImpl implements ModuleService {

    private final ModuleRepository moduleRepository;

    public ModuleServiceImpl(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    @Override
    public ModuleEntity getById(Long id) {
        return moduleRepository.getModuleById(id);
    }

    @Override
    public ModuleEntity save(ModuleEntity module) {
        return moduleRepository.save(module);
    }

    @Override
    public List<ModuleEntity> getAll() {
        return moduleRepository.findAll();
    }

    @Override
    public ModuleEntity update(ModuleEntity module) {
        return moduleRepository.save(module);
    }

    @Override
    public void deleteModuleById(Long id) {
        moduleRepository.deleteById(id);
    }
}
