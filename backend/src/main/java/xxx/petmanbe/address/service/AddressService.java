package xxx.petmanbe.address.service;

import xxx.petmanbe.shop.entity.Shop;

import java.util.List;

public interface AddressService {

    public List<Shop> GetShopbyMap(String sidoName, String gugunName);
}
