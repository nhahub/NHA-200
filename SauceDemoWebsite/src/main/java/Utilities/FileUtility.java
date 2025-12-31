package Utilities;



import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

//this class used to just control some folders and files
public class FileUtility {

    private static final Logger log = LogManager.getLogger(FileUtility.class);

    private FileUtility()
    {
        super();
    }

    // to remove files if needed
    public static void removeFile(File directoryPath) throws IOException {
        if(!directoryPath.exists())
        {
        log.warn("not existing file");
        return;
        }

        File[] files =directoryPath.listFiles();
        if (files==null)
        {
            log.warn("not existing file");
            return;
        }
        for (File eachFile: files)
        {
                if (eachFile.isDirectory())
                {
                    removeFile(eachFile);
                }
                else {
                    Files.delete(eachFile.toPath());
                }
        }


    }

    // to clean directory after test
    public static void emptyDirectory(File fileName){
        FileUtils.deleteQuietly(fileName);
    }



}

