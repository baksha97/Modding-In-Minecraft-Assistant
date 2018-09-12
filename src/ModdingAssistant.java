import javaxt.io.Directory;
import utils.AssistantUtil;
import utils.enums.CurriculumType;
import utils.enums.ImportType;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;

@SuppressWarnings("SpellCheckingInspection")
public class ModdingAssistant extends JFrame {

    private static final String title = "Modding in Minecraft: Assistant";
    private final JComboBox<String> cbStudent;
    private final JComboBox<String> cbCourse;
    private final JComboBox<String> cbImportType;
    private final JComboBox<String> cbLessonPlan;
    private final JButton btnImport;
    private final JTextPane txtOutput;
    private MinecraftModdingEnvironment environment;

    private ModdingAssistant() {
        super(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 400);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu(title);
        menu.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        menuBar.add(menu);

        JMenuItem mntmAddTexturesToSrc = new JMenuItem("Import/Overwrite Textures");
        mntmAddTexturesToSrc.addActionListener(e -> this.environment.addTexturesToSrc());
        menu.add(mntmAddTexturesToSrc);

        JMenuItem mntmRunGradleSetup = new JMenuItem("Run Gradle Setup");
        mntmRunGradleSetup.addActionListener(e -> {
            this.environment.gradleSetup();
            AssistantUtil.showSystemOut();
        });
        menu.add(mntmRunGradleSetup);

        JMenuItem mntmAbout = new JMenuItem("About ");
        mntmAbout.addActionListener(e -> AssistantUtil.presentAboutDialog());
        menu.add(mntmAbout);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        cbStudent = new JComboBox<>();
        cbStudent.addItemListener(e -> onEnvironmentChange());

        txtOutput = new JTextPane();
        txtOutput.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(txtOutput);

        cbCourse = new JComboBox<>();
        cbCourse.addItemListener(e -> onEnvironmentChange());

        cbImportType = new JComboBox<>();
        cbImportType.addItemListener(e -> onEnvironmentChange());

        cbLessonPlan = new JComboBox<>();


        JLabel lblCurriculum = new JLabel("Course");
        lblCurriculum.setFont(new Font("Consolas", Font.BOLD, 13));

        JLabel lblImportType = new JLabel("Import");
        lblImportType.setFont(new Font("Consolas", Font.BOLD, 13));

        JLabel lblLesson = new JLabel("Lesson");
        lblLesson.setFont(new Font("Consolas", Font.BOLD, 13));

        btnImport = new JButton("Import");
        btnImport.addActionListener(e -> performImport());

        JButton btnOpenEclipse = new JButton("Open Project");
        btnOpenEclipse.addActionListener(e -> openEclipse());

        initializeComboBoxes();

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(1)
                                                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE))
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
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 237, Short.MAX_VALUE)
                                .addGap(0))
        );
        contentPane.setLayout(gl_contentPane);
    }

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


    private void initializeComboBoxes() {
        cbStudent.setModel(new DefaultComboBoxModel<>(MinecraftModdingEnvironment.getAvailableStudentsNames()));
        cbCourse.setModel(new DefaultComboBoxModel<>(CurriculumType.getNames()));
        cbImportType.setModel(new DefaultComboBoxModel<>(ImportType.getNames()));
        onEnvironmentChange();
        initializeCheck();
    }

    private void initializeCheck() {
        if (cbStudent.getItemCount() == 0) {
            txtOutput.setText("No student projects found!...");
            btnImport.setEnabled(false);
        } else {
            txtOutput.setText("Verify user on the top drop down menu.");
            btnImport.setEnabled(true);
        }
    }

    private void onEnvironmentChange() {
        //Check for changes to student folders
        this.environment = new MinecraftModdingEnvironment(currentStudentDirectory());
        cbLessonPlan.setModel(new DefaultComboBoxModel<>(
                this.environment.getAvailableLessons(currentCurriculumType(), currentImportType())
        ));
    }

    private void performImport() {
        String lesson = (String) cbLessonPlan.getSelectedItem();
        println(currentRepoTitle());
        String result = this.environment.performImport(currentCurriculumType(), currentImportType(), lesson);
        println(result);
    }

    private void openEclipse() {
        println("Opening " + cbStudent.getSelectedItem() + "'s eclipse...");
        this.environment.openEclipse();
    }

    private void println(String s) {
        txtOutput.setText(txtOutput.getText() + "\n" + s);
    }

    @SuppressWarnings("ConstantConditions")
    private String currentRepoTitle() {
        String lesson = (String) cbLessonPlan.getSelectedItem();
        return "[" + AssistantUtil.toTitleCase((String) cbImportType.getSelectedItem()) + " Repository - " + lesson + "]";
    }

    private Directory currentStudentDirectory() {
        int studentIndex = cbStudent.getSelectedIndex();
        return MinecraftModdingEnvironment.getAvailableStudentsDirs()[studentIndex];
    }

    private CurriculumType currentCurriculumType() {
        return CurriculumType.valueOf((String) cbCourse.getSelectedItem());
    }

    private ImportType currentImportType() {
        return ImportType.valueOf((String) cbImportType.getSelectedItem());
    }
}
