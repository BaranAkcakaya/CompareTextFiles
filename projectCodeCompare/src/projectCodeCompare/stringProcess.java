package projectCodeCompare;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

public class stringProcess{
	
	private ArrayList<String> listOfMain;
	private ArrayList<String> listOfSecond;
	private ArrayList<String> listOfNotToBeMain = new ArrayList<String>() ;
	private ArrayList<String> listOfNotToBeSecond = new ArrayList<String>() ;
	private ArrayList<Entry<Integer,String>>  listOfTuple = new ArrayList<Entry<Integer,String>>();
	private javaFrame javaFrame = new javaFrame();
	
	public void process(File fileMain, File fileSecond) {
		javaFrame.setLocation(100,100);
		javaFrame.setVisible(true);
		javaFrame.setTitle("Code Compare");
		javaFrame.jTextPane2.addMouseListener(new MouseAdapter() {
       	 @Override
         public void mouseClicked(MouseEvent e) {
	           if (e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e)) {
//	             System.out.println("Double Click.");
	             JFrame jframeClick = new JFrame("Just Different Detail");
	             jframeClick.setBackground(Color.BLUE);
	             JTextPane jTextPane = new JTextPane();
	             JTextPane jTextPaneLine = new JTextPane();
	             JScrollPane jScrollPane = new JScrollPane();
	             jTextPaneLine.setBackground(Color.RED);
	             jTextPaneLine.setForeground(Color.BLACK);
	             jTextPaneLine.setEditable(false);
	             jTextPane.setEditable(false);
	             
	             for(Entry<Integer,String> tuple:listOfTuple) {
	            	if(!tuple.getValue().isEmpty()) {
	            		jTextPane.setContentType("text/html");
		            	jTextPaneLine.setContentType("text/html");
		         		HTMLDocument doc1 = (HTMLDocument) jTextPane.getDocument();
		         		HTMLDocument doc2 = (HTMLDocument) jTextPaneLine.getDocument();
		         		HTMLEditorKit kit1 = (HTMLEditorKit) jTextPane.getEditorKit();
		         		HTMLEditorKit kit2 = (HTMLEditorKit) jTextPaneLine.getEditorKit();
		         		try {
		         			kit1.insertHTML(doc2,doc2.getLength(),"<p style='font-size: 12.0;'>"+ String.valueOf(tuple.getKey()+1) +" </p>",0,0,null);
		         			kit2.insertHTML(doc1,doc1.getLength(),"<p style='font-size: 12.0;'><b style='color:red;'>"+ tuple.getValue() +" </b></p>",0,0,null);
		         		}catch (Exception e1) {
		     				System.out.println(e1.getMessage());
		     			}
	            	}
	             }
	             
	             jScrollPane.getViewport().add(jTextPane);
	             jScrollPane.setRowHeaderView(jTextPaneLine);
	             jframeClick.add(jScrollPane);
	             jframeClick.setSize(600,700);
	             jframeClick.setLocationRelativeTo(null);
	             jframeClick.setVisible(true);
	             
	           }
	         }
		});
		fileManager fileManagerMain = new fileManager(new mainFile());
		fileManager fileManagerSecond = new fileManager(new secondFile());

		String[] folderListMain = fileMain.list();
		String[] folderListSecond = fileSecond.list();
		Arrays.sort(folderListMain);
		Arrays.sort(folderListSecond);
		
		for (String foldM:folderListMain) {
			if (!foldM.isEmpty()) {
				System.out.println("Dosya okunuyor.");
				listOfMain = fileManagerMain.readFile(new File(fileMain + "\\" + foldM));
			}
		}
		for (String foldS:folderListSecond) {
			if (!foldS.isEmpty()) {
				System.out.println("Dosya okunuyor.");
				listOfSecond = fileManagerSecond.readFile(new File(fileSecond + "\\" + foldS));
			}
		}		
		
