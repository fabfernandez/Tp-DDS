package utn.frba.losjavaleros.dto;

import java.util.List;

import lombok.Getter;

@Getter
public class UsuarioDto {
  private String name;
  private String lastName;
  private String birthday;
  private Long dni;
  private ContactDto mainContact;
  private List<ContactDto> additionalContacts;
  private String password;

}
