package puzzle;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import search.SearchProblem;
import search.Solver;

/**
 * A class to represent an instance of the eight-puzzle.
 * 
 * The spaces in an 8-puzzle are indexed as follows:
 * 
 * 0 | 1 | 2
 * --+---+---
 * 3 | 4 | 5
 * --+---+---
 * 6 | 7 | 8
 * 
 * The puzzle contains the eight numbers 1-8, and an empty space.
 * If we represent the empty space as 0, then the puzzle is solved
 * when the values in the puzzle are as follows:
 * 
 * 1 | 2 | 3
 * --+---+---
 * 4 | 5 | 6
 * --+---+---
 * 7 | 8 | 0
 * 
 * That is, when the space at index 0 contains value 1, the space 
 * at index 1 contains value 2, and so on.
 * 
 * From any given state, you can swap the empty space with a space 
 * adjacent to it (that is, above, below, left, or right of it,
 * without wrapping around).
 * 
 * For example, if the empty space is at index 2, you may swap
 * it with the value at index 1 or 5, but not any other index.
 * 
 * Only half of all possible puzzle states are solvable! See:
 * https://en.wikipedia.org/wiki/15_puzzle
 * for details.
 * 

 * @author liberato
 *
 */
public class EightPuzzle implements SearchProblem<List<Integer>> {
	/**
	 * Creates a new instance of the 8 puzzle with the given starting values.
	 * 
	 * The values are indexed as described above, and should contain exactly the
	 * nine integers from 0 to 8.
	 * 
	 * @param startingValues
	 *            the starting values, 0 -- 8
	 * @throws IllegalArgumentException
	 *             if startingValues is invalid
	 */
	public List<Integer> startingValues;
	public Integer[][] board;
	
	public EightPuzzle(List<Integer> startingValues) {
		// TODO
		if(startingValues == null){
			throw new NullPointerException();
		}
		for(int f = 0; f < 9; f++){
			if(!startingValues.contains(f)){
				throw new IllegalArgumentException();
			}
		}
		this.startingValues = startingValues;
		int spaceNum = 0;
		board = new Integer[3][3];
		for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                  board[i][j] = startingValues.get(spaceNum);
                  spaceNum++;
            }
        }
	}

	@Override
	public List<Integer> getInitialState() {
		// TODO
		return startingValues;
	}

	@Override
	public List<List<Integer>> getSuccessors(List<Integer> currentState) {
		// TODO
		if(currentState == null){
			throw new NullPointerException();
		}
		List<List<Integer>> successors = new ArrayList<List<Integer>>();
		List<Integer> state1 = new ArrayList<Integer>();
		List<Integer> state2 = new ArrayList<Integer>();
		List<Integer> state3 = new ArrayList<Integer>();
		List<Integer> state4 = new ArrayList<Integer>();
		int indexOf = 0;
		while(currentState.get(indexOf) != 0){
			indexOf++;
		}
		int row = indexOf / 3;
		int col = indexOf % 3;
		//up
		if(row - 1 >= 0){
			for(int j = 0; j < 9; j++){
				state1.add(j, currentState.get(j));
			}
			int swap = indexOf - 3;
			int swapping = state1.get(swap);
			int zero = state1.get(indexOf);
			state1.set(indexOf, swapping);
			state1.set(swap, zero);
			successors.add(state1);
		}
		//down
		if(row + 1 <= 2){
			for(int j = 0; j < 9; j++){
				state2.add(j, currentState.get(j));
			}
			int swap = indexOf + 3;
			int swapping = state2.get(swap);
			int zero = state2.get(indexOf);
			state2.set(indexOf, swapping);
			state2.set(swap, zero);
			successors.add(state2);
		}
		//left
		if(col - 1 >= 0){
			for(int j = 0; j < 9; j++){
				state3.add(j, currentState.get(j));
			}
			int swap = indexOf - 1;
			int swapping = state3.get(swap);
			int zero = state3.get(indexOf);
			state3.set(indexOf, swapping);
			state3.set(swap, zero);	
			successors.add(state3);
		}
		//right
		if(col + 1 <= 2){
			for(int j = 0; j < 9; j++){
				state4.add(j, currentState.get(j));
			}
			int swap = indexOf + 1;
			int swapping = state4.get(swap);
			int zero = state4.get(indexOf);
			state4.set(indexOf, swapping);
			state4.set(swap, zero);		
			successors.add(state4);		
		}
		return successors;
	}

	@Override
	public boolean isGoal(List<Integer> state) {
		// TODO
		if(state == null){
			throw new NullPointerException();
		}
		int count = 1;
		for(int j = 0; j < state.size() - 1; j++){
			if(!state.get(j).equals(count)){
				return false;
			}
			count++;
		}
		if(state.get(8) != 0){
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		EightPuzzle e = new EightPuzzle(Arrays.asList(new Integer[] { 1, 2, 3,
				4, 0, 6, 7, 5, 8 }));
		List<List<Integer>> r = new Solver<List<Integer>>(e).solveWithBFS();
		for (List<Integer> l : r) {
			System.out.println(l);
		}
	}
}
