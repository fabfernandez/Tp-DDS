package utn.frba.losjavaleros.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import utn.frba.losjavaleros.model.Contact;

@Getter
public class UserDto {
  private String name;
  private String lastName;
  private LocalDate birthday;
  private Long dni;
  private Contact mainContact;
  private List<Contact> additionalContacts;
  private String password;

}
