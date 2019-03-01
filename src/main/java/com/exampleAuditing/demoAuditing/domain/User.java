package com.exampleAuditing.demoAuditing.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@EnableJpaAuditing
public class User {

@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
private String name;
private String email;
private String country;

    @CreationTimestamp
    @Column(name = "CREATED_DATE", updatable = false)
private Date createdDate;



    @UpdateTimestamp
    @Column(name = "MODIFIED_DATE")
    private Date lastModifiedDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId()) &&
                Objects.equals(getName(), user.getName()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getCountry(), user.getCountry()) &&
                Objects.equals(getCreatedDate(), user.getCreatedDate()) &&
                Objects.equals(getLastModifiedDate(), user.getLastModifiedDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail(), getCountry(), getCreatedDate(), getLastModifiedDate());
    }
}
