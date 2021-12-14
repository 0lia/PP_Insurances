package com.example.kursova.incurances;

public class CarInsurance implements Insurance{
    final String ins_type = "Car";
    double risk;
    int price, payment;
    String type;
    int motor_volume, car_price;

    public CarInsurance(){}

    public CarInsurance(String type, int motor_volume, int car_price){
        this.type = type;
        this.motor_volume = motor_volume;
        this.car_price = car_price;
        calculate_risk();
        calculate_price();
        calculate_payment();
    }

    public String getIns_type(){
        return  ins_type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMotor_volume(int motor_volume) {
        this.motor_volume = motor_volume;
    }

    public void setCar_price(int car_price) {
        this.car_price = car_price;
    }

    @Override
    public int getPrice(){
        return price;
    }

    @Override
    public double getRisk() {
        return risk;
    }

    @Override
    public int getPayment() {
        return payment;
    }

    public int getMotor_volume() {
        return motor_volume;
    }

    @Override
    public void calculate_risk() {
        if(type.equals("motorcycle"))
            risk = 0.3;
        else if(type.equals("truck "))
            risk = 0.2;
        else if(type.equals("bus"))
            risk = 0.15;
        else
            risk = 0.1;
    }
    @Override
    public void calculate_price() {
        price = (int)(motor_volume*risk*10);
    }

    @Override
    public void calculate_payment() {
        payment = (int)(car_price*(1-risk));
    }

    @Override
    public String toString() {
        return "CarInsurance{" +
                "risk=" + risk +
                ", price=" + price +
                ", payment=" + payment +
                ", type='" + type + '\'' +
                ", motor_volume=" + motor_volume +
                ", car_price=" + car_price +
                '}';
    }
}
