package projectCodeCompare;

import java.util.ArrayList;

public interface IfileProcess<T> {
	
	public void loadFile(T file);
	public ArrayList<String> readFile(T file);
	public void writeFile(T file);
}
