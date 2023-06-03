package h2tk.ecom.model;
import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "VisitorStatistics")
public class VisitorStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "visited_date")
    private Date visitedDate;

    @Column(name = "ip_address")
    private String IPAddress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getVisitedDate() {
        return visitedDate;
    }

    public void setVisitedDate(Date visitedDate) {
        this.visitedDate = visitedDate;
    }

    public String getIPAddress() {
        return IPAddress;
    }

    public void setIPAddress(String iPAddress) {
        IPAddress = iPAddress;
    }

    public VisitorStatistics(int id, Date visitedDate, String iPAddress) {
        this.id = id;
        this.visitedDate = visitedDate;
        IPAddress = iPAddress;
    }

    public VisitorStatistics() {
    }

}
