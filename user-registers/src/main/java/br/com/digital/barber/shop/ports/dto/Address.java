package br.com.digital.barber.shop.ports.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@RegisterForReflection
public class Address {
    private String street;
    private String number;
    private String city;
    private String district;
}
