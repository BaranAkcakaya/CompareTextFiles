package projectCodeCompare;
import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class mainFile implements IfileProcess<File> {

	private Scanner reader;
	private ArrayList<String> listOfMain = new ArrayList<String>();
	@Override
	public void loadFile(File file) {
		if(file.exists()) {
			System.out.println("Dosya adý : " + file.getName());
            System.out.println("Dosya yolu : " + file.getAbsolutePath());
            System.out.println("Dosya yazýlabilir mi : " + file.canWrite());
            System.out.println("Dosya okunabilir mi : " + file.canRead());
            System.out.println("Dosya boyutu (byte) : " + file.length());
		}
	}

	@Override
	public ArrayList<String> readFile(File file) {
		try {
			System.out.println(file);
			reader = new Scanner(file);
            while (reader.hasNextLine()){
//        		strSplit = strSplit.replaceAll("\\s+", "");
                String line = reader.nextLine();
                listOfMain.add(line.toLowerCase(Locale.ENGLISH));
            }
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			reader.close();
			System.out.println("Dosya okundu");
		}
		return listOfMain;
		
	}

	@Override
	public void writeFile(File file) {
		try {
            BufferedWriter writer =new BufferedWriter(new FileWriter(file,true));
            writer.newLine();
            writer.write("EKLEME::>----------------------------------");
            System.out.println("Dosyaya yazýldý");
            writer.close();
        } 
		catch (IOException e) {
            e.printStackTrace();
        }
		
	}

}
