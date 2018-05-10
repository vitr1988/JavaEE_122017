package ru.otus.testing;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TaxTest {

    Tax tax;

    @Before
    public void setUp() {
        this.tax = new Tax();
    }

    @Test
    public void shouldTestTaxIncluded() {
        BigDecimal price = new BigDecimal("1000");
        boolean isTaxIncluded = true;

        BigDecimal expected = this.tax.priceWithTax(price, isTaxIncluded);

        assertThat(expected, is(equalTo(price)));
    }

    @Test
    public void shouldFailedWhenTaxNotIncluded() {
        BigDecimal price = new BigDecimal("1000");
        boolean isTaxIncluded = false;

        BigDecimal expected = this.tax.priceWithTax(price, isTaxIncluded);

        assertThat(expected, is(not(equalTo(price))));
    }
}
