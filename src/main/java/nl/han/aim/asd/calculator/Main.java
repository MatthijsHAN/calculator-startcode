package nl.han.aim.asd.calculator;

import nl.han.aim.asd.expression.Expression;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import nl.han.aim.asd.parser.*;
import java.util.Scanner;

/**
 * Created by Michel Koolwaaij on 10-10-18.
 */
public class Main {
    public static void main(String[] args){
        // Read expression from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an expression: ");
        String expressionString = scanner.nextLine();

        // Create pipeline
        CharStream stream = CharStreams.fromString(expressionString);
        ExpressionsLexer lexer = new ExpressionsLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        ExpressionsParser parser = new ExpressionsParser(tokens); // Tot hier alleen maar aanroepen

        // Try to match expressionString to the start rule and create parse tree
        ParseTree tree = parser.start(); // Ook deze krijg ik cadeau

        // Walk through parse tree using our own listener
        ParseTreeWalker walker = new ParseTreeWalker(); // En deze
        ExpressionReader reader = new ExpressionReader(); // Alleen deze maak ik zelf
        walker.walk(reader, tree); // En deze krijg ik weer cadeau

        // Druk de AST af
        System.out.println("Input: " + expressionString);

        // TODO 4.3 1a -- Maak AST-classes in de expression package.
        System.out.println("AST: " + reader.getTopExpression());

        // TODO 4.3 2 -- Implementeer een Evaluator klasse met een
        //  methode double eval(Expression ast) die de sommen uitrekent.
        // Evalueer de expressie
        System.out.println("Evaluatie: " + expressionString + " = "
                + new Evaluator().evaluate(reader.getTopExpression()));

//        Expression tree4 = new Expression();
//        tree4.setContent("6");
//        tree4.setLeft(null);
//        tree4.setRight(null);
//
//        Expression tree2 = new Expression();
//        tree2.setContent("5");
//        tree2.setLeft(tree4);
//        tree2.setRight(null);
//
//        Expression tree3 = new Expression();
//        tree3.setContent("3");
//        tree3.setLeft(null);
//        tree3.setRight(null);
//
//        Expression tree = new Expression();
//        tree.setContent("2");
//        tree.setLeft(tree2);
//        tree.setRight(tree3);
//
//        System.out.println(tree);
    }
}
