package com.ssh8560.fleamarket.domain.item;

import com.ssh8560.fleamarket.domain.item.dto.ItemPostRequest;
import com.ssh8560.fleamarket.domain.item.dto.ItemResponse;
import com.ssh8560.fleamarket.repository.ItemRepository;
import com.ssh8560.fleamarket.repository.JpaItemRepository;
import com.ssh8560.fleamarket.repository.JpaUserInfoRepository;
import com.ssh8560.fleamarket.client.KakaoAddressClient;
import com.ssh8560.fleamarket.client.RegionResponse;
import com.ssh8560.fleamarket.entity.Item;
import com.ssh8560.fleamarket.entity.Location;
import com.ssh8560.fleamarket.domain.location.JpaLocationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {
    private final KakaoAddressClient addressClient;
    private final JpaItemRepository jpaItemRepository;
    private final ItemRepository queryDslItemRepository;
    private final JpaUserInfoRepository userInfoRepository;
    private final JpaLocationRepository locationRepository;

    public List<ItemResponse> getItems() {
        List<Item> all = jpaItemRepository.findAll();

        return all.stream().map(ItemResponse::new).collect(Collectors.toList());
    }

    public List<ItemResponse> getByParams(
        String gu, String dong
    ){
        return queryDslItemRepository.findByParams(gu,dong).stream().map(ItemResponse::new).collect(Collectors.toList());
    }

    public ItemResponse getItem(Long itemId) {
        Item item = jpaItemRepository.findById(itemId).orElseThrow(EntityNotFoundException::new);

        return new ItemResponse(item);
    }

    public Long saveItem(String userInfoId, ItemPostRequest request) {
        Item item = new Item(userInfoRepository.getReferenceById(userInfoId), request.getTitle(),  request.getContent(), request.getPrice());
        Item savedItem = jpaItemRepository.save(item);
        saveLocation(savedItem.getId(), request);

        return savedItem.getId();
    }

    private void saveLocation(Long itemId, ItemPostRequest request) {
        List<RegionResponse.Address> addressList = addressClient.getRegion(request.getX(), request.getY()).getAddresses().stream()
            .filter(e -> e.getRegionType().equals("H"))
            .toList();

        if(addressList.size() == 0){
            throw new EntityNotFoundException();
        }

        RegionResponse.Address address = addressList.get(0);

        Location location = new Location(
            itemId,
            request.getLocationDetail(),
            request.getX(),
            request.getY(),
            address
        );

        locationRepository.save(location);
    }
}
