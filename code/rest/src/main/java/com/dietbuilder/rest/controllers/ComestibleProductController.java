package com.dietbuilder.rest.controllers;

import com.dietbuilder.api.ComestibleProductsApi;
import com.dietbuilder.rest.mappers.ComestibleProductDtoComestibleProductModelMapper;
import com.dietbuilder.domain.daos.ComestibleProductDao;
import com.dietbuilder.domain.exceptions.ComestibleProductNotFoundException;
import com.dietbuilder.model.ComestibleProductDto;
import com.dietbuilder.domain.model.comestible_product.ComestibleProduct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class ComestibleProductController implements ComestibleProductsApi {

    @Autowired
    private ComestibleProductDao comestibleProductDao;

    @Autowired
    private ComestibleProductDtoComestibleProductModelMapper comestibleProductDTOComestibleProductDocumentMapper;

    @Override
    public ResponseEntity<ComestibleProductDto> getComestibleProductById(@PathVariable Long id) {
        ComestibleProduct comestibleProduct;
        try {
            comestibleProduct = comestibleProductDao.get(id);
        } catch (ComestibleProductNotFoundException e) {
            log.error("Comestible product with this ID does not exist.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        return ResponseEntity.ok(comestibleProductDTOComestibleProductDocumentMapper.destinationToSource(comestibleProduct));
    }

    @Override
    public ResponseEntity<List<ComestibleProductDto>> getComestibleProductsByName(@PathVariable String productName) {
        List<ComestibleProduct> comestibleProducts = comestibleProductDao.getAllByName(productName);

        return ResponseEntity.ok(comestibleProducts.stream().map(p -> comestibleProductDTOComestibleProductDocumentMapper.destinationToSource(p))
                .collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<List<ComestibleProductDto>> getAllComestibleProducts() {
        List<ComestibleProduct> comestibleProducts = comestibleProductDao.getAll();

        return ResponseEntity.ok(comestibleProducts.stream().map(p -> comestibleProductDTOComestibleProductDocumentMapper.destinationToSource(p))
                .collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<ComestibleProductDto> insertComestibleProduct(ComestibleProductDto comestibleProductDto) {
        ComestibleProduct comestibleProductToSave = comestibleProductDTOComestibleProductDocumentMapper.sourceToDestination(comestibleProductDto);

        ComestibleProduct saved = comestibleProductDao.save(comestibleProductToSave);

        return ResponseEntity.ok(comestibleProductDTOComestibleProductDocumentMapper.destinationToSource(saved));
    }

    @Override
    public ResponseEntity<ComestibleProductDto> updateComestibleProduct(@RequestBody ComestibleProductDto comestibleProduct) {

        ComestibleProduct comestibleProductToSave = comestibleProductDTOComestibleProductDocumentMapper.updateComestibleProduct(comestibleProduct);

        ComestibleProduct savedComestibleProduct = comestibleProductDao.save(comestibleProductToSave);

        return ResponseEntity.ok(comestibleProductDTOComestibleProductDocumentMapper.destinationToSource(savedComestibleProduct));
    }

    @Override
    public ResponseEntity<Void> deleteComestibleProduct(@RequestBody ComestibleProductDto comestibleProduct) {
        comestibleProductDao.delete(comestibleProductDTOComestibleProductDocumentMapper.sourceToDestination(comestibleProduct));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteComestibleProductById(@PathVariable Long id) {
        comestibleProductDao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}





