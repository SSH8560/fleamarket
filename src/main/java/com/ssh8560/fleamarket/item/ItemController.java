package com.ssh8560.fleamarket.item;

import com.ssh8560.fleamarket.client.KakaoAddressClient;
import com.ssh8560.fleamarket.image.ImageService;
import com.ssh8560.fleamarket.item.dto.ItemImageResponse;
import com.ssh8560.fleamarket.item.dto.ItemPostRequest;
import com.ssh8560.fleamarket.item.dto.ItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    private final ImageService imageService;
    private final KakaoAddressClient client;

    @GetMapping("/{itemId}")
    public ResponseEntity<ItemResponse> getItem(
        @PathVariable(name = "itemId") Long itemId
    ) {
        ItemResponse item = itemService.getItem(itemId);

        return ResponseEntity.ok(item);
    }

    @PostMapping
    public ResponseEntity<String> postItem(
        Authentication authentication,
        @RequestBody ItemPostRequest request) {
        Long savedId = itemService.saveItem(authentication.getName(), request);

        return ResponseEntity.created(URI.create("/items/" + savedId)).build();
    }

    @GetMapping("/{itemId}/images")
    public ResponseEntity<ItemImageResponse> getItemImages(
        @PathVariable(name = "itemId") Long itemId
    ) {
        ItemImageResponse response = imageService.getImagesUrl(itemId);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/{itemId}/images")
    public ResponseEntity<Integer> postItemImages(
        @PathVariable(name = "itemId") Long itemId,
        @RequestParam(name = "images") List<MultipartFile> images
    ) {
        int uploadedImageCount = imageService.saveImages(itemId, images);

        return ResponseEntity.status(HttpStatus.CREATED).body(uploadedImageCount);
    }
}
