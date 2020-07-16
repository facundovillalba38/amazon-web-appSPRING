package com.amazon.amazonwebapp.domain;

import java.sql.Timestamp;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cacheprices")
public class CachePrice{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idcacheprices;
    @ManyToOne
    @JoinColumn(name="iditems", nullable=false)
    private Item item;
    private Timestamp pricedate;
    private double discountprice;
    private String imageurl;

    public int getIdcacheprices() {
        return idcacheprices;
    }

    public void setIdcacheprices(int idcacheprices) {
        this.idcacheprices = idcacheprices;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Timestamp getPricedate() {
        return pricedate;
    }

    public void setPricedate(Timestamp pricedate) {
        this.pricedate = pricedate;
    }

    

    public double getDiscountprice() {
        return discountprice;
    }

    public void setDiscountprice(double discountprice) {
        this.discountprice = discountprice;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    

}