		if(!listOfMain.isEmpty()) {
			for(String aa:listOfMain) {
				listOfNotToBeMain.add(aa.replaceAll("\\s+", ""));
			}
		}
		if(!listOfSecond.isEmpty()) {
			for(String aa:listOfSecond) {
				listOfNotToBeSecond.add(aa.replaceAll("\\s+", ""));
			}
		}
		
		listCompare();
		
		listOfTuple.clear();
		if(listOfMain.size() >= listOfSecond.size()) {
			for(int a=0;a<listOfMain.size();a++) {
				if(a < listOfSecond.size()) {
					if((listOfMain.get(a).replaceAll("\\s+", "")).equals(listOfSecond.get(a).replaceAll("\\s+", ""))) {
						if(listOfMain.get(a).isEmpty()) {
							javaFrame.javaInsertM("<p style='font-size: 12.0;'> </p>");
							javaFrame.javaInsertS("<p style='font-size: 12.0;'> </p>");
						}else {
							javaFrame.javaInsertM("<p style='font-size: 12.0;'>"+listOfMain.get(a).replaceAll("<", "< ")+"</p>");
							javaFrame.javaInsertS("<p style='font-size: 12.0;'>"+listOfSecond.get(a).replaceAll("<", "< ")+"</p>");
						}
					}else {
						if(listOfMain.get(a).equals("&")) {
							javaFrame.javaInsertM("<p style='font-size: 12.0;'> </p>");
							javaFrame.javaInsertS("<p style='font-size: 12.0;'><b style='color:red;'>"+listOfSecond.get(a).replaceAll("<", "< ")+"</b></p>");
						}else if(listOfSecond.get(a).equals("&")) {
							javaFrame.javaInsertM("<p style='font-size: 12.0;'><b style='color:red;'>"+listOfMain.get(a).replaceAll("<", "< ")+"</b></p>");
							javaFrame.javaInsertS("<p style='font-size: 12.0;'> </p>");
						}else {
							javaFrame.javaInsertM("<p style='font-size: 12.0;'><b style='color:red;'>"+listOfMain.get(a).replaceAll("<", "< ")+"</b></p>");
							javaFrame.javaInsertS("<p style='font-size: 12.0;'><b style='color:red;'>"+listOfSecond.get(a).replaceAll("<", "< ")+"</b></p>");
						}
						listOfTuple.add(new java.util.AbstractMap.SimpleEntry<Integer,String>(a,listOfSecond.get(a)));
					}
				}else {
					if(listOfMain.get(a).replaceAll("\\s+", "").isEmpty()) {
						javaFrame.javaInsertM("<p style='font-size: 12.0;'> </p>");
						javaFrame.javaInsertS("<p style='font-size: 12.0;'> </p>");
					}else {
						javaFrame.javaInsertM("<p style='font-size: 12.0;'><b style='color:red;'>"+listOfMain.get(a).replaceAll("<", "< ")+"</b></p>");
						javaFrame.javaInsertS("<p style='font-size: 12.0;'></p>");
					}
				}
				javaFrame.linesCount();
			}
		}else {
			for(int a=0;a<listOfSecond.size();a++) {
				if(a < listOfMain.size()) {
					if((listOfMain.get(a).replaceAll("\\s+", "")).equals(listOfSecond.get(a).replaceAll("\\s+", ""))) {
						if(listOfMain.get(a).isEmpty()) {
							javaFrame.javaInsertM("<p style='font-size: 12.0;'> </p>");
							javaFrame.javaInsertS("<p style='font-size: 12.0;'> </p>");
						}else {
							javaFrame.javaInsertM("<p style='font-size: 12.0;'>"+listOfMain.get(a).replaceAll("<", "< ")+"</p>");
							javaFrame.javaInsertS("<p style='font-size: 12.0;'>"+listOfSecond.get(a).replaceAll("<", "< ")+"</p>");
						}
					}else {
						if(listOfMain.get(a).equals("&")) {
							javaFrame.javaInsertM("<p style='font-size: 12.0;'> </p>");
							javaFrame.javaInsertS("<p style='font-size: 12.0;'><b style='color:red;'>"+listOfSecond.get(a).replaceAll("<", "< ")+"</b></p>");
						}else if(listOfSecond.get(a).equals("&")) {
							javaFrame.javaInsertM("<p style='font-size: 12.0;'><b style='color:red;'>"+listOfMain.get(a).replaceAll("<", "< ")+"</b></p>");
							javaFrame.javaInsertS("<p style='font-size: 12.0;'> </p>");
						}else {
							javaFrame.javaInsertM("<p style='font-size: 12.0;'><b style='color:red;'>"+listOfMain.get(a).replaceAll("<", "< ")+"</b></p>");
							javaFrame.javaInsertS("<p style='font-size: 12.0;'><b style='color:red;'>"+listOfSecond.get(a).replaceAll("<", "< ")+"</b></p>");
						}
						listOfTuple.add(new java.util.AbstractMap.SimpleEntry<Integer,String>(a,listOfSecond.get(a)));
					}
				}else {
					if(listOfSecond.get(a).replaceAll("\\s+", "").isEmpty()) {
						javaFrame.javaInsertM("<p style='font-size: 12.0;'> </p>");
						javaFrame.javaInsertS("<p style='font-size: 12.0;'> </p>");
					}else {
						javaFrame.javaInsertS("<p style='font-size: 12.0;'><b style='color:red;'>"+listOfSecond.get(a).replaceAll("<", "< ")+"</b></p>");
						javaFrame.javaInsertM("<p style='font-size: 12.0;'></p>");
					}
				}
				javaFrame.linesCount();
			}
		}
			
