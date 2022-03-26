package fr.chekconsulting.catalog.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Product {
    @Id
    private Integer id;
    private String name;
    private String category;
    private Integer price;

}
