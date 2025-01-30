package com.group21.tpw.Service;

import com.group21.tpw.Entity.ModuleEntity;
import java.util.List;

public interface ModuleService {
    ModuleEntity getById(Long id);
    ModuleEntity save(ModuleEntity module);
    List<ModuleEntity> getAll();
    ModuleEntity update(ModuleEntity module);
    void deleteModuleById(Long id);
}
