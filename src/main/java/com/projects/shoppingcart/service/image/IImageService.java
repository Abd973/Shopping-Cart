package com.projects.shoppingcart.service.image;

import com.projects.shoppingcart.dto.ImageDto;
import com.projects.shoppingcart.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IImageService {
    List<ImageDto> saveImages(List<MultipartFile> files, Long productId);
    Image getImageById(Long id);
    void deleteImageById(Long id);
    void updateImage(MultipartFile file, Long imageId);

}
