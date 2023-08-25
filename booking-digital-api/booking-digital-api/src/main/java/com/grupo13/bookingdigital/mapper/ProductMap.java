package com.grupo13.bookingdigital.mapper;

import com.grupo13.bookingdigital.auth.model.UserEntity;
import com.grupo13.bookingdigital.auth.repository.UserRepository;
import com.grupo13.bookingdigital.dto.ProductDto;
import com.grupo13.bookingdigital.exception.ParamNotFound;
import com.grupo13.bookingdigital.model.ProductEntity;
import com.grupo13.bookingdigital.repository.CategoryRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMap {

  @Autowired
  private PolicyMap policyMap;
  @Autowired
  private CharacteristicMap characteristicMap;
  @Autowired
  private ImageMap imageMap;
  @Autowired
  private LocationMap locationMap;
  @Autowired
  private CategoryRepository categoryRepository;
  @Autowired
  private BookingMap bookingMap;
  @Autowired
  private UserRepository userRepository;



  public ProductEntity productDto2Entity(ProductDto dto){
    ProductEntity entity = new ProductEntity();
    entity.setName(dto.getName());
    entity.setDescriptionCard(dto.getDescriptionCard());
    entity.setDescriptionPage(dto.getDescriptionPage());
    entity.setPrice(dto.getPrice());
    entity.setCategory(categoryRepository.findById(dto.getCategoryId()).orElseThrow(() -> new ParamNotFound("Product not found")));
    entity.setPolicy(policyMap.policyDto2Entity(dto.getPolicy()));
    entity.setCharacteristic(characteristicMap.characteristicDto2Entity(dto.getCharacteristic()));
    entity.setImage(imageMap.imageDto2Entity(dto.getImage()));
    entity.setLocation(locationMap.locationDto2Entity(dto.getLocation()));
    UserEntity user = userRepository.findByEmail(dto.getUserEmail()).get();
    entity.setUser(user);
    return entity;
  }

 public ProductDto productEntity2Dto(ProductEntity entity){
    ProductDto productDto = new ProductDto();
    productDto.setId(entity.getId());
    productDto.setName(entity.getName());
    productDto.setDescriptionCard(entity.getDescriptionCard());
    productDto.setDescriptionPage(entity.getDescriptionPage());
    productDto.setPrice(entity.getPrice());
    productDto.setCategoryId(entity.getCategory().getId());
    productDto.setPolicy(policyMap.policyEntity2Dto(entity.getPolicy()));
    productDto.setCharacteristic(characteristicMap.characteristicEntity2Dto(entity.getCharacteristic()));
    productDto.setImage(imageMap.imageEntity2Dto(entity.getImage()));
    productDto.setLocation(locationMap.locationEntity2Dto(entity.getLocation()));
    productDto.setBookings(bookingMap.bookingListEntity2DtoList(entity.getBookings()));
    return productDto;
  }

  public List<ProductDto> productEntityList2DtoList(List<ProductEntity> products) {
    List<ProductDto> productDtoList = new ArrayList<>();
    for (ProductEntity product : products){
      productDtoList.add(productEntity2Dto(product));
    }
    return productDtoList;
  }
}
