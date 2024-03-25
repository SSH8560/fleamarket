package com.ssh8560.fleamarket.image;

import com.ssh8560.fleamarket.repository.JpaImageRepository;
import com.ssh8560.fleamarket.client.CloudImageClient;
import com.ssh8560.fleamarket.config.Constants;
import com.ssh8560.fleamarket.entity.Image;
import com.ssh8560.fleamarket.item.dto.ItemImageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ImageService {
    private final JpaImageRepository imageRepository;
    private final CloudImageClient cloudImageClient;

    public int saveImages(Long itemId, List<MultipartFile> images) {
        for (MultipartFile image : images) {
            String key = cloudImageClient.uploadImage(image);
            imageRepository.save(new Image(key, itemId));
        }

        return images.size();
    }

    public ItemImageResponse getImagesUrl(Long itemId){
        List<String> list = imageRepository.findByItemId(itemId).stream()
            .map(image -> Constants.CLOUD_IMAGE_URL + image.getId())
            .toList();

        return new ItemImageResponse(list);
    }
}
