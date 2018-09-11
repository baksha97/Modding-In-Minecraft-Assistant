import javaxt.io.Directory;
import utils.CommandExecutor;
import utils.enums.CurriculumType;
import utils.enums.ImportType;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ModdingAssistant extends JFrame {

    private JPanel contentPane;
    private final JComboBox<String> cbStudent;
    private final JComboBox<String>  cbCourse;
    private final JComboBox<String>  cbImportType;
    private final JComboBox<String>  cbLessonPlan;
    private final JTextPane txtOutput;

    private MinecraftModdingEnvironment enviornment;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
                ModdingAssistant frame = new ModdingAssistant();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */


    private void setDefaults() {
        cbStudent.setModel(new DefaultComboBoxModel<String>(MinecraftModdingEnvironment.getAvailableStudentsNames()));
        cbCourse.setModel(new DefaultComboBoxModel<>(CurriculumType.getNames()));
        cbImportType.setModel(new DefaultComboBoxModel<>(ImportType.getNames()));
        showAvailableLessons();
    }

    private void showAvailableLessons(){
        this.enviornment = new MinecraftModdingEnvironment(currentStudentDirectory());
        cbLessonPlan.setModel(new DefaultComboBoxModel<>(
                this.enviornment.getAvailableLessons(currentCurriculumType(), currentImportType())
        ));
    }

    private void performImport(){
        String lesson = (String) cbLessonPlan.getSelectedItem();
        this.enviornment.performImport(currentCurriculumType(), currentImportType(), lesson);
    }

    private Directory currentStudentDirectory(){
        int studentIndex = cbStudent.getSelectedIndex();
        Directory studentDir = MinecraftModdingEnvironment.getAvailableStudentsDirs()[studentIndex];
        return studentDir;
    }

    private CurriculumType currentCurriculumType(){
        return CurriculumType.valueOf((String) cbCourse.getSelectedItem());
    }
    private ImportType currentImportType(){
        return ImportType.valueOf((String) cbImportType.getSelectedItem());
    }

    public ModdingAssistant() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("Modding in Minecraft: ModdingAssistant");
        menu.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        menuBar.add(menu);

        JMenuItem mntmRunGradleSetup = new JMenuItem("Run Gradle Setup");
        mntmRunGradleSetup.addActionListener(e -> {
            this.enviornment.gradleSetup();
        });
        menu.add(mntmRunGradleSetup);

        JMenuItem mntmAbout = new JMenuItem("About ");
        mntmAbout.addActionListener(e -> {
            //TODO
        });
        menu.add(mntmAbout);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        cbStudent = new JComboBox();
        cbStudent.addItemListener(e -> showAvailableLessons());

        txtOutput = new JTextPane();

        cbCourse = new JComboBox();
        cbCourse.addItemListener(e -> showAvailableLessons());
        cbCourse.setToolTipText("Curriculum");

        cbImportType = new JComboBox();
        cbImportType.addItemListener(e -> showAvailableLessons());

        cbLessonPlan = new JComboBox();
        cbLessonPlan.addItemListener(e -> {
        });

        JLabel lblCurriculum = new JLabel("Course");
        lblCurriculum.setFont(new Font("Consolas", Font.BOLD, 13));

        JLabel lblImportType = new JLabel("Import");
        lblImportType.setFont(new Font("Consolas", Font.BOLD, 13));

        JLabel lblLesson = new JLabel("Lesson");
        lblLesson.setFont(new Font("Consolas", Font.BOLD, 13));

        JButton btnImport = new JButton("Import");
        btnImport.addActionListener(e -> performImport());

        JButton btnOpenEclipse = new JButton("Open Project");
        btnOpenEclipse.addActionListener(e -> {
            this.enviornment.openEclipse();
        });

        setDefaults();

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(1)
                                                .addComponent(txtOutput, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(cbCourse, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblCurriculum))
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(cbImportType, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblImportType))
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(lblLesson)
                                                        .addComponent(cbLessonPlan, 0, 138, Short.MAX_VALUE))
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                        .addComponent(btnImport)
                                                        .addComponent(btnOpenEclipse))
                                                .addGap(1))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(cbStudent, 0, 433, Short.MAX_VALUE)))
                                .addGap(1))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(cbStudent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                .addComponent(lblImportType)
                                                .addComponent(lblLesson)
                                                .addComponent(lblCurriculum))
                                        .addComponent(btnOpenEclipse))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(cbCourse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbImportType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbLessonPlan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnImport))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(txtOutput, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                .addGap(0))
        );
        contentPane.setLayout(gl_contentPane);
    }
}
