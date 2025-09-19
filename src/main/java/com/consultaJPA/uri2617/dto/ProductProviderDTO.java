package com.consultaJPA.uri2617.dto;

import com.consultaJPA.uri2617.projections.ProductProviderProjection;

public class ProductProviderDTO {

    private String nameProduct;
    private String nameProvider;
    
    public ProductProviderDTO() {
    }

    public ProductProviderDTO(String nameProduct, String nameProvider) {
        this.nameProduct = nameProduct;
        this.nameProvider = nameProvider;
    }
    
    public ProductProviderDTO(ProductProviderProjection projection) {
        nameProduct = projection.getNameProduct();
        nameProvider = projection.getNameProvider();
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getNameProvider() {
        return nameProvider;
    }

    public void setNameProvider(String nameProvider) {
        this.nameProvider = nameProvider;
    }

    @Override
    public String toString() {
        return "ProductProviderDTO [nameProduct=" + nameProduct + ", nameProvider=" + nameProvider + "]";
    }

}
