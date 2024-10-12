package com.dietbuilder.domain.daos;

import com.dietbuilder.domain.exceptions.ComestibleProductNotFoundException;
import com.dietbuilder.domain.model.comestible_product.ComestibleProduct;
import com.dietbuilder.domain.repositories.ComestibleProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
@AllArgsConstructor
public class ComestibleProductDao {

    private ComestibleProductRepository comestibleProductRepository;

    public ComestibleProduct get(long id) {
        Optional<ComestibleProduct> optional = comestibleProductRepository.findById(id);

        if (optional.isPresent()) {
            log.info("Comestible product with id: " + id + " has been found");
            return optional.get();
        } else {
            throw new ComestibleProductNotFoundException("Cannot find ComestibleProduct with id: " + id);
        }
    }

    public List<ComestibleProduct> getAllByName(String productName) {
        List<ComestibleProduct> comestibleProducts = comestibleProductRepository.findByProductNameContainsIgnoreCase(productName);
        log.info("Comestible products list has been returned");
        return comestibleProducts;
    }

    public List<ComestibleProduct> getAll() {
        List<ComestibleProduct> comestibleProducts = comestibleProductRepository.findAll();
        log.info("Comestible products list has been returned");
        return comestibleProducts;
    }

    public ComestibleProduct save(ComestibleProduct comestibleProduct) {
        ComestibleProduct savedComestibleProduct = comestibleProductRepository.save(comestibleProduct);
        log.info("Comestible product has been saved");
        return savedComestibleProduct;
    }

    public void saveAll(List<ComestibleProduct> comestibleProducts) {
        comestibleProducts.forEach(this::save);
        log.info("Comestible products have been saved");
    }

    public void delete(ComestibleProduct comestibleProduct) {
        log.info("ComestibleProduct has been deleted");
        comestibleProductRepository.delete(comestibleProduct);
    }

    public void deleteById(long id) {
        log.info("ComestibleProduct has been deleted");
        comestibleProductRepository.deleteById(id);
    }


    public void deleteAll() {
        comestibleProductRepository.deleteAll();
        log.info("All comestible products have been deleted");
    }
}
