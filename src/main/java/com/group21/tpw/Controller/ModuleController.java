package com.group21.tpw.Controller;

import com.group21.tpw.Entity.ModuleEntity;
import com.group21.tpw.Service.ModuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modules")
public class ModuleController {

    private final ModuleService moduleService;

    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @GetMapping("/{moduleId}")
    public ResponseEntity<ModuleEntity> getModuleById(@PathVariable Long moduleId) {
        ModuleEntity module = moduleService.getById(moduleId);
        return ResponseEntity.ok(module);
    }

    @GetMapping
    public ResponseEntity<List<ModuleEntity>> getAllModules() {
        List<ModuleEntity> modules = moduleService.getAll();
        if (modules.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(modules);
    }

    @PostMapping
    public ResponseEntity<ModuleEntity> addModule(@RequestBody ModuleEntity module) {
        ModuleEntity moduleEntity = moduleService.save(module);
        return ResponseEntity.ok(moduleEntity);
    }

    @PutMapping("/{moduleId}")
    public ResponseEntity<ModuleEntity> updateModule(@PathVariable Long moduleId, @RequestBody ModuleEntity module) {
        ModuleEntity module1 = moduleService.getById(moduleId);
        if (module1 == null) {
            return ResponseEntity.notFound().build();
        }
        ModuleEntity moduleEntity = moduleService.update(module);
        return ResponseEntity.ok(moduleEntity);
    }

    @DeleteMapping("/{moduleId}")
    public void deleteModule(@PathVariable Long moduleId) {
        moduleService.deleteModuleById(moduleId);
    }
}
