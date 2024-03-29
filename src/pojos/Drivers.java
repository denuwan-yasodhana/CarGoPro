package pojos;
// Generated Aug 7, 2022 12:31:41 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Drivers generated by hbm2java
 */
public class Drivers  implements java.io.Serializable {


     private String driverId;
     private String name;
     private String status;
     private int telephoneNo;
     private String nic;
     private Set rents = new HashSet(0);

    public Drivers() {
    }

	
    public Drivers(String driverId, String name, String status, int telephoneNo, String nic) {
        this.driverId = driverId;
        this.name = name;
        this.status = status;
        this.telephoneNo = telephoneNo;
        this.nic = nic;
    }
    public Drivers(String driverId, String name, String status, int telephoneNo, String nic, Set rents) {
       this.driverId = driverId;
       this.name = name;
       this.status = status;
       this.telephoneNo = telephoneNo;
       this.nic = nic;
       this.rents = rents;
    }
   
    public String getDriverId() {
        return this.driverId;
    }
    
    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    public int getTelephoneNo() {
        return this.telephoneNo;
    }
    
    public void setTelephoneNo(int telephoneNo) {
        this.telephoneNo = telephoneNo;
    }
    public String getNic() {
        return this.nic;
    }
    
    public void setNic(String nic) {
        this.nic = nic;
    }
    public Set getRents() {
        return this.rents;
    }
    
    public void setRents(Set rents) {
        this.rents = rents;
    }




}


