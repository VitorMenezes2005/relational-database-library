package com.vitor.relational_database_library.entites;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.xml.crypto.Data;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID loanId;

    @CreationTimestamp
    @Column(name = "loanDate")
    private Instant loanDate;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Loan() {
    }

    public Loan(UUID loanId,
                Instant loanDate,
                String description,
                Client client) {
        this.loanId = loanId;
        this.loanDate = loanDate;
        this.description = description;
        this.client = client;
    }

    public UUID getLoanId() {
        return loanId;
    }

    public void setLoanId(UUID loanId) {
        this.loanId = loanId;
    }

    public Instant getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Instant loanDate) {
        this.loanDate = loanDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
