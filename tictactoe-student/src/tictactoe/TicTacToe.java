package tictactoe;
 
/**
 * An implementation of the TicTacToeGame interface.
 *
 * ATTENTION STUDENTS: You MUST use exactly this class specification. Do not
 * rename the class, and do not remove the "implements TicTacToeGame", or
 * you will receive no credit for your submission.
 */
public class TicTacToe implements TicTacToeGame {
        private String player1 = "X";
        private String player2 = "O";
        private String player0 = "";
        private int size = 0;
        private String[][] board;
        /**
         * Constructs a new instance, implementing the TicTacToeGame interface.
         *
         * ATTENTION STUDENTS: You MUST use exactly this signature for your constructor.
         * Do not rename the class and do not change the argument, or you will receive
         * no credit for your submission.
         *
         * @param n the length and width of the board; n >= 3
         */
        public TicTacToe(int n) {
                size = n;
                int spaceNum = 0;
                board = new String[size][size];
                for(int i = 0; i < n; i++){
                        for(int j = 0; j < n; j++){
                                String spacePlace = Integer.toString(spaceNum);
                                board[i][j] = spacePlace;
                                spaceNum++;
                        }
                }
               
        }
       
        @Override
        public int getN() {
                return size;
        }
 
        @Override
        public String toString() {
                String thisBoard = "";
                int count = 0;
                for(int i = 0; i < size; i++){
                        for(int j = 0; j < size;j++){
                                if(count % size == 0){
                                        thisBoard = thisBoard + "\n";
                            }
                            thisBoard = thisBoard + " " + board[i][j];
                            count++;
                        }
                }              
                return thisBoard;
        }
        
        @Override
        public String getWinner(){
                //horizontal
                for(int i = 0; i < size; i++){
                	    int countHx=0;
                	    int countHo=0;
                        for(int j = 0; j < size; j++){
                        if(board[i][j].equals("X") && board[i][size-1].equals("X")){
                                countHx++;
                                if(countHx == size){
                                        return player1;
                                }      
                        }
                        if(board[i][j].equals("O") && board[i][size-1].equals("O")){
                                countHo++;
                                if(countHo == size){
                                        return player2;
                                }                           
                        }
                        }
                }
                int countVx = 0; int countVo = 0;
                //vertical
                for(int i = 0; i < size; i++){
                        for(int j = 0; j < size; j++){
                                if(board[i][j].equals("X") && board[size - 1][j].equals("X")){
                                        countVx++;
                                        if(countVx == size){
                                                return player1;
                                        }  
                                }
                                if(board[i][j].equals("O") && board[size - 1][j].equals("O")){
                                        countVo++;
                                        if(countVo == size){
                                                return player2;
                                        } 
                                }
                        }
                }
                int countDsx = 0; int countDso = 0;
                //diagonal from start
                for(int i = 0; i < size; i++){
                        for(int j = 0; j < size; j++){
                                if(board[i][j].equals("X") && i == j){
                                        countDsx++;
                                        if(countDsx == size){
                                                return player1;
                                        }
                                }
                                if(board[i][j].equals("O") && i == j){
                                        countDso++;
                                        if(countDso == size){
                                                return player2;
                                        }
                                }
                        }
                }
                //diagonal from end
                int countDex = 0; int countDeo = 0; int countUpx = 0; int countUpo = 0;
                for(int i = size - 1; i >= 0; i--){
                                if(board[i][countUpx].equals("X")){
                                        countDex++;
                                        if(countUpx < size){
                                            countUpx++;}
                                        if(countDex == size){
                                                return player1;
                                        }
                                       
                                }
                                if(board[i][countUpo].equals("O")){
                                        countDeo++;
                                        if(countUpo < size){
                                            countUpo++;}
                                        if(countDeo == size){
                                                return player2;
                                        }     
                                }
                }
                //draw
                int countVar = 0;
                for(int i = 0; i < size; i++){
                    for(int j = 0; j < size; j++){
                            if(board[i][j].equals("X") || board[i][j].equals("O")){
                                    countVar++;
                                    if(countVar == size * size){
                                            return "";
                                    }
                                   
                            }
                    }
                }       
                return "";
        }
        @Override
        public String getCurrentPlayer() {
            int countX = 0;
            int countO = 0;
            for(int i = 0; i < size; i++){
               for(int j = 0; j < size; j++){
                    if(board[i][j].equals("X")){
                        countX++;
                    }
                    if(board[i][j].equals("O")){
                        countO++;
                    }           
               }
            }
            int total = countX + countO;
            if(countX == countO){
                    return player1;
            }
            if((countX > countO) && (total != size * size)){
                    return player2;
            }
            else{
            	    return player0;
            }
       }
 
        @Override
        public boolean isValidMove(int space) {
        	int row = space / size;
        	int column = space % size;
        	if(space >= size*size || space < 0){
        	   return false;
        	}
            if(board[row][column] == "X" || board[row][column] == "O"){
               return false;
            }
            if(getWinner() == player1 || getWinner() == player2){
               return false;
            }
            return true;
            
        }
 
        @Override
        public void move(int space) throws IllegalArgumentException {
        	if(isValidMove(space) == false){
        			throw new IllegalArgumentException("The problem is space:" + space);
            }
            for(int i = 0; i < size; i++){
                    for(int j = 0; j < size; j++){
                            if(board[i][j].equals(Integer.toString(space))){
                                    if(getCurrentPlayer() == player1){
                                            board[i][j] = "X";
                                    }
                                    else if(getCurrentPlayer() == player2){
                                            board[i][j] = "O";
                                    }
                                    else if(getCurrentPlayer() == player0){
                                    	    getWinner();
                                    }
                            } 
                    }
            }
        }             
}