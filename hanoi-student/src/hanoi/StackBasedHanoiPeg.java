package hanoi;

import structures.LinkedStack;

/**
 * A {@link StackBasedHanoiPeg} is an implementation of {@link HanoiPeg}.
 * 
 * @author jcollard
 */
public class StackBasedHanoiPeg implements HanoiPeg {
	
    LinkedStack<HanoiRing> peg1;
	/**
	 * Creates a new {@link StackBasedHanoiPeg} that has no rings.
	 */
	public StackBasedHanoiPeg() {
		peg1 = new LinkedStack<HanoiRing>();
	}

	@Override
	public void addRing(HanoiRing ring) throws IllegalHanoiMoveException {
		if(ring == null){
			throw new NullPointerException();
		}
		if(hasRings() == true){
			if(ring.getSize() >= getTopRing().getSize()){
				throw new IllegalHanoiMoveException("Bad move");
			}
		}
		this.peg1.push(ring);
	}

	@Override
	public HanoiRing remove() throws IllegalHanoiMoveException {
		if(!hasRings()){
			throw new IllegalHanoiMoveException("Bad move");
		}
		HanoiRing peg = this.peg1.pop();
		return peg;
	}

	@Override
	public HanoiRing getTopRing() throws IllegalHanoiMoveException {
		if(!hasRings()){
			throw new IllegalHanoiMoveException("No Rings");
		}
		return this.peg1.peek();
	}

	@Override
	public boolean hasRings() {
		if(peg1.getSize() == 0){
			return false;
		}
		return true;
	}
}
