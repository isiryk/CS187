package hangman;

public class LinkedListGameModel implements GameModel {
	
	private int state;
	private String guessWord;
	private int amtGuesses = 0;
	private LLCharacterNode guesses;
	private LLCharacterNode word;
	private LLCharacterNode correctWord;
	private int correct = 0;
	
	public LinkedListGameModel(String guessWord){
		state = STARTING_STATE;
		this.guessWord = guessWord;
		word = new LLCharacterNode(guessWord.charAt(guessWord.length() - 1));
		correctWord = new LLCharacterNode('_');
	//	for(int j = guessWord.length()-2; j >= 0; j--){
		for(int j = 0; j < guessWord.length(); j++){
			word = new LLCharacterNode(guessWord.charAt(j),word);
			correctWord = new LLCharacterNode('_');
		}
		
	}

	@Override
	public boolean isPriorGuess(char guess) {
		// TODO Auto-generated method stub
		LLCharacterNode t = guesses;
		while(t != null){
			if(t.getInfo() == guess || Character.isLetter(guess) != true){
				return true;
			}
			t = t.getLink();
	
		}
		return false;
	}

	@Override
	public int numberOfGuesses() {
		// TODO Auto-generated method stub
		return amtGuesses;
	}

	@Override
	public boolean isCorrectGuess(char guess) {
		// TODO Auto-generated method stub
		for(int j = 0; j < guessWord.length(); j++){
			if(guessWord.charAt(j) == guess){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean doMove(char guess) {
		// TODO Auto-generated method stub
		if(isPriorGuess(guess)){
			return false;
		}
		if(isCorrectGuess(guess) == true){
			if(guesses == null){
				guesses = new LLCharacterNode(guess);
			}
			else{
				LLCharacterNode t1 = guesses;
				while(t1.getLink() != null){
					t1 = t1.getLink();
				}
				t1.setLink(new LLCharacterNode(guess));
			}
			LLCharacterNode t2 = word;
			LLCharacterNode t3 = correctWord;
			while(t2 != null){
				if(t2.getInfo() == guess){
					t3.setInfo(guess);
					correct++;
				}
			    t2 = word.getLink();
				t3 = guesses.getLink();
			}
			return true;
		}
		else{
			if(isPriorGuess(guess) == false){
				amtGuesses++;
				state++;
				if(guesses == null){
					guesses = new LLCharacterNode(guess);
				}
				else{
					LLCharacterNode t1 = guesses;
					while(t1.getLink()!=null){
						t1 = t1.getLink();
					}
					t1.setLink(new LLCharacterNode(guess));
				}
			}
		    return false;
		    }
	}

	@Override
	public boolean inWinningState() {
		// TODO Auto-generated method stub
		if(correct == guessWord.length()){
			return true;
		}
		return false;
	}

	@Override
	public boolean inLosingState() {
		// TODO Auto-generated method stub
		if(state == 10){
			return true;
		}
		return false;
	}

	@Override
	public int getState() {
		// TODO Auto-generated method stub
		return state;
	}
	
	public String toString(){
		String s = "";
		LLCharacterNode t3 = correctWord;
		while(t3 != null){
			s = s + t3.getInfo() + " ";
			t3 = t3.getLink();
		}
		return s.substring(0, s.length() - 1);
	}

	@Override
	public String previousGuessString() {
		// TODO Auto-generated method stub
		String s = "";
		LLCharacterNode t = guesses;
		while(t != null){
			s = s + t.getInfo() + ", ";
			t = t.getLink();
		}
		return "[" + s.substring(0, s.length() - 2) + "]";
	}

	@Override
	public String getWord() {
		// TODO Auto-generated method stub
		return guessWord;
	}

}
