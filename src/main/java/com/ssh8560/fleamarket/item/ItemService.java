package com.ssh8560.fleamarket.item;

import com.ssh8560.fleamarket.repository.JpaItemRepository;
import com.ssh8560.fleamarket.repository.JpaUserInfoRepository;
import com.ssh8560.fleamarket.client.KakaoAddressClient;
import com.ssh8560.fleamarket.config.client.AddressResponse;
import com.ssh8560.fleamarket.entity.Item;
import com.ssh8560.fleamarket.entity.Location;
import com.ssh8560.fleamarket.item.dto.ItemPostRequest;
import com.ssh8560.fleamarket.item.dto.ItemResponse;
import com.ssh8560.fleamarket.location.JpaLocationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {
    private final KakaoAddressClient addressClient;
    private final JpaItemRepository itemRepository;
    private final JpaUserInfoRepository userInfoRepository;
    private final JpaLocationRepository locationRepository;

    public ItemResponse getItem(Long itemId) {
        Item item = itemRepository.findById(itemId).orElseThrow(EntityNotFoundException::new);

        return new ItemResponse(item);
    }

    public Long saveItem(String userInfoId, ItemPostRequest request) {
        Item item = new Item(userInfoRepository.getReferenceById(userInfoId), request.getTitle(), request.getCategory(), request.getContent(), request.getPrice());
        Item savedItem = itemRepository.save(item);
        saveLocation(savedItem.getId(), request);

        return savedItem.getId();
    }

    private void saveLocation(Long itemId, ItemPostRequest request) {
        AddressResponse addressResponse = addressClient.requestAddress(request.getX(), request.getY());
        AddressResponse.Document document = addressResponse.getDocuments().get(0);
        AddressResponse.Address address = document.getAddress();

        Location location = new Location(itemId,
            request.getX(),
            request.getY(),
            address.getAddressName(),
            address.getRegion1depthName(),
            address.getRegion2depthName(),
            address.getRegion3depthName(),
            request.getLocationDetail());

        locationRepository.save(location);
    }
}
