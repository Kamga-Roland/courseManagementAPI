package com.group21.tpw.ServiceImpl;

import com.group21.tpw.Entity.DownloadEntity;
import com.group21.tpw.Repository.DownloadRepository;
import com.group21.tpw.Service.DownloadService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DownloadServiceImpl implements DownloadService {

    private final DownloadRepository downloadRepository;

    public DownloadServiceImpl(DownloadRepository downloadRepository) {
        this.downloadRepository = downloadRepository;
    }

    @Override
    public DownloadEntity getById(Long id) {
        return downloadRepository.getDownloadEntityById(id);
    }

    @Override
    public List<DownloadEntity> getAll() {
        return downloadRepository.findAll();
    }

    @Override
    public DownloadEntity save(DownloadEntity downloadEntity) {
        return downloadRepository.save(downloadEntity);
    }

    @Override
    public DownloadEntity update(DownloadEntity downloadEntity) {
        return downloadRepository.save(downloadEntity);
    }

    @Override
    public void delete(Long id) {
        downloadRepository.deleteById(id);
    }
}
