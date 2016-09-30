package hangman;

/**
 * The Array implementation of the GameModel interface.
 */
public class ArrayGameModel implements GameModel {
	/** The number of characters (lower/upper). */
	private static final int ALPHABET_COUNT = 26*2;
	
	/** hung state */
	private int	state;
	private String guessWord;
	private int amtGuesses = 0;
	private char[] guesses = new char[ALPHABET_COUNT];
	private char[] word;
	private char[] correctWord;
	
	/**
	 * Creates a new ArrayGameModel object.
	 * 
	 *  guessWord the word to guess
	 */
	public ArrayGameModel(String guessWord) {
		// TODO (1)
		state = STARTING_STATE;
		this.guessWord = guessWord;
		word = new char[guessWord.length()];
		for(int j = 0; j < guessWord.length(); j++){
			word[j] = guessWord.charAt(j);
		}
		correctWord = new char[guessWord.length()];
		for(int j = 0; j < guessWord.length(); j++){
			correctWord[j] = '_';
		}
	}
		
	public boolean isPriorGuess(char guess) {
		// TODO (2)
		for(int j = 0; j < guesses.length; j++){
			if(guesses[j] == guess){
				return true;
			}
		}
		return false;
	}
	
	public int numberOfGuesses() {
		// TODO (3)
		return amtGuesses;
	}
	
	public boolean isCorrectGuess(char guess) {
		// TODO (4)
		for(int j = 0; j < word.length; j++){
			if(word[j] == guess){
				return true;
			}
		}
		return false;
	}
	
	public boolean doMove(char guess) {
		// TODO (5)
		if(isPriorGuess(guess)){
			return false;
		}
		else if(isPriorGuess(guess) == false && isCorrectGuess(guess) == true){
			for(int j = 0; j < word.length; j++){
				if(word[j] == guess){
					correctWord[j] = guess;
					guesses[amtGuesses] = guess;
					amtGuesses++;
				}
			}
			return true;
		}
		else{
			guesses[amtGuesses] = guess;
			amtGuesses++;
			state++;
			return false;	
		}
		
			

	}

	public boolean inWinningState() {
		// TODO (6)
		int count = 0;
	    for(int j = 0; j < word.length; j++){
	    	if(word[j] == correctWord[j]){
	    		count++;
	    		if(count == guessWord.length()){
	    			return true;
	    		}
	    	}
	    	
	    }
	    return false;
        
	}

	public boolean inLosingState() {
		// TODO(7)
		if(state == 10){
			return true;
		}
		else{
			return false;
		}
	}
	
	public String toString() {
		String s = "";
		// TODO (8)
		for(int j = 0; j < correctWord.length; j++){
			if(j < correctWord.length -1){
				s = s + correctWord[j] + " ";
			}
			else{
				s = s + correctWord[j];
			}
		}
		return s;
	}

	public String previousGuessString() {
		// TODO (9)
		String s = "";
		String f = "[" + s + "]";
		for(int j = 0; j < amtGuesses; j++){
           s = s + guesses[j];
           f = "[" + s + "]";
           s = s + ", ";
		}
		return f;
	}
	
	public int getState() {
		return state;
	}

	public String getWord() {

		// TODO (10)

		return guessWord;
	}
  
}