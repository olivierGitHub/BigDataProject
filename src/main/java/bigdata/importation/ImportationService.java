package bigdata.importation;

import java.io.File;
import java.util.List;

/**
 * Created by alexandre on 18/02/2015.
 */
public interface ImportationService {
    void importFileData(File file);
    List<String> getYearFileData(File file);
}
