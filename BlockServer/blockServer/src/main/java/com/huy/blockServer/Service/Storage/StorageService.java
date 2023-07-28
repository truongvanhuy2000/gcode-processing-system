package com.huy.blockServer.Service.Storage;


import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public interface StorageService {
    void init();
    void store(MultipartFile multipartFile);

}
