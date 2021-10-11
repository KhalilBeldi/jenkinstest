package com.inetum.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.ManyToOne;
import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Product {
    @Id
    @Column(name = "id_prod", nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String name;

    private String quantity;

    private boolean disponibility;

    @CreationTimestamp
    private Timestamp createdDate;

    @UpdateTimestamp
    private Timestamp updatedDate;

    public boolean getDisponibility() {
        return disponibility;
    }

    @ManyToOne
    @JoinColumn(name="id_cat",referencedColumnName = "id")
    private Category category;

    @JsonIgnore
    public Category getCategory(){
        return this.category;
    }

}
