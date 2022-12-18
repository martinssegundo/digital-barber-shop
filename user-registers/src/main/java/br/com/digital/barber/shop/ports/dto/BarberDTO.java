package br.com.digital.barber.shop.ports.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@RegisterForReflection
public class BarberDTO {
    private String name;
    private LocalDate birthday;
    private Address address;
}
