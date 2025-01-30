package com.group21.tpw.Controller;

import com.group21.tpw.Entity.DownloadEntity;
import com.group21.tpw.Service.DownloadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/download")
public class DownloadController {

    private final DownloadService downloadService;

    public DownloadController(DownloadService downloadService) {
        this.downloadService = downloadService;
    }

    @GetMapping("{downloadId}")
    public ResponseEntity<DownloadEntity> getDownloadById(@PathVariable Long downloadId) {
        DownloadEntity download = this.downloadService.getById(downloadId);
        if (download == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(download);
    }

    @GetMapping
    public ResponseEntity<List<DownloadEntity>> getAllDownloads() {
        List<DownloadEntity> downloads = downloadService.getAll();
        return ResponseEntity.ok(downloads);
    }

    @PostMapping
    public ResponseEntity<DownloadEntity> saveDownload(@RequestBody DownloadEntity download) {
        return ResponseEntity.ok(this.downloadService.save(download));
    }

    @PutMapping("/{downloadId}")
    public ResponseEntity<DownloadEntity> updateDownload(@PathVariable Long downloadId,@RequestBody DownloadEntity download) {
        DownloadEntity downloadEntity = this.downloadService.getById(downloadId);
        if (downloadEntity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(this.downloadService.update(download));
    }

    @DeleteMapping("/{downloadId}")
    public void deleteDownload(@PathVariable Long downloadId) {
        this.downloadService.delete(downloadId);
    }
}
