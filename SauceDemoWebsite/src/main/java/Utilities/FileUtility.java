package Utilities;



import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static Utilities.CommandsUtility.*;

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


    public static void openReport(String filePath) throws InterruptedException, IOException {
        String operatingSystem=System.getProperty("os.name").toLowerCase();
        List<String>command;
        if (operatingSystem.contains("wind"))
        {
            command=windowsCommand(PropertiesUtility.getPropertyValue("browser"),filePath);
        }
        else if (operatingSystem.contains("mac"))
        {
            command=macCommand(PropertiesUtility.getPropertyValue("browser"),filePath);
        }
        else
        {
            command=linuxCommand(PropertiesUtility.getPropertyValue("browser"),filePath);
        }
      new ProcessBuilder(command).start();
    }




}

