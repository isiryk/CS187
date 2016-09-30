package balancedbrackets;

import stack.ResizingArrayStack;

/**
 * BalancedBrackets contains a single public static utility method and should
 * not be instantiated. It is marked as abstract to prevent attempts to
 * instantiate it.
 */
public abstract class BalancedBrackets {
    /**
     * Return true if and only if the string s is well-formed with respect to
     * matching brackets
     *
     * @param s a string to check for well-formedness
     * @return true iff the string is well-formed
     */
    public static boolean isBalanced(String s) {
        // TODO
    	ResizingArrayStack<String> temp = new ResizingArrayStack<String>(s.length());
    	for(int j = 0; j < s.length(); j++){
   
    		if(s.charAt(j) == '{' || s.charAt(j) == '(' || s.charAt(j) == '['){
    			temp.push(Character.toString(s.charAt(j)));
    		}
    		if(s.charAt(j) == '}'){
    			if(temp.isEmpty()){
    				return false;
    			}
    			String check = temp.pop();
    			if(!check.equals("{")){
    				return false;
    			}
    		}
    		if(s.charAt(j) == ')'){
    			if(temp.isEmpty()){
    				return false;
    			}
    			String check = temp.pop();
    			if(!check.equals("(")){
    				return false;
    			}
    		}
    		if(s.charAt(j) == ']'){
    			if(temp.isEmpty()){
    				return false;
    			}
    			String check = temp.pop();
    			if(!check.equals("[")){
    				return false;
    			}
    		}
    	}
    	if(temp.isEmpty()){
           return true;
    	}
    	return false;
    }
}
