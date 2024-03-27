package com.ssh8560.fleamarket.domain.item.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class ItemImagePostRequest {
    List<MultipartFile> images;
}
