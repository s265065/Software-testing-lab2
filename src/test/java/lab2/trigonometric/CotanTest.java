package lab2.trigonometric;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(value=PER_CLASS)
public class CotanTest {

    private static final double DELTA = 0.05;
    private static final double ACCURACY = 0.001;

    private CotanCalculator cotan;

    @ParameterizedTest
    @CsvFileSource(resources = "/cotan_test_data.csv")
    public void tableValuesStubsTest(double expected, double num, double den) {
        cotan = new CotanCalculator(ACCURACY, TrigonomMock.getSinMock(), TrigonomMock.getCosMock());
        double actual = cotan.calculate(num * PI / den);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void nanStubsTest() {
        cotan = new CotanCalculator(ACCURACY, TrigonomMock.getSinMock(), TrigonomMock.getCosMock());
        double expected = Double.POSITIVE_INFINITY;
        double actual = cotan.calculate(Double.NaN);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void positiveInfinityStubsTest() {
        cotan = new CotanCalculator(ACCURACY, TrigonomMock.getSinMock(), TrigonomMock.getCosMock());
        double expected = Double.POSITIVE_INFINITY;
        double actual = cotan.calculate(Double.POSITIVE_INFINITY);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void negativeInfinityStubsTest() {
        cotan = new CotanCalculator(ACCURACY, TrigonomMock.getSinMock(), TrigonomMock.getCosMock());
        double expected = Double.POSITIVE_INFINITY;
        double actual = cotan.calculate(Double.NEGATIVE_INFINITY);
        assertEquals(expected, actual, DELTA);
    }

}