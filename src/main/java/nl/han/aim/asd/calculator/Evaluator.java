package nl.han.aim.asd.calculator;

import nl.han.aim.asd.expression.Expression;

/**
 * Created by Michel Koolwaaij on 11-10-18.
 */
public class Evaluator {
    public double evaluate(Expression expression) {
        return expression.evaluate();
    }

    // TODO 4.3 2 -- Implementeer een Evaluator klasse met een
    //  methode double eval(Expression ast) die de sommen uitrekent.

}
