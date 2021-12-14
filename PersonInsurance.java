package com.example.kursova.incurances;

public class PersonInsurance implements Insurance{

    final String ins_type = "Person";
    double risk;
    int price, payment;
    private int age;
    double health_level;
    public PersonInsurance(){
        this.age = 0;
    }

    public PersonInsurance(int age, int health){
        this.age = age;
        health_level = calculate_hel_lev(health);
        calculate_risk();
        calculate_price();
        calculate_payment();
    }

    public String getIns_type(){
        return  ins_type;
    }
    public void setHealth_level(double health_level) {
        this.health_level = health_level;
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

    public int getAge(){
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void calculate_risk() {
        risk = ((double)(int)(age*health_level/200*10000))/10000;
    }

    @Override
    public void calculate_price() {
        price = (int)(risk*1000);
    }

    @Override
    public void calculate_payment() {
       payment = price*100;
    }

    double calculate_hel_lev(int health){
        switch (health){
            case 1:
                return 1.8;
            case 2:
                return 1.6;
            case 3:
                return  1.4;
            case 4:
                return  1.2;
            default:
                return  1;
        }
    }

    @Override
    public String toString() {
        return "PersonInsurance{" +
                "risk=" + risk +
                ", price=" + price +
                ", payment=" + payment +
                '}';
    }
}
