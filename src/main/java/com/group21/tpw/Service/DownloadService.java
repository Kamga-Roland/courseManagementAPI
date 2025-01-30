package com.group21.tpw.Service;

import com.group21.tpw.Entity.DownloadEntity;
import java.util.List;

public interface DownloadService {
    DownloadEntity getById(Long id);
    List<DownloadEntity> getAll();
    DownloadEntity save(DownloadEntity downloadEntity);
    DownloadEntity update(DownloadEntity downloadEntity);
    void delete(Long id);
}
