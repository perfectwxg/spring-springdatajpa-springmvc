package com.xianguang.domain;

import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * @author wuxianguang
 * 商品对象
 */

@Entity
public class Product extends BaseDomain{


    private String name;

    private String color;

    private String pic;

    private String smallPic;

    private BigDecimal costPrice;

    private BigDecimal salePrice;

    private Long typesId;

    private Long unitId;

    private Long brandId;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getSmallPic() {
        return smallPic;
    }

    public void setSmallPic(String smallPic) {
        this.smallPic = smallPic;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", pic='" + pic + '\'' +
                ", smallPic='" + smallPic + '\'' +
                ", costPrice=" + costPrice +
                ", salePrice=" + salePrice +
                ", id=" + id +
                '}';
    }
}
