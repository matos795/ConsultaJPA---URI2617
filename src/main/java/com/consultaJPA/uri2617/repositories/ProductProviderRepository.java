package com.consultaJPA.uri2617.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.consultaJPA.uri2617.dto.ProductProviderDTO;
import com.consultaJPA.uri2617.entities.Product;
import com.consultaJPA.uri2617.projections.ProductProviderProjection;

public interface ProductProviderRepository extends JpaRepository<Product, Long>{

    @Query(nativeQuery = true, value = "SELECT products.name AS nameProduct, providers.name AS nameProvider FROM products " +
          "INNER JOIN providers ON products.id_providers = providers.id " +
          "WHERE providers.name = :str")
    List<ProductProviderProjection> search1(String str);

    @Query("SELECT new com.consultaJPA.uri2617.dto.ProductProviderDTO(obj.name, obj.provider.name) FROM Product obj WHERE obj.provider.name = :str")
    List<ProductProviderDTO> search2(String str);
}
