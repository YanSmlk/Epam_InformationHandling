package yan.epam.task2.creation;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import yan.epam.task2.exception.DataFileException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TextCreator
{
    public static final Logger LOGGER= LogManager.getLogger();

    public String readText(String filePath) throws DataFileException
    {
        File file = new File(filePath);
        if ((filePath == "") | (filePath == null)) {throw new DataFileException("Empty file name");}
        if (file.exists() == false) {throw new DataFileException("No file found: ", filePath);}
        if(file.length() == 0) {throw new DataFileException("File is empty: ", filePath);}
        String text;
        try
        {
            FileInputStream inFile = new FileInputStream(filePath);
            byte[] str = new byte[inFile.available()];
            inFile.read(str);
            text = new String(str);
        }
        catch (FileNotFoundException e)
        {
            throw new DataFileException("No file found: ", filePath);
        }
        catch (IOException e)
        {
            throw new DataFileException("Error reading the file");
        }
        LOGGER.log(Level.INFO,"File successfully read");
        return text;
    }

}
