package hu.futureofmedia.task.contactsapi.entities;

import hu.futureofmedia.task.contactsapi.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@Table(name = "kapcsolattartok")
@NoArgsConstructor
@AllArgsConstructor
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

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
