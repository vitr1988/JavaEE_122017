package ru.otus.testing;

import javax.enterprise.inject.Default;
import java.math.BigDecimal;

@Default
public class Tax {

    private static final BigDecimal PERCENTAGE_TAX;

    static {
        PERCENTAGE_TAX = new BigDecimal("0.10");
    }

    public BigDecimal priceWithTax(BigDecimal price, boolean isTaxIncluded) {
        if (isTaxIncluded) {
            return price;
        } else {
            BigDecimal tax = price.multiply(PERCENTAGE_TAX);
            return price.add(tax);
        }
    }
}
