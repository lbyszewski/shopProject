package pl.heaven_steel_and_dark_iron.lbyszewski.www.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.heaven_steel_and_dark_iron.lbyszewski.www.repository.BuyersOrdersRepository;
import pl.heaven_steel_and_dark_iron.lbyszewski.www.shopentity.BuyersOrders;


@Service
@RequiredArgsConstructor
public class BuyersService {

    private final BuyersOrdersRepository buyersOrdersRepository;


    public BuyersOrders saveEntityBuyersOrders(BuyersOrders buyersOrders) {

        return buyersOrdersRepository.save(buyersOrders);
    }

    @Transactional
    public BuyersOrders updateEntityBuyersOrders(BuyersOrders buyersOrders) {

        BuyersOrders buyersOrdersUpdater = buyersOrdersRepository.findById(buyersOrders.getOrdersShopId()).orElseThrow();
        buyersOrdersUpdater.setOrderName(buyersOrders.getOrderName());
        return buyersOrdersUpdater;
    }


    public void deleteBuyersOrders(Long buyersOrderId) {
        buyersOrdersRepository.deleteById(buyersOrderId);
    }
}
