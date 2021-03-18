package pl.heaven_steel_and_dark_iron.lbyszewski.www.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.heaven_steel_and_dark_iron.lbyszewski.www.repository.MerchandiseRepository;
import pl.heaven_steel_and_dark_iron.lbyszewski.www.repository.ProductWarehouseRepository;
import pl.heaven_steel_and_dark_iron.lbyszewski.www.shopentity.Merchandise;
import pl.heaven_steel_and_dark_iron.lbyszewski.www.shopentity.ProductWarehouse;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class GoodService {

    private final ProductWarehouseRepository productWarehouseRepository;
    private final MerchandiseRepository merchandiseRepository;

    public ProductWarehouse saveEntityGoods(ProductWarehouse productWarehouse) {
        return productWarehouseRepository.save(productWarehouse);
    }
    @Transactional
    public ProductWarehouse updateEntityGoods(ProductWarehouse productWarehouse) {
        ProductWarehouse productWarehouseUpdater = productWarehouseRepository.findById(productWarehouse.getProductWarehouseId()).orElseThrow();

        return productWarehouseUpdater;
    }

    public void deleteProductWareHouse(Long productWarehouseId) {
        productWarehouseRepository.deleteById(productWarehouseId);
    }
}
