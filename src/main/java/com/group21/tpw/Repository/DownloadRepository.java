package com.group21.tpw.Repository;

import com.group21.tpw.Entity.DownloadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DownloadRepository extends JpaRepository<DownloadEntity, Long> {
    DownloadEntity getDownloadEntityById(Long id);
}
