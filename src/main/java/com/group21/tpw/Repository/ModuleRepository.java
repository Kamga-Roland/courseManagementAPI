package com.group21.tpw.Repository;

import com.group21.tpw.Entity.ModuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends JpaRepository<ModuleEntity, Long> {
    ModuleEntity getModuleById(Long id);
}
