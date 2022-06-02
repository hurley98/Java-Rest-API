/*
 * This file is generated by jOOQ.
 */
package com.javatechie.crud.example.entities.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;

    private String  productname;
    private Double  unitprice;
    private String  unit;
    private Integer productid;

    public Products() {}

    public Products(Products value) {
        this.productname = value.productname;
        this.unitprice = value.unitprice;
        this.unit = value.unit;
        this.productid = value.productid;
    }

    public Products(
        String  productname,
        Double  unitprice,
        String  unit,
        Integer productid
    ) {
        this.productname = productname;
        this.unitprice = unitprice;
        this.unit = unit;
        this.productid = productid;
    }

    /**
     * Getter for <code>rest_api.products.ProductName</code>.
     */
    public String getProductname() {
        return this.productname;
    }

    /**
     * Setter for <code>rest_api.products.ProductName</code>.
     */
    public Products setProductname(String productname) {
        this.productname = productname;
        return this;
    }

    /**
     * Getter for <code>rest_api.products.UnitPrice</code>.
     */
    public Double getUnitprice() {
        return this.unitprice;
    }

    /**
     * Setter for <code>rest_api.products.UnitPrice</code>.
     */
    public Products setUnitprice(Double unitprice) {
        this.unitprice = unitprice;
        return this;
    }

    /**
     * Getter for <code>rest_api.products.Unit</code>.
     */
    public String getUnit() {
        return this.unit;
    }

    /**
     * Setter for <code>rest_api.products.Unit</code>.
     */
    public Products setUnit(String unit) {
        this.unit = unit;
        return this;
    }

    /**
     * Getter for <code>rest_api.products.ProductID</code>.
     */
    public Integer getProductid() {
        return this.productid;
    }

    /**
     * Setter for <code>rest_api.products.ProductID</code>.
     */
    public Products setProductid(Integer productid) {
        this.productid = productid;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Products other = (Products) obj;
        if (productname == null) {
            if (other.productname != null)
                return false;
        }
        else if (!productname.equals(other.productname))
            return false;
        if (unitprice == null) {
            if (other.unitprice != null)
                return false;
        }
        else if (!unitprice.equals(other.unitprice))
            return false;
        if (unit == null) {
            if (other.unit != null)
                return false;
        }
        else if (!unit.equals(other.unit))
            return false;
        if (productid == null) {
            if (other.productid != null)
                return false;
        }
        else if (!productid.equals(other.productid))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.productname == null) ? 0 : this.productname.hashCode());
        result = prime * result + ((this.unitprice == null) ? 0 : this.unitprice.hashCode());
        result = prime * result + ((this.unit == null) ? 0 : this.unit.hashCode());
        result = prime * result + ((this.productid == null) ? 0 : this.productid.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Products (");

        sb.append(productname);
        sb.append(", ").append(unitprice);
        sb.append(", ").append(unit);
        sb.append(", ").append(productid);

        sb.append(")");
        return sb.toString();
    }
}