package hu.futureofmedia.task.contactsapi.entities;

import hu.futureofmedia.task.contactsapi.enums.StatusEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Kapcsolattarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "firstName", nullable = false)
    private String firstName;

    @NotNull
    @Column(name = "lastName", nullable = false)
    private String lastName;

    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone")
    private String phone;

    @NotNull
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @Column(name = "comment")
    private String comment;

    @NotNull
    @Column(name = "creation_time")
    private LocalDateTime creationTime;

    @Column(name = "modified_time")
    private LocalDateTime modifiedTime;

    @NotNull
    @Column(name = "status", nullable = false)
    private StatusEnum status = StatusEnum.ACTIVE;

    public Kapcsolattarto(Long id, String firstName, String lastName, String email, String phone, Company company, String comment, StatusEnum status, LocalDateTime creationTime) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.company = company;
        this.comment = comment;
        this.status = status;
        this.creationTime = creationTime;
    }

    public Kapcsolattarto(){}


    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Company getCompany() {
        return company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public StatusEnum getStatus() {
        return status;
    }
    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
