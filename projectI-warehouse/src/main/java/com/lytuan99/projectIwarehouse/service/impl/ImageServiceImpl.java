package com.lytuan99.projectIwarehouse.service.impl;

import com.lytuan99.projectIwarehouse.dto.Base64Image;
import com.lytuan99.projectIwarehouse.dto.ImageDTO;
import com.lytuan99.projectIwarehouse.entity.ImageEntity;
import com.lytuan99.projectIwarehouse.entity.ProductEntity;
import com.lytuan99.projectIwarehouse.exceptions.productException.EntityNotFoundException;
import com.lytuan99.projectIwarehouse.repository.ImageRepository;
import com.lytuan99.projectIwarehouse.repository.ProductRepository;
import com.lytuan99.projectIwarehouse.service.ImageService;
import com.lytuan99.projectIwarehouse.util.DateTime;
import com.lytuan99.projectIwarehouse.util.PathResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ImageRepository imageRepository;

    @Override
    public List<ImageDTO> getAllImageByIdProduct(Long idProduct) {
        List<ImageEntity> imageEntities = imageRepository.getImageEntityByProduct_Id(idProduct);
        List<ImageDTO> imageDTOs = new ArrayList<ImageDTO>();
        for (ImageEntity imageEntity : imageEntities){
            ImageDTO imageDTO = new ImageDTO(imageEntity);
            imageDTOs.add(imageDTO);
        }
        return imageDTOs;
    }

    @Override
    public ImageDTO addImageByIdProduct(Long idProduct, Base64Image base64Image) throws IOException {
        Optional<ProductEntity> productEntity = productRepository.findById(idProduct);
        if(!productEntity.isPresent())
            throw new EntityNotFoundException(idProduct, "product");
        ImageEntity imageEntity = new ImageEntity();
        String pathImage = ProductServiceImp.decodeBase64Image(base64Image, DateTime.getDateEpochTime());
        imageEntity.setPathAndIsActive(pathImage, false);
        productEntity.get().addImage(imageEntity);
        if(productEntity.get().getImages().size() == 1)
            imageEntity.setActive(true);
        imageRepository.save(imageEntity);
        return new ImageDTO(imageEntity);
    }


    @Override
    public void deleteImageByIdProduct(Long idProduct, Long idImage) {
        Optional<ImageEntity> image = imageRepository.findById(idImage);
        if(!image.isPresent())
            throw new EntityNotFoundException(idImage, "image");
        imageRepository.deleteById(idImage);
        String pathToImage = PathResource.root + image.get().getPath() ;
        File file = new File(pathToImage);
        if(file.delete())
            System.out.println("file not found");
        System.out.println("đã xóa ảnh " + file.getName());
    }

    @Override
    public boolean changeImageActive(Long idProduct, Long idImage) {
        ImageEntity imageEntityActiveOld = imageRepository.getImageActive(idProduct, true);
        if(imageEntityActiveOld != null){
            imageEntityActiveOld.setActive(false);
            imageRepository.save(imageEntityActiveOld);
        }
        ImageEntity imageEntityActiveNew = imageRepository.getImageEntityByProduct_IdAndId(idProduct, idImage);
        if(imageEntityActiveNew == null)
            throw new EntityNotFoundException(idImage, "image");
        imageEntityActiveNew.setActive(true);
        imageRepository.save(imageEntityActiveNew);
        return true;
    }
}
