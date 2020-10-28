package model.entities;
public class Invoice{

    private Double basicPrice;
    private Double tax;

    public Invoice(){

    }

    public Invoice(Double basicPrice, Double tax) {
        this.basicPrice = basicPrice;
        this.tax = tax;
    }

    public Double getBasicPrice() {
        return basicPrice;
    }

    public void setBasicPrice(Double basicPrice) {
        this.basicPrice = basicPrice;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getFinalPrice(){
        return basicPrice + tax;
    }

}