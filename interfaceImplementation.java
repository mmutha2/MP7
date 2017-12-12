/**
 * @name        Interface Implementation
 * @authors     Monica Muthaiya & Tajesvi Bhat
 * @link        http://github.com/mmutha2
 * 
 * We have created a calculator that can handle the basic operations of addition, 
 * multiplication, subtraction, and division. Along with this, it can handle trigonometric functions
 * (sine, cosine, tangent), square roots, and cubics.
 * 
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class interfaceImplementation implements ActionListener {
    private final JTextArea text;
	private final JFrame frame;
    private final JPanel panel;
    private final JButton but[], butAddition, butSubtraction, butMultiplication, butDivision,
            butEquals, butClear, butSquareRoot, butSquare, butCubic,
            butCosine, butSine, butExponent, butTangent;
    private final mainCalculator mp7calc;

    private final String[] buttonValue = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

    // Establish calculator framework properties, such as size and shape.
    public interfaceImplementation() {
        frame = new JFrame("MP 7 Calculator");
        text = new JTextArea(2, 27);
        but = new JButton[10];
        frame.setResizable(false);
        panel = new JPanel(new FlowLayout());
        for (int numButton = 0; numButton < 10; numButton++) {
            but[numButton] = new JButton(String.valueOf(numButton));
        }
        
        mp7calc = new mainCalculator();
        
        
        // Create the individual buttons and assign them their representative signs.
        // Additionally, we set the background colors with the setBackground function.
        butAddition = new JButton("+"); butAddition.setBackground(Color.lightGray); 
        butMultiplication = new JButton("x"); butMultiplication.setBackground(Color.lightGray); 
        butSubtraction = new JButton("-"); butSubtraction.setBackground(Color.lightGray); 
        butDivision = new JButton("÷"); butDivision.setBackground(Color.lightGray);
        butCosine = new JButton("Cosine"); butCosine.setBackground(Color.pink);
        butSine = new JButton("Sine"); butSine.setBackground(Color.pink);
        butTangent = new JButton("Tangent"); butTangent.setBackground(Color.pink);
        butEquals = new JButton("="); butEquals.setBackground(Color.green);
        butSquare = new JButton("x^2"); butSquare.setBackground(Color.yellow);
        butCubic = new JButton("x^3"); butCubic.setBackground(Color.yellow);
        butSquareRoot = new JButton("√"); butSquareRoot.setBackground(Color.yellow);
        butExponent = new JButton("2^x"); butExponent.setBackground(Color.yellow);
        butClear = new JButton("Clear"); butClear.setBackground(Color.white);
    }

    public void init() {
        frame.setVisible(true);
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.add(text);
        for (int x = 0; x < 10; x++) {
            panel.add(but[x]);
            but[x].addActionListener(this);
        }

        panel.add(butAddition);
        panel.add(butSubtraction);
        panel.add(butMultiplication);
        panel.add(butDivision);
        panel.add(butExponent);
        panel.add(butSquare);
        panel.add(butSquareRoot);
        panel.add(butCubic);
        panel.add(butCosine);
        panel.add(butSine);
        panel.add(butTangent);

        panel.add(butEquals);
        panel.add(butClear);

        butAddition.addActionListener(this);
        butSubtraction.addActionListener(this);
        butMultiplication.addActionListener(this);
        butExponent.addActionListener(this);
        butDivision.addActionListener(this);
        butSquare.addActionListener(this);
        butSquareRoot.addActionListener(this);
        butCubic.addActionListener(this);
        butCosine.addActionListener(this);
        butSine.addActionListener(this);
        butTangent.addActionListener(this);

        butEquals.addActionListener(this);
        butClear.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final Object source = e.getSource();

        for (int i = 0; i < 10; i++) {
            if (source == but[i]) {
                text.replaceSelection(buttonValue[i]);
                return;
            }
        }

        if (source == butAddition) {
            setOutput(mp7calc.calculateSimple(mainCalculator.simpleOperators.addition, readInput()));
        }
        
        if (source == butMultiplication) {
            setOutput(mp7calc.calculateSimple(mainCalculator.simpleOperators.multiplication,
                readInput()));
        }

        if (source == butSubtraction) {
            setOutput(mp7calc.calculateSimple(mainCalculator.simpleOperators.subtraction, readInput()));
        }

        if (source == butDivision) {
            setOutput(mp7calc
                .calculateSimple(mainCalculator.simpleOperators.division, readInput()));
        }
        
        if (source == butCosine) {
            setOutput(mp7calc.calculateComplex(mainCalculator.complexOperators.cosine,
                readInput()));
        }

        if (source == butSine) {
            setOutput(mp7calc.calculateComplex(mainCalculator.complexOperators.sine,
                readInput()));
        }

        if (source == butTangent) {
            setOutput(mp7calc.calculateComplex(mainCalculator.complexOperators.tangent,
                readInput()));
        }
        
        if (source == butExponent) {
            setOutput(mp7calc.calculateComplex(mainCalculator.complexOperators.exponent, readInput()));
        }
        
        if (source == butSquare) {
            setOutput(mp7calc.calculateComplex(mainCalculator.complexOperators.square,
                readInput()));
        }

        if (source == butSquareRoot) {
            setOutput(mp7calc.calculateComplex(mainCalculator.complexOperators.squareRoot,
                readInput()));
        }

        if (source == butCubic) {
            setOutput(mp7calc.calculateComplex(
            		mainCalculator.complexOperators.cubic, readInput()));
        }

        if (source == butEquals) {
            setOutput(mp7calc.calculateEqual(readInput()));
        }

        if (source == butClear) {
            setOutput(mp7calc.reset());
        }

        text.selectAll();
    }

    public Double readInput() {
        Double input;
        String string = text.getText();
        input = Double.valueOf(string);

        return input;
    }

    public void setOutput(final Double input) {
        if (Double.isNaN(input)) {
            text.setText("");
        } else {
            text.setText(Double.toString(input));
        }
    }
}