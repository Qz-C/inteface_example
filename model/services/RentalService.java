package model.services;

import model.entities.Invoice;
import model.entities.VehicleRental;

import java.util.concurrent.TimeUnit;

public class RentalService {
    private double pricePerDay;
    private double pricePerHour;
    private TaxService taxService;

    public RentalService(Double pricePerDay, Double pricePerHour, TaxService taxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }

    public void processInvoice(VehicleRental rentedVehicle){
        double totalTime = rentedVehicle.getFinish().getTime() - rentedVehicle.getStart().getTime();
        double hours = totalTime / 1000 / 60 / 60; // Converting into hour.
        double paymentBase = (hours <= 12.0) ? Math.ceil(hours)*pricePerHour : Math.ceil(hours/24)*pricePerDay;
        double tax = taxService.tax(paymentBase);
        rentedVehicle.setInvoice(new Invoice(paymentBase, tax));
    }
}
