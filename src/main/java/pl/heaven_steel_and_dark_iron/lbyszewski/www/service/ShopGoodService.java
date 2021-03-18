package pl.heaven_steel_and_dark_iron.lbyszewski.www.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.heaven_steel_and_dark_iron.lbyszewski.www.repository.MerchandiseRepository;
import pl.heaven_steel_and_dark_iron.lbyszewski.www.shopentity.Merchandise;


@Service
@RequiredArgsConstructor
public class ShopGoodService {

    private final MerchandiseRepository merchandiseRepository;

    public Merchandise saveEntityShopGoods(Merchandise merchandise) {
        return null;
    }
    @Transactional
    public Merchandise updateEntityShopGoods(Merchandise merchandise) {
        Merchandise merchandiseUpdater = merchandiseRepository.findById(merchandise.getMerchandiseShopId()).orElseThrow();

        return merchandiseUpdater;
    }

    public void deleteMerchandise(Long merchandiseId) {
        merchandiseRepository.deleteById(merchandiseId);
    }
}
