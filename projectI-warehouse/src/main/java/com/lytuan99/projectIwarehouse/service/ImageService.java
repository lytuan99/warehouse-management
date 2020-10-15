package com.lytuan99.projectIwarehouse.service;


import com.lytuan99.projectIwarehouse.dto.Base64Image;
import com.lytuan99.projectIwarehouse.dto.ImageDTO;

import java.io.IOException;
import java.util.List;

public interface ImageService {

    List<ImageDTO> getAllImageByIdProduct(Long idProduct);
    ImageDTO addImageByIdProduct(Long idProduct, Base64Image base64Image) throws IOException;
    void deleteImageByIdProduct(Long idProduct, Long idImage);
    boolean changeImageActive(Long idProduct, Long idImage);

}
