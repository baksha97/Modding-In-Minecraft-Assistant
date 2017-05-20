import java.io.*;

import javaxt.io.Directory;
import javax.swing.JFileChooser;

import helper.toTextArea;

/**
 *
 * @author abaks089
 *
 *
 * KNOWN BUGS:
 * 	>if folder layout does not follow protocols implemented, it will not work properly... example -> lesson03 post-repo
 * 	>does not delete src and then install post lesson repo, only replaces files in repo that are in the src. //not a big deal unless you're down-grading lessons
 *
 *
 */
public class CodeAdvLoader extends javax.swing.JFrame {

    private final String FIRE_POST_LESSON_DIR = "/Minecraft Code/FIRE/Post Lesson Repo";
    private final String FIRE_PRE_LESSON_DIR = "/Minecraft Code/FIRE/Pre Lesson Repo";
    private final String ICE_POST_LESSON_DIR = "/Minecraft Code/ICE/Post Lesson Repo";
    private final String ICE_PRE_LESSON_DIR = "/Minecraft Code/ICE/Pre Lesson Repo";
    private final String STUDENT_TEXTURES_DIR = "/StudentTextures";

    private final String SRC_DIR = File.separator + "Student1"+ File.separator +"src";
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * Creates new form CodeAdvLoader
     */

    public CodeAdvLoader() {
        super("Modding in Minecraft Loader v1.0");
        initComponents();
        // keeps reference of standard output stream
        PrintStream printStream = new PrintStream(new toTextArea(outputTextArea));
        standardOut = System.out;

        // re-assigns standard output stream and error output stream
        System.setOut(printStream);
        //  System.setErr(printStream); //--- prevents errors from coming out to text box
        showLoaderType();
    }

    //  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        loaderType = CurriculumType.FIRE;
        headerLabel = new javax.swing.JLabel();
        minecraftSelectLabel = new javax.swing.JLabel();
        minecraftPathField = new javax.swing.JTextField();
        minecraftBrowseButton = new javax.swing.JButton();
        preImportLabel = new javax.swing.JLabel();
        preLessonComboBox = new javax.swing.JComboBox();
        postImportLabel = new javax.swing.JLabel();
        postLessonComboBox = new javax.swing.JComboBox();
        importPreButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputTextArea = new javax.swing.JTextArea();
        importPostButton = new javax.swing.JButton();
        textureButton = new javax.swing.JButton();
        loaderMenuBar = new javax.swing.JMenuBar();
        switchCurriculumButton = new javax.swing.JButton();
        jMenu2 = new javax.swing.JMenu();
        fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        headerLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        headerLabel.setText("Code Advantage Loader: Modding in Minecraft");

        minecraftSelectLabel.setText("Select \"Minecraft\" folder:");

