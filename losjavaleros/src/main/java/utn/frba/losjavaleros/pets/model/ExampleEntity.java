package utn.frba.losjavaleros.pets.controller.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table(name = "dealers")
public class ExampleEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable = false, length = 1, name = "id_dealer")
  private Integer idDealer;

  @Column(name = "dealer_name", nullable = false, length = 25)
  @Size(max = 25, message = "The country must not have more than 20 characters.")
  private String name;

  @Column(name = "dealer_address", nullable = false, length = 40)
  @Size(max = 40, message = "The address must not have more than 20 characters.")
  private String address;

  @Column(name = "dealer_phone", nullable = false)
  private Integer phone;

  @Column(name = "dealer_country", nullable = false, length = 20)
  @Size(max = 20, message = "The country must not have more than 20 characters.")
  private String country;
}

