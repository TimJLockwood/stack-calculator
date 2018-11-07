import java.util.Stack;
import java.util.HashMap;
import java.util.Map;


public class Calculator {
	private Stack<Integer> calculatorStack = new Stack<>();
	private Map<Character, Integer> varMap = new HashMap<>();
	
	public void loadConstant(int i) {
		calculatorStack.push(i);
	}

	public void add() {
		int y = calculatorStack.pop();
		int x = calculatorStack.pop();
		int z = x + y;
		calculatorStack.push(z);		
	}

	public void subtract() {
		int y = calculatorStack.pop();
		int x = calculatorStack.pop();
		int z = x - y;
		calculatorStack.push(z);				
	}

	public void multiply() {
		int y = calculatorStack.pop();
		int x = calculatorStack.pop();
		int z = x * y;
		calculatorStack.push(z);		
	}

	public void divide() {
		int y = calculatorStack.pop();
		int x = calculatorStack.pop();
		int z = x / y;
		calculatorStack.push(z);		
	}

	public void total() {
		int total = 0;
		for(int i: calculatorStack) {
			total+=i;
		}
		calculatorStack.clear();
		calculatorStack.push(total);
	}
	
	@Override
	public String toString() {
		return calculatorStack.toString().replaceAll(",", "") + ".";
		
	}

	public void saveVar(char varName) {
		varMap.put(varName, calculatorStack.pop());
	}

	public Object getAllVars() {
		return varMap.toString().replaceAll("\\{", "").replaceAll("\\}", "");
	}

	public void loadVar(char varName) {
		calculatorStack.push(varMap.get(varName));
	}
}
