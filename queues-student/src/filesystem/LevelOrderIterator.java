package filesystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import structures.Queue;

/**
 * An iterator to perform a level order traversal of part of a 
 * filesystem. A level-order traversal is equivalent to a breadth-
 * first search.
 * 
 * @author liberato
 *
 */
public class LevelOrderIterator extends FileIterator<File> {
	Queue<File> file;
	/**
	 * Instantiate a new LevelOrderIterator, rooted at the rootNode.
	 * @param rootNode
	 * @throws FileNotFoundException if the rootNode does not exist
	 */
	public LevelOrderIterator(File rootNode) throws FileNotFoundException {
		// TODO 1
		file = new Queue<File>();
		if(!rootNode.exists()){
			throw new FileNotFoundException();
		}
		file.enqueue(rootNode);
	}
	
	@Override
	public boolean hasNext() {
		// TODO 2
		if(!file.isEmpty()){
			return true;
		}
		return false;
	}

	@Override
	public File next() throws NoSuchElementException {
		// TODO 3
		if(!hasNext()){
			throw new NoSuchElementException();
		}
		File temp = file.dequeue();
		if(temp.isDirectory()){
			File[] directory = temp.listFiles();
			for(int j = 0; j < directory.length; j++){
				file.enqueue(directory[j]);
			}
		}
		return temp;
	}

	@Override
	public void remove() {
		// Leave this one alone.
		throw new UnsupportedOperationException();		
	}

}
