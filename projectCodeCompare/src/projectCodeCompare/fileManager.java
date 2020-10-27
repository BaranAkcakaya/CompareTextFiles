package projectCodeCompare;
import java.io.*;
import java.util.ArrayList;

public class fileManager {
	private IfileProcess<File> fileProcess;
	
	public fileManager(IfileProcess<File> fileProcess) {
		this.fileProcess = fileProcess;
	}
	
	public void loadFile(File file) {
		fileProcess.loadFile(file);
	}
	
	public ArrayList<String> readFile(File file) {
		return fileProcess.readFile(file);
	}
	
	public void writeFile(File file) {
		fileProcess.writeFile(file);
	}
}
