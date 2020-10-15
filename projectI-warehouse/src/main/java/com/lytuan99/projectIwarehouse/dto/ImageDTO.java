package com.lytuan99.projectIwarehouse.dto;

import com.lytuan99.projectIwarehouse.entity.ImageEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ImageDTO extends  AbstractDTO {
    private Long id;
    private String path;
    private boolean isActive;



    public ImageDTO(String path) {
        this.path = path;
    }

    public ImageDTO(ImageEntity imageEntity){
        this.id  = imageEntity.getId();
        this.path = imageEntity.getPath();
        this.isActive = imageEntity.isActive();
    }


    public ImageDTO(Long id, String path){
        this.id = id;
        this.path = path;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ImageDTO(Long id) {
        this.id = id;
    }
}
