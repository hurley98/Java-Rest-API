/*
 * This file is generated by jOOQ.
 */
package com.javatechie.crud.example.entities.tables.records;


import com.javatechie.crud.example.entities.tables.Products;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ProductsRecord extends UpdatableRecordImpl<ProductsRecord> implements Record4<String, Double, String, Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>rest_api.products.ProductName</code>.
     */
    public ProductsRecord setProductname(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>rest_api.products.ProductName</code>.
     */
    public String getProductname() {
        return (String) get(0);
    }

    /**
     * Setter for <code>rest_api.products.UnitPrice</code>.
     */
    public ProductsRecord setUnitprice(Double value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>rest_api.products.UnitPrice</code>.
     */
    public Double getUnitprice() {
        return (Double) get(1);
    }

    /**
     * Setter for <code>rest_api.products.Unit</code>.
     */
    public ProductsRecord setUnit(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>rest_api.products.Unit</code>.
     */
    public String getUnit() {
        return (String) get(2);
    }

    /**
     * Setter for <code>rest_api.products.ProductID</code>.
     */
    public ProductsRecord setProductid(Integer value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>rest_api.products.ProductID</code>.
     */
    public Integer getProductid() {
        return (Integer) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<String, Double, String, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<String, Double, String, Integer> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Products.PRODUCTS.PRODUCTNAME;
    }

    @Override
    public Field<Double> field2() {
        return Products.PRODUCTS.UNITPRICE;
    }

    @Override
    public Field<String> field3() {
        return Products.PRODUCTS.UNIT;
    }

    @Override
    public Field<Integer> field4() {
        return Products.PRODUCTS.PRODUCTID;
    }

    @Override
    public String component1() {
        return getProductname();
    }

    @Override
    public Double component2() {
        return getUnitprice();
    }

    @Override
    public String component3() {
        return getUnit();
    }

    @Override
    public Integer component4() {
        return getProductid();
    }

    @Override
    public String value1() {
        return getProductname();
    }

    @Override
    public Double value2() {
        return getUnitprice();
    }

    @Override
    public String value3() {
        return getUnit();
    }

    @Override
    public Integer value4() {
        return getProductid();
    }

    @Override
    public ProductsRecord value1(String value) {
        setProductname(value);
        return this;
    }

    @Override
    public ProductsRecord value2(Double value) {
        setUnitprice(value);
        return this;
    }

    @Override
    public ProductsRecord value3(String value) {
        setUnit(value);
        return this;
    }

    @Override
    public ProductsRecord value4(Integer value) {
        setProductid(value);
        return this;
    }

    @Override
    public ProductsRecord values(String value1, Double value2, String value3, Integer value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ProductsRecord
     */
    public ProductsRecord() {
        super(Products.PRODUCTS);
    }

    /**
     * Create a detached, initialised ProductsRecord
     */
    public ProductsRecord(String productname, Double unitprice, String unit, Integer productid) {
        super(Products.PRODUCTS);

        setProductname(productname);
        setUnitprice(unitprice);
        setUnit(unit);
        setProductid(productid);
    }

    /**
     * Create a detached, initialised ProductsRecord
     */
    public ProductsRecord(com.javatechie.crud.example.entities.tables.pojos.Products value) {
        super(Products.PRODUCTS);

        if (value != null) {
            setProductname(value.getProductname());
            setUnitprice(value.getUnitprice());
            setUnit(value.getUnit());
            setProductid(value.getProductid());
        }
    }
}
