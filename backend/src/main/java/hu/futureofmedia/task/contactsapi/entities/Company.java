package hu.futureofmedia.task.contactsapi.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Builder
@Table(name = "company")
@NoArgsConstructor
public class Company {
    @Id
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    ;
    public Company(Long id, String name){
        this.id = id;
        this.name = name;
    }
}
