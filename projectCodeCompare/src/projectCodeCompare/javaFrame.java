package projectCodeCompare;

import java.awt.Color;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

public class javaFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	public void setLocation(int x, int y) {
		super.setLocation(x, y);
	}
	@Override
	public void setTitle(String title) {
		super.setTitle(title);
	}
	
    public javaFrame() {
        initComponents();
        setTitle("Code Compare");
        setLocation(100,100);
        
    }
    
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextPane1 = new javax.swing.JTextPane();
        jTextPane2 = new javax.swing.JTextPane();
        jTextPaneLine1 = new javax.swing.JTextPane();//
        jTextPaneLine2 = new javax.swing.JTextPane();//
        jTextPaneLine1.setBackground(Color.RED);//
        jTextPaneLine2.setBackground(Color.RED);//
        jTextPaneLine1.setEditable(false);//
        jTextPaneLine2.setEditable(false);//
        jScrollPane3 = new javax.swing.JScrollPane();//jTextPane1,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane4 = new javax.swing.JScrollPane();//jTextPane1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS)
        jScrollPane3.setRowHeaderView(jTextPaneLine1);//
        getContentPane().add(jScrollPane3);
        jScrollPane4.setRowHeaderView(jTextPaneLine2);//
        getContentPane().add(jScrollPane4);
        
	    
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        
        jScrollPane3.getHorizontalScrollBar().setModel(jScrollPane4.getHorizontalScrollBar().getModel());
        jScrollPane3.getVerticalScrollBar().setModel(jScrollPane4.getVerticalScrollBar().getModel());
        
        jPanel3.setBackground(new java.awt.Color(245, 245, 245));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setLabelFor(jPanel1);
        jLabel1.setText("DOSYA YOLU :");
        jLabel1.setToolTipText("");
        jLabel1.setAutoscrolls(true);
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField1.setText("C:\\");
        	
        jScrollPane3.setWheelScrollingEnabled(false);
        jScrollPane3.addMouseWheelListener(new MouseWheelListener() {
            public void mouseWheelMoved(MouseWheelEvent e) {
            	jScrollPane4.dispatchEvent(e);
            }
        });
        
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField1.setText("C:\\");
            jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jTextField1MouseClicked(evt);
                }
            });
        
            jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            jButton1.setText("Dosyayi Getir");
            jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addContainerGap())
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(32, 32, 32))
            );

            javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            jTextPane1.setSelectionColor(new java.awt.Color(0, 153, 0));
            jScrollPane3.setViewportView(jTextPane1);

            jTextPane2.setSelectionColor(new java.awt.Color(0, 0, 204));
            jScrollPane4.setViewportView(jTextPane2);

            javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
            jPanel3.setLayout(jPanel3Layout);
            jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addComponent(jScrollPane3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane4))
            );
            jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                        .addComponent(jScrollPane3)))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            pack();
        }
    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {
		String userDir = System.getProperty("user.home");
        JFileChooser fileChooser = new JFileChooser(userDir +"/Desktop");
        JFrame frame = new JFrame();
        final JLabel label = new JLabel();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int option = fileChooser.showOpenDialog(frame);
        if(option == JFileChooser.APPROVE_OPTION){
           File file = fileChooser.getSelectedFile();
           jTextField1.setText(file.getAbsolutePath());
           jTextField1.setEditable(false);
           jButton1ActionPerformed(null);
        }else{
           label.setText("Open command canceled");
        }
        
    } 

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    	String txtField = jTextField1.getText();
    	System.out.println(txtField);
    	if(txtField.isEmpty()) {
    		msgBox("Dosya Yolunu Bos girmeyin!");
    	}
    	else {
			File folder = new File(txtField);
			String[] folderList = folder.list();
			if(folderList.length != 2) {
				msgBox("Yanlis Dosya Yolu:"+txtField);
			}else {
				dispose();
	    		Main main = new Main();
	    		main.getFolder(txtField);
			}
		}
    }

    	public void msgBox(String msg) {
    		JOptionPane.showMessageDialog(null, msg);
    	}

    	public void javaInsertM(String msg) {

	    	jTextPane1.setContentType("text/html");
    		HTMLDocument doc = (HTMLDocument) jTextPane1.getDocument();
    		HTMLEditorKit kit = (HTMLEditorKit) jTextPane1.getEditorKit();
    		try {
    			kit.insertHTML(doc,doc.getLength(),msg + "\n",0,0,null);
    		}catch (Exception e) {
				System.out.println(e.getMessage());
			}
    		jTextPane1.setEditable(false);
    	}
    	
    	public void javaInsertS(String msg) {

	    	jTextPane2.setContentType("text/html");
    		HTMLDocument doc = (HTMLDocument) jTextPane2.getDocument();
    		HTMLEditorKit kit = (HTMLEditorKit) jTextPane2.getEditorKit();
    		try {
    			kit.insertHTML(doc,doc.getLength(),msg + "\n",0,0,null);
    		}catch (Exception e) {
				System.out.println(e.getMessage());
			}
    		jTextPane2.setEditable(false);
    	}
    	
    	public void linesCount() {
    		jTextPaneLine1.setContentType("text/html");
    		jTextPaneLine2.setContentType("text/html");
    		HTMLDocument doc1 = (HTMLDocument) jTextPaneLine1.getDocument();
    		HTMLDocument doc2 = (HTMLDocument) jTextPaneLine2.getDocument();
    		HTMLEditorKit kit1 = (HTMLEditorKit) jTextPaneLine1.getEditorKit();
    		HTMLEditorKit kit2 = (HTMLEditorKit) jTextPaneLine2.getEditorKit();
    		try {
    			kit1.insertHTML(doc1,doc1.getLength(),"<p style='font-size: 12.0;'>"+ String.valueOf(count) +" </p>",0,0,null);
    			kit2.insertHTML(doc2,doc2.getLength(),"<p style='font-size: 12.0;'>"+ String.valueOf(count) +" </p>",0,0,null);
    		}catch (Exception e) {
				System.out.println(e.getMessage());
			}
    		count = count + 1;
    	}

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(javaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(javaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(javaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(javaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new javaFrame().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextPane jTextPane1;
    protected javax.swing.JTextPane jTextPane2;
    private int count = 1;
    private javax.swing.JTextPane jTextPaneLine1;//
    private javax.swing.JTextPane jTextPaneLine2;//
}
