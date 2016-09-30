package search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


/**
 * An implementation of a Searcher that performs an iterative search,
 * storing the list of next states in a Stack. This results in a
 * depth-first search.
 * 
 */
public class StackBasedDepthFirstSearcher<T> extends Searcher<T> {

	private final Stack<T> states;
	private final Stack<T> predecessors;
	
	public StackBasedDepthFirstSearcher(SearchProblem<T> searchProblem) {
		super(searchProblem);
		states = new Stack<T>();
		predecessors = new Stack<T>();
	}

	@Override
	public List<T> findSolution() {		
		if (solution != null) {
			return solution;
		}
		stackDFS(searchProblem.getInitialState(), states);
		if (predecessors.size() > 0) {
			if (!isValidSolution(predecessors)) {
				throw new RuntimeException(
						"searcher should never find an invalid solution!");
			}
		}
		return predecessors;
	}
	
	private void stackDFS(T state, Stack<T> path) {
		if(state == null || path == null){
			throw new NullPointerException();
		}
		states.push(state);
        while(!states.isEmpty()){
        	T holder = states.pop();
        	if(searchProblem.isGoal(holder)){
        		predecessors.push(holder);
        		break;
        	}
        	else{
        		visited.add(holder);
        		List<T> success = searchProblem.getSuccessors(holder);
        		Stack<T> noVisit = new Stack<T>();
        		for(int j = 0; j < success.size(); j++){
        			if(!visited.contains(success.get(j))){
        				noVisit.add(success.get(j));
        			}  		
        		}
        		if(noVisit.isEmpty()){
        		    while(noVisit.isEmpty()){
        		    	holder = predecessors.pop();
        		    	success = searchProblem.getSuccessors(holder);
        		    	for(int j = 0; j < success.size(); j++){
                			if(!visited.contains(success.get(j))){
                				noVisit.push(success.get(j));
                			}  		
                		}
        		    	
        		    }
        		    
        		}
        		for(int j = 0; j < noVisit.size(); j++){
        		    states.push(noVisit.get(j));		
        		}
        		predecessors.push(holder);
        	}
        	
        }
	}
	
}
