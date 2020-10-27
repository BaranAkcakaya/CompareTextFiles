package projectCodeCompare;

import java.io.File;
import java.util.Arrays;

public class Main {
	private javaFrame javaF = new javaFrame();

	public void getFolder(String folderPath){
		try {
			File folder = new File(folderPath);
			String[] folderList = folder.list();
			Arrays.sort(folderList);
			stringProcess stringProcess = new stringProcess();
			stringProcess.process(new File(folder+"\\"+folderList[0]),new File(folder+"\\"+folderList[1]));
		}catch (Exception e) {
			System.out.println("Error:"+e.getMessage()+"\nFolder Path:"+folderPath);
			javaF.msgBox("Error:"+e.getMessage()+"\nFolder Path:"+folderPath);
		}
	}

}
