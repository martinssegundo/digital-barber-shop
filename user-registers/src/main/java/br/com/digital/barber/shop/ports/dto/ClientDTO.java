package br.com.digital.barber.shop.ports.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RegisterForReflection
public class ClientDTO {
    private String name;
//    private LocalDate birthday;
//    private Address address;
}
