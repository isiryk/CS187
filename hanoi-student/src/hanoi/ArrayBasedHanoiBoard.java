package hanoi;

/**
 * A {@link ArrayBasedHanoiBoard} is a simple implementation of
 * {@link HanoiBoard}
 * 
 * @author jcollard
 * 
 */
public class ArrayBasedHanoiBoard implements HanoiBoard {
	StackBasedHanoiPeg[] peg = new StackBasedHanoiPeg[3];
	int size;
	/**
	 * Creates a {@link ArrayBasedHanoiBoard} with three empty {@link HanoiPeg}s
	 * and {@code n} rings on peg 0.
	 */
	public ArrayBasedHanoiBoard(int n) {
		if(n < 0){
			throw new IllegalArgumentException();
		}
		peg[0] = new StackBasedHanoiPeg();
		peg[1] = new StackBasedHanoiPeg();
		peg[2] = new StackBasedHanoiPeg();
		for(int j = n; j > 0; j--){
			peg[0].addRing(new HanoiRing(j)); 
		}
		size = n;	
	}

	@Override
	public void doMove(HanoiMove move) throws IllegalHanoiMoveException {
		if (!isLegalMove(move)) {
			throw new IllegalHanoiMoveException(
					"Could not perform illegal move.");
		}
		HanoiRing ring = peg[move.getFromPeg()].remove();
		peg[move.getToPeg()].addRing(ring);
		
	}

	@Override
	public boolean isSolved() {
		if(size == 0){
			return true;
		}
		if(!peg[0].hasRings() && !peg[1].hasRings() && peg[2].hasRings()){
			return true;
		}
		return false;
	}

	@Override
	public boolean isLegalMove(HanoiMove move) {
		if(move == null){
			throw new NullPointerException();
		}
		if(move.getFromPeg() == move.getToPeg()){
			return false;
		}
		if(peg[move.getFromPeg()].hasRings()){
			if(peg[move.getToPeg()].hasRings()){
				if(peg[move.getFromPeg()].getTopRing().getSize() > peg[move.getToPeg()].getTopRing().getSize()){
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
