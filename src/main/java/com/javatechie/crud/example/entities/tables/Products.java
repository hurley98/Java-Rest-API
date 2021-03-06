/*
 * This file is generated by jOOQ.
 */
package com.javatechie.crud.example.entities.tables;


import com.javatechie.crud.example.entities.Keys;
import com.javatechie.crud.example.entities.RestApi;
import com.javatechie.crud.example.entities.tables.records.ProductsRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row4;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Products extends TableImpl<ProductsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>rest_api.products</code>
     */
    public static final Products PRODUCTS = new Products();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ProductsRecord> getRecordType() {
        return ProductsRecord.class;
    }

    /**
     * The column <code>rest_api.products.ProductName</code>.
     */
    public final TableField<ProductsRecord, String> PRODUCTNAME = createField(DSL.name("ProductName"), SQLDataType.VARCHAR(45), this, "");

    /**
     * The column <code>rest_api.products.UnitPrice</code>.
     */
    public final TableField<ProductsRecord, Double> UNITPRICE = createField(DSL.name("UnitPrice"), SQLDataType.DOUBLE.nullable(false), this, "");

    /**
     * The column <code>rest_api.products.Unit</code>.
     */
    public final TableField<ProductsRecord, String> UNIT = createField(DSL.name("Unit"), SQLDataType.VARCHAR(45), this, "");

    /**
     * The column <code>rest_api.products.ProductID</code>.
     */
    public final TableField<ProductsRecord, Integer> PRODUCTID = createField(DSL.name("ProductID"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    private Products(Name alias, Table<ProductsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Products(Name alias, Table<ProductsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>rest_api.products</code> table reference
     */
    public Products(String alias) {
        this(DSL.name(alias), PRODUCTS);
    }

    /**
     * Create an aliased <code>rest_api.products</code> table reference
     */
    public Products(Name alias) {
        this(alias, PRODUCTS);
    }

    /**
     * Create a <code>rest_api.products</code> table reference
     */
    public Products() {
        this(DSL.name("products"), null);
    }

    public <O extends Record> Products(Table<O> child, ForeignKey<O, ProductsRecord> key) {
        super(child, key, PRODUCTS);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : RestApi.REST_API;
    }

    @Override
    public Identity<ProductsRecord, Integer> getIdentity() {
        return (Identity<ProductsRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<ProductsRecord> getPrimaryKey() {
        return Keys.KEY_PRODUCTS_PRIMARY;
    }

    @Override
    public Products as(String alias) {
        return new Products(DSL.name(alias), this);
    }

    @Override
    public Products as(Name alias) {
        return new Products(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Products rename(String name) {
        return new Products(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Products rename(Name name) {
        return new Products(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<String, Double, String, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}
