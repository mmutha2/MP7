/**
 * @name        Main Calculator
 * @authors     Monica Muthaiya & Tajesvi Bhat
 * @link        http://github.com/mmutha2
 * 
 * We have created a calculator that can handle the basic operations of addition, 
 * multiplication, subtraction, and division. Along with this, it can handle trigonometric functions
 * (sine, cosine, tangent), square roots, and cubics.
 * 
 */

public class mainCalculator {
	
	// This enum handles basic arithmetic.
    public enum simpleOperators { normal, addition, multiplication, subtraction, division }
    
    // This enum handles more advanced operations.
    public enum complexOperators { square, squareRoot, cubic, cosine, sine, tangent, exponent }
    
    private Double firstInput, secondInput;
    private simpleOperators mode = simpleOperators.normal;
    
    // This method handles the execution of basic arithmetic operations listed as enums above.
    private Double basicCalculations() {
        if (mode == simpleOperators.normal) {
            return secondInput;
        }
        if (mode == simpleOperators.addition) {
            return firstInput + secondInput;
        }
        if (mode == simpleOperators.subtraction) {
            return firstInput - secondInput;
        }
        if (mode == simpleOperators.multiplication) {
            return firstInput * secondInput;
        }
        if (mode == simpleOperators.division) {
            return firstInput / secondInput;
        }
        
        // Error is thrown if user does not provide mathematically correct inputs.
        throw new Error();
    }

    // This method handles the execution of complex operations listed as enums above.
    public Double calculateComplex(complexOperators newMode, Double input) {
        if (newMode == complexOperators.square) {
            return input * input;
        }
        if (newMode == complexOperators.squareRoot) {
            return Math.sqrt(input);
        }
        if (newMode == complexOperators.cubic) {
            return input * input * input;
        }
        if (newMode == complexOperators.cosine) {
            return Math.cos(input);
        }
        if (newMode == complexOperators.sine) {
            return Math.sin(input);
        }
        if (newMode == complexOperators.tangent) {
            return Math.tan(input);
        }
        if (newMode == complexOperators.exponent) {
            return Math.pow(2, input);
        }
        
        throw new Error();
    }
    
    public Double calculateSimple(simpleOperators newMode, Double number) {
        if (mode == simpleOperators.normal) {
            secondInput = 0.0;
            firstInput = number;
            mode = newMode;
            return Double.NaN;
        } else {
            secondInput = number;
            firstInput = basicCalculations();
            mode = newMode;
            return firstInput;
        }
    }

    public Double reset() {
        secondInput = 0.0;
        firstInput = 0.0;
        mode = simpleOperators.normal;

        return Double.NaN;
    }
    
    // Returns value of calculation if inputs are valid.
    public Double calculateEqual(Double num) {
        return calculateSimple(simpleOperators.normal, num);
    }

}