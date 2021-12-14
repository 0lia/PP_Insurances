package com.example.kursova.incurances;
public interface Insurance {
    double getRisk();
    int getPrice();
    int getPayment();
    void calculate_risk();
    void calculate_price();
    void calculate_payment();
}
