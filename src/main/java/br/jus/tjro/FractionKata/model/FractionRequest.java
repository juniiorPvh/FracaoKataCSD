package br.jus.tjro.FractionKata.model;

import lombok.*;

@AllArgsConstructor
@Getter
public class FractionRequest {
    private int numerator1;
    private int denominator1;
    private int numerator2;
    private int denominator2;

    public Boolean oneDenominatorsIsZero() {
        return this.getDenominator1() == 0 || this.getDenominator2() == 0;
    }
}