        minecraftPathField.setText("Select Folder with Repository, Student1, etc.)");
        minecraftPathField.setEditable(false);
        minecraftBrowseButton.setText("Browse");
        minecraftBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minecraftBrowseButtonActionPerformed(evt);
            }
        });

        preImportLabel.setText("Import Pre-Lesson Repository: ");

        preLessonComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Select Folder"}));

        postImportLabel.setText("Import Post-Lesson Repository: ");

        postLessonComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Select Folder"}));

        importPreButton.setText("Import Pre");
        importPreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importPreButtonActionPerformed(evt);
            }
        });

        outputTextArea.setEditable(false);
        outputTextArea.setEditable(false);
        outputTextArea.setColumns(20);
        outputTextArea.setRows(5);
        jScrollPane1.setViewportView(outputTextArea);

        importPostButton.setText("Import Post");
        importPostButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importPostButtonActionPerformed(evt);
            }
        });

        textureButton.setText("Add Student Texture to Minecraft SRC");
        textureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textureButtonActionPerformed(evt);
            }
        });

        switchCurriculumButton.setText("Switch Loader Type");
        switchCurriculumButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switchCurriculumButtonActionPerformed(evt);
            }
        });

        loaderMenuBar.add(switchCurriculumButton);

        jMenu2.setText("Edit");
        //  loaderMenuBar.add(jMenu2);

        setJMenuBar(loaderMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(preImportLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(preLessonComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(headerLabel)
                                                                .addGap(0, 115, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(minecraftSelectLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(minecraftPathField)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(minecraftBrowseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap())
                                                        .addComponent(importPreButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane1)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(postImportLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(postLessonComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(importPostButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addContainerGap())))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textureButton)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(headerLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minecraftPathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(minecraftSelectLabel)
                                        .addComponent(minecraftBrowseButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(preImportLabel)
                                        .addComponent(preLessonComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(importPreButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(postImportLabel)
                                        .addComponent(postLessonComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(importPostButton))
                                .addGap(11, 11, 11)
                                .addComponent(textureButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void minecraftBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int returnVal = fc.showOpenDialog(CodeAdvLoader.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            java.io.File file = fc.getSelectedFile();
            System.out.println(">Selected folder: " + file.getAbsolutePath() + "." );
            this.minecraftFolder = file;
            this.minecraftPathField.setText(file.getAbsolutePath());
            reloadComboBoxes();
        } else {
            System.out.println("Open command cancelled by user.");
        }

    }

    private void importPreButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Pre Lessons are not static and require logic. May implement at a later time. ");
        System.out.println("          Students should learn how to import code manually.");
    }

    private void importPostButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        try {
            saveCurrentTextures();
        }catch(FileNotFoundException e){
            System.out.println("Error cannot find textures");
            e.printStackTrace();
        }

        if(loaderType == CurriculumType.FIRE){
            File selectedJavaLessonSRC = new File(minecraftFolder.getAbsolutePath().toString() + this.FIRE_POST_LESSON_DIR + File.separator +postLessonComboBox.getModel().getSelectedItem() + File.separator +"JavaLessons");
            File selectedMinecraftLessonSRC = new File(minecraftFolder.getAbsolutePath().toString() + this.FIRE_POST_LESSON_DIR + File.separator +postLessonComboBox.getModel().getSelectedItem() + File.separator +"Minecraft");

            //java lesson import
            Directory inputJL = new Directory(selectedJavaLessonSRC.getAbsolutePath());
            Directory outputJL = new Directory(minecraftFolder.getAbsolutePath() + "/Student1/eclipse/JavaLessons");
            //	delete(new File(outputJL.getPath()));// FINDME -> might delete needed files, need to check
            inputJL.copyTo(outputJL, true);
            System.out.println("Copied FIRE JavaLessons to: " + outputJL.getPath());

            //MDK lesson import
            Directory inputMDK = new Directory(selectedMinecraftLessonSRC.getAbsolutePath());
            Directory outputMDK = new Directory(minecraftFolder.getAbsolutePath() + "/Student1");
            inputMDK.copyTo(outputMDK, true);
            System.out.println("Copied FIRE MDK/src to: " + outputMDK.getPath());
        }
        else if(loaderType == CurriculumType.ICE){
            File selectedJavaLessonSRC = new File(minecraftFolder.getAbsolutePath().toString() + this.ICE_POST_LESSON_DIR + File.separator  +postLessonComboBox.getModel().getSelectedItem() + File.separator +"JavaLessons");
            File selectedMinecraftLessonSRC = new File(minecraftFolder.getAbsolutePath().toString() + this.ICE_POST_LESSON_DIR + File.separator  +postLessonComboBox.getModel().getSelectedItem() + File.separator  +"Minecraft");

            //java lesson import
            Directory inputJL = new Directory(selectedJavaLessonSRC.getAbsolutePath());
            Directory outputJL = new Directory(minecraftFolder.getAbsolutePath() + "/Student1/eclipse/JavaLessons");
            //	delete(new File(outputJL.getPath()));// FINDME -> might delete needed files, need to check
            inputJL.copyTo(outputJL, true);
            System.out.println("Copied ICE JavaLessons to: " + outputJL.getPath());

            //MDK lesson import
            Directory inputMDK = new Directory(selectedMinecraftLessonSRC.getAbsolutePath());
            Directory outputMDK = new Directory(minecraftFolder.getAbsolutePath() + "/Student1");
            inputMDK.copyTo(outputMDK, true);
            System.out.println("Copied ICE MDK/src to: " + outputMDK.getPath());
        }
        else{
            System.out.println("Error reading loader type.");
        }
    }

    private void textureButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            addTexturesToSRC();
        }
        catch (FileNotFoundException e){
            System.out.println("Files not found... ");
        }
    }

    private void switchCurriculumButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        CurriculumType originalMode = loaderType;

        if(loaderType == CurriculumType.FIRE){
            loaderType = CurriculumType.ICE;
        }
        else{
            loaderType = CurriculumType.FIRE;
        }

        try{
            reloadComboBoxes();
        }catch(Exception e){
            System.out.println("ERROR: Switch aborted.");
            loaderType = originalMode;
        }
        showLoaderType();
    }

    // convience methods:

    private void showLoaderType(){
        headerLabel.setText("Code Advantage Loader: Modding in Minecraft: "+ loaderType);
        System.out.println("Loader type: " + loaderType);
    }

    private void reloadComboBoxes(){
        File[] directories;




        if(loaderType == CurriculumType.FIRE){
            //pre
            directories = getDictionaries(new File(minecraftFolder.getAbsolutePath() + this.FIRE_PRE_LESSON_DIR)); //new File(minecraftFolder.getAbsolutePath() + this.FIRE_PRE_LESSON_DIR).listFiles(File::isDirectory);
            String[] preLessons = new String[directories.length];
            for(int i =0; i< directories.length; i++){
                preLessons[i] = directories[i].getName();
            }
            preLessonComboBox.setModel(new javax.swing.DefaultComboBoxModel(preLessons));
            System.out.println("FIRE Pre Lessons Loaded: " + preLessons.length);
            //post
            directories = getDictionaries(new File(minecraftFolder.getAbsolutePath() + this.FIRE_POST_LESSON_DIR));
            String[] postLessons = new String[directories.length];
            for(int i =0; i< directories.length; i++){
                postLessons[i] = directories[i].getName();
            }
            postLessonComboBox.setModel(new javax.swing.DefaultComboBoxModel(postLessons));
            System.out.println("FIRE Post Lessons Loaded: " + postLessons.length);
        }
        else if(loaderType == CurriculumType.ICE){
            //pre
            directories = getDictionaries(new File(minecraftFolder.getAbsolutePath() + this.ICE_PRE_LESSON_DIR));
            String[] preLessons = new String[directories.length];
            for(int i =0; i< directories.length; i++){
                preLessons[i] = directories[i].getName();
            }
            preLessonComboBox.setModel(new javax.swing.DefaultComboBoxModel(preLessons));
            System.out.println("ICE Pre Lessons Loaded: " + preLessons.length);
            //post
            directories = getDictionaries(new File(minecraftFolder.getAbsolutePath() + this.ICE_POST_LESSON_DIR));
            String[] postLessons = new String[directories.length];
            for(int i =0; i< directories.length; i++){
                postLessons[i] = directories[i].getName();
            }
            postLessonComboBox.setModel(new javax.swing.DefaultComboBoxModel(postLessons));
            System.out.println("ICE Post Lessons Loaded: " + postLessons.length);
        }
        else{
            System.out.println("Error");
        }
    }

    private void addTexturesToSRC() throws FileNotFoundException{
        Directory srcDic = new Directory(minecraftFolder.getAbsolutePath()+"/Student1/src");
        Directory texturesDic = new Directory(minecraftFolder.getAbsolutePath()+STUDENT_TEXTURES_DIR);

        javaxt.io.File[] lessonImages = srcDic.getFiles("*.png", true);
        javaxt.io.File[] textures = texturesDic.getFiles("*.png", true);
        for(int x=0; x<textures.length; x++){
            for(int y=0; y<lessonImages.length; y++){
                if(textures[x].getName().equals(lessonImages[y].getName())){
                    textures[x].copyTo(lessonImages[y], true);
                    System.out.println();
                    System.out.println("Texture: " + textures[x]);
                    System.out.println(" -> moved to path: " + lessonImages[y]);
                }
            }
        }
    }

    private void saveCurrentTextures() throws FileNotFoundException{
        Directory srcDic = new Directory(minecraftFolder.getAbsolutePath()+SRC_DIR);
        Directory texturesDic = new Directory(minecraftFolder.getAbsolutePath()+STUDENT_TEXTURES_DIR);

        javaxt.io.File[] currentTextures = srcDic.getFiles("*.png", true);
        for(int i=0; i<currentTextures.length; i++){
            currentTextures[i].copyTo(texturesDic, false); //false, not overwriting any textures!
        }
    }

    //extensive functions

    private File[] getDictionaries(File dir){
        File[] directories = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
        return directories;
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CodeAdvLoader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CodeAdvLoader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CodeAdvLoader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CodeAdvLoader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CodeAdvLoader().setVisible(true);
            }
        });
    }

    // Variables declaration
    private JFileChooser fc;
    private java.io.File minecraftFolder;
    private CurriculumType loaderType;
    @SuppressWarnings("unused")
    private PrintStream standardOut;


    private javax.swing.JLabel headerLabel;
    private javax.swing.JButton importPostButton;
    private javax.swing.JButton importPreButton;
    private javax.swing.JButton switchCurriculumButton;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar loaderMenuBar;
    private javax.swing.JButton minecraftBrowseButton;
    private javax.swing.JTextField minecraftPathField;
    private javax.swing.JLabel minecraftSelectLabel;
    private javax.swing.JTextArea outputTextArea;
    private javax.swing.JLabel postImportLabel;
    private javax.swing.JComboBox postLessonComboBox;
    private javax.swing.JLabel preImportLabel;
    private javax.swing.JComboBox preLessonComboBox;
    private javax.swing.JButton textureButton;
    // End of variables declaration
}