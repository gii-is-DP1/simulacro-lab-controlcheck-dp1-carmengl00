package org.springframework.samples.petclinic.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product_type")
public class ProductType extends BaseEntity{
	@NotNull
	@Size(min=3, max=50)
	@Column(name="name", unique=true)
    String name;
}
