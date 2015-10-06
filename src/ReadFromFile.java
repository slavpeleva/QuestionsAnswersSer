import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ReadFromFile {
	private ObjectInputStream input;
	
	private void openFile(){
		try {
			input = new ObjectInputStream(new FileInputStream("qa.ser"));
		} catch (FileNotFoundException e) {
			System.err.println("No such file");		
		} catch (IOException e) {
			System.err.println("Error opening file");			
		}
	}
	
	public ArrayList<Questions> readFromFile(){
		ArrayList<Questions> arr= null;
		try {
			openFile();
			arr = (ArrayList<Questions>)input.readObject();
			
		}  catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			closeFile();		}
		return arr;
	}
	
	private void closeFile(){
		try {
			if (input != null) {
				input.close();
			}
		} catch (IOException e) {
			System.err.println("Problem with closing file");
			//System.exit(1);
		}
	}
	public boolean isFileEmpty(){
		try {
			openFile();
		} catch (Exception e) {
			return true;
		}
		finally{
			closeFile();
		}
		return false;
	}
	
	
}

