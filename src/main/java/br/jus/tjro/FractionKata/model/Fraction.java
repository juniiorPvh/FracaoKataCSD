package br.jus.tjro.FractionKata.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Builder
public class Fraction {
    private Integer numerator;
    private Integer denominator;
    private String error;

    // Método para simplificar a fração
    public void simplify() {
        Integer gcd = calculateGCD(this.numerator, this.denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
    }

    // Método para calcular o MDC (máximo divisor comum)
    private Integer calculateGCD(Integer a, Integer b) {
        if (b == 0) {
            return a;
        }
        return calculateGCD(b, a % b);
    }
}