		listOfNotToBeMain.clear();
		listOfNotToBeSecond.clear();
		listOfMain.clear();
		listOfSecond.clear();
	}
	
	private void listCompare() {
		int count = 0;
		int tempM = 0 ;
		int strM = listOfMain.size();
		int strS = listOfSecond.size();
		int strA = 0;
		int tempS ;
		String strMain ;
		while(listOfNotToBeMain.size() > count) {
			strMain = listOfNotToBeMain.get(count).replaceAll("\\s+", "");
			if(!strMain.isEmpty()) {
				if(listOfNotToBeSecond.contains(strMain)) {
//					System.out.println(strMain);
					tempS = listOfNotToBeSecond.indexOf(strMain);
					tempM = count;
//					System.out.println("Second:"+tempS);
//					System.out.println("Main:"+tempM);
//					System.out.println(strA);
					if(strA <listOfNotToBeSecond.size() && strA < listOfNotToBeMain.size()) {
						if(tempS>tempM) {
							for(int i=0;i<tempS-tempM;i++) {
								listOfMain.add(((strM+strA)-listOfNotToBeMain.size())+listOfNotToBeMain.indexOf(strMain),"&");
							}
							strA += (tempS-tempM);
							listOfNotToBeSecond = new ArrayList<String>(listOfNotToBeSecond.subList(tempS+1, listOfNotToBeSecond.size()));
							listOfNotToBeMain = new ArrayList<String>(listOfNotToBeMain.subList(tempM+1, listOfNotToBeMain.size()));
							count = -1;
						}else if(tempS<tempM) {
							for(int i=0;i<tempM-tempS;i++) {
								listOfSecond.add(((strS+strA)-listOfNotToBeSecond.size())+listOfNotToBeSecond.indexOf(strMain),"&");
							}
							strA += (tempM-tempS);
							listOfNotToBeSecond = new ArrayList<String>(listOfNotToBeSecond.subList(tempM+1, listOfNotToBeSecond.size()));
							listOfNotToBeMain = new ArrayList<String>(listOfNotToBeMain.subList(tempM+1, listOfNotToBeMain.size()));
							count = -1;
						}else {
							listOfNotToBeSecond = new ArrayList<String>(listOfNotToBeSecond.subList(tempM+1, listOfNotToBeSecond.size()));
							listOfNotToBeMain = new ArrayList<String>(listOfNotToBeMain.subList(tempM+1, listOfNotToBeMain.size()));
							count = -1;
						}
					}
				}
			}
				count++;
		}
	}
}
