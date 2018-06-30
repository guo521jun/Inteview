/**
 *
 *数值的整数次方
 *
 */
public class Power {
	
	private boolean gInvalidInput = false;

    public double power(double base, int exponent) {
        gInvalidInput = false;
        if (equeal(base, 0.0) && exponent < 0) {
            gInvalidInput = true;
            return 0.0;
        }
        int absExponent = exponent;
        if (exponent < 0)
            absExponent = -exponent;
        double result = powerWithUnsignedExponent(base, absExponent);
        if (exponent < 0)
            result = 1.0 / result;
        return result;
    }

    private double powerWithUnsignedExponent(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;
        double result = powerWithUnsignedExponent(base, exponent >> 1);
        result *= result;
        if ((exponent & 0x1) == 1)
            result *= base;
        return result;
    }

    private boolean equeal(double num1, double num2) {
        if ((num1 - num2 > -0.0000001) && (num1 - num2 < 0.0000001))
            return true;
        return false;
    }
}