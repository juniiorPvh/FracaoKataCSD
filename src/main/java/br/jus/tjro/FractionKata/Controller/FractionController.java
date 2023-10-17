package br.jus.tjro.FractionKata.Controller;

import br.jus.tjro.FractionKata.model.Fraction;
import br.jus.tjro.FractionKata.model.FractionRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fractions")
public class FractionController {
    @PostMapping("/add")
    public Fraction addFractions(@RequestBody FractionRequest request) {
        Fraction result = new Fraction(request.getNumerator1() * request.getDenominator2() + request.getNumerator2() * request.getDenominator1(),
                request.getDenominator1() * request.getDenominator2());
        result.simplify();
        return result;
    }

    @PostMapping("/subtract")
    public Fraction subtractFractions(@RequestBody FractionRequest request) {
        Fraction result = new Fraction(request.getNumerator1() * request.getDenominator2() - request.getNumerator2() * request.getDenominator1(),
                request.getDenominator1() * request.getDenominator2());
        result.simplify();
        return result;
    }

    @PostMapping("/multiply")
    public Fraction multiplyFractions(@RequestBody FractionRequest request) {
        Fraction result = new Fraction(request.getNumerator1() * request.getNumerator2(),
                request.getDenominator1() * request.getDenominator2());
        result.simplify();
        return result;
    }

    @PostMapping("/divide")
    public Fraction divideFractions(@RequestBody FractionRequest request) {
        Fraction result = new Fraction(request.getNumerator1() * request.getDenominator2(),
                request.getNumerator2() * request.getDenominator1());
        result.simplify();
        return result;
    }
}