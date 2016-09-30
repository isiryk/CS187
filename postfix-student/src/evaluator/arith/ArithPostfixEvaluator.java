package evaluator.arith;

import language.Operand;
import parser.IllegalPostfixExpressionException;
import parser.PostfixParser.Type;
import parser.Token;
import parser.arith.ArithPostfixParser;
import stack.StackInterface;
import evaluator.PostfixEvaluator;
import stack.LinkedStack;

/**
 * An {@link ArithPostfixEvaluator} is a postfix evaluator over simple arithmetic expressions.
 *
 */
public class ArithPostfixEvaluator implements PostfixEvaluator<Integer> {

	private final StackInterface<Operand<Integer>> stack;
	
	/**
	 * Constructs an {@link ArithPostfixEvaluator}
	 */
	public ArithPostfixEvaluator(){
		this.stack = new LinkedStack<Operand<Integer>>(); 
		//TODO initialize your LinkedStack
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer evaluate(String expr) throws IllegalPostfixExpressionException {
		// TODO use all of the things you've built so far to 
		// implement the algorithm for postfix expression evaluation
		
		ArithPostfixParser parser = new ArithPostfixParser(expr);
		for (Token<Integer> token : parser) {
			Type type = token.getType();
			switch(type){ 
			case OPERAND:
				//TODO What do we do when we see an operand?
				stack.push(token.getOperand());
				break;
			case OPERATOR:
				//TODO What do we do when we see an operator?
				if(token.getOperator().getNumberOfArguments() == 1){
					Operand<Integer> temp = stack.pop();
					token.getOperator().setOperand(0, temp);
					Operand<Integer> temp1 = token.getOperator().performOperation();
					stack.push(temp1);
				}
				if(token.getOperator().getNumberOfArguments() == 2){
					Operand<Integer> operand2 = stack.pop();
					Operand<Integer> operand1 = stack.pop();
					token.getOperator().setOperand(0, operand1);
					token.getOperator().setOperand(1, operand2);
					Operand<Integer> result = token.getOperator().performOperation();
					stack.push(result);
				}				
				break;
			default:
				throw new IllegalStateException("Parser returned an invalid Type: " + type);
			}			
		}
		
		//TODO What do we return?
		if(stack.size() == 1){
		   return stack.pop().getValue();
		}
		throw new IllegalPostfixExpressionException();
	}

}
