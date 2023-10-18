package br.jus.tjro.FractionKata.model;

public class FractionRequest {
    private int numerator1;
    private int denominator1;
    private int numerator2;
    private int denominator2;

    public FractionRequest() {
    }

    public FractionRequest(int numerator1, int denominator1, int numerator2, int denominator2) {
        this.numerator1 = numerator1;
        this.denominator1 = denominator1;
        this.numerator2 = numerator2;
        this.denominator2 = denominator2;
    }

    public int getNumerator1() {
        return numerator1;
    }

    public void setNumerator1(int numerator1) {
        this.numerator1 = numerator1;
    }

    public int getDenominator1() {
        return denominator1;
    }

    public void setDenominator1(int denominator1) {
        this.denominator1 = denominator1;
    }

    public int getNumerator2() {
        return numerator2;
    }

    public void setNumerator2(int numerator2) {
        this.numerator2 = numerator2;
    }

    public int getDenominator2() {
        return denominator2;
    }

    public void setDenominator2(int denominator2) {
        this.denominator2 = denominator2;
    }

    public Boolean oneDenominatorsIsZero() {
        return this.getDenominator1() == 0 || this.getDenominator2() == 0;
    }
}
