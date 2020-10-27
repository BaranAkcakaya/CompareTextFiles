package projectCodeCompare;
import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class secondFile implements IfileProcess<File>{

	private Scanner reader;
	private ArrayList<String> listOfSecond = new ArrayList<String>();
	@Override
	public void loadFile(File file) {
		if(file.exists()) {
			System.out.println("Dosya ad� : " + file.getName());
            System.out.println("Dosya yolu : " + file.getAbsolutePath());
            System.out.println("Dosya yaz�labilir mi : " + file.canWrite());
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
                String line = reader.nextLine();
                listOfSecond.add(line.toLowerCase(Locale.ENGLISH));
            }
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			reader.close();
			System.out.println("Dosya okundu");
		}
		return listOfSecond;
		
	}

	@Override
	public void writeFile(File file) {
		try {
            BufferedWriter writer =new BufferedWriter(new FileWriter(file,true));
            writer.newLine();
            writer.write("EKLEME::>----------------------------------");
            System.out.println("Dosyaya yaz�ld�");
            writer.close();
        } 
		catch (IOException e) {
            e.printStackTrace();
        }
		
	}


}
