package search;

import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

/**
 * An implementation of a Searcher that performs an iterative search,
 * storing the list of next states in a Queue. This results in a
 * breadth-first search.
 * 
 */
public class QueueBasedBreadthFirstSearcher<T> extends Searcher<T> {
	
	private final LinkedList<T> states;
	private final LinkedList<T> predecessors;
	
	public QueueBasedBreadthFirstSearcher(SearchProblem<T> searchProblem) {
		super(searchProblem);
		states = new LinkedList<T>();
		predecessors = new LinkedList<T>();
	}

	@Override
	public List<T> findSolution() {
		// TODO
		if (solution != null) {
			return solution;
		}
		final LinkedList<T> path = new LinkedList<T>();
		queueBFS(searchProblem.getInitialState(), path);
		if (path.size() > 0) {
			if (!isValidSolution(path)) {
				throw new RuntimeException(
						"searcher should never find an invalid solution!");
			}
		}
		return path;
	}
	
	private void queueBFS(T state, LinkedList<T> path) {
		states.add(state);
        while(!states.isEmpty()){
        	T holder = states.remove();
        	if(searchProblem.isGoal(holder)){
        		predecessors.add(holder);
        		Collections.reverse(predecessors);
        		T check = predecessors.remove();
        		path.add(check);
        		while(!predecessors.isEmpty()){
        			List<T> successors = searchProblem.getSuccessors(check);
        			while(!successors.contains(check)){
        				check = predecessors.remove();
        			}
        			path.add(check);
        		}
        		Collections.reverse(path);
        		break;
        	}
        	else{
        		visited.add(holder);
        		List<T> success = searchProblem.getSuccessors(holder);
        		for(int j = 0; j < success.size(); j++){
        			if(!visited.contains(success.get(j))){
        				states.add(success.get(j));
        			}  		
        		}
        		predecessors.add(holder);
        	}
        	
        	
        }
        
	}
}
