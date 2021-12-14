package com.example.kursova.incurances;

public class HouseInsurance implements Insurance{

    final String ins_type = "House";
    double risk;
    int price, payment;
    int area, house_price;
    public HouseInsurance(int area, int house_price){
        this.area = area;
        this.house_price = house_price;
        calculate_risk();
        calculate_price();
        calculate_payment();
    }

    public String getIns_type(){
        return  ins_type;
    }

    @Override
    public int getPrice(){
        return price;
    }

    @Override
    public int getPayment() {
        return payment;
    }

    @Override
    public double getRisk() {
        return risk;
    }

    public int getArea() {
        return area;
    }

    public int getHouse_price(){
        return house_price;
    }
    @Override
    public void calculate_risk() {
        risk = (double)(int)(((double) area*100/house_price)*10000)/10000;
    }
    @Override
    public void calculate_price() {
        price = (int)(double)house_price/100000*area;
    }

    @Override
    public void calculate_payment() {
        payment = (int)(house_price*(1-risk));
    }

    @Override
    public String toString() {
        return "HouseInsurance{" +
                "risk=" + risk +
                ", price=" + price +
                ", payment=" + payment +
                ", area=" + area +
                ", house_price=" + house_price +
                '}';
    }
}
