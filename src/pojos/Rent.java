package pojos;
// Generated Aug 7, 2022 12:31:41 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Rent generated by hbm2java
 */
public class Rent  implements java.io.Serializable {


     private String rentId;
     private Cars cars;
     private Drivers drivers;
     private String customer;
     private Date rentDate;
     private Date returnDate;
     private int amount;
     private Set returnses = new HashSet(0);

    public Rent() {
    }

	
    public Rent(String rentId, Cars cars, Drivers drivers, String customer, Date rentDate, Date returnDate, int amount) {
        this.rentId = rentId;
        this.cars = cars;
        this.drivers = drivers;
        this.customer = customer;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.amount = amount;
    }
    public Rent(String rentId, Cars cars, Drivers drivers, String customer, Date rentDate, Date returnDate, int amount, Set returnses) {
       this.rentId = rentId;
       this.cars = cars;
       this.drivers = drivers;
       this.customer = customer;
       this.rentDate = rentDate;
       this.returnDate = returnDate;
       this.amount = amount;
       this.returnses = returnses;
    }
   
    public String getRentId() {
        return this.rentId;
    }
    
    public void setRentId(String rentId) {
        this.rentId = rentId;
    }
    public Cars getCars() {
        return this.cars;
    }
    
    public void setCars(Cars cars) {
        this.cars = cars;
    }
    public Drivers getDrivers() {
        return this.drivers;
    }
    
    public void setDrivers(Drivers drivers) {
        this.drivers = drivers;
    }
    public String getCustomer() {
        return this.customer;
    }
    
    public void setCustomer(String customer) {
        this.customer = customer;
    }
    public Date getRentDate() {
        return this.rentDate;
    }
    
    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }
    public Date getReturnDate() {
        return this.returnDate;
    }
    
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
    public int getAmount() {
        return this.amount;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public Set getReturnses() {
        return this.returnses;
    }
    
    public void setReturnses(Set returnses) {
        this.returnses = returnses;
    }




}


