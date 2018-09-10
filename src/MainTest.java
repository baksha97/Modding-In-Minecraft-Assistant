import enums.CurriculumType;
import enums.ImportType;
import javaxt.io.Directory;
import repos.PresetRepository;

public class MainTest {
    public static void main (String[] args){
        CurriculumType c = CurriculumType.ICE;
        ImportType i = ImportType.POST;
        String mc = "/mc";

        PresetRepository.PathTuple lessonPaths = (new PresetRepository(c, i, mc)).getLessonPaths("/item");

        System.out.println(lessonPaths.getJavaLessonPath());
        System.out.println(lessonPaths.getMinecraftPath());

        Directory f = new Directory("./file");

        System.out.println(f.getPath());

    }
}
