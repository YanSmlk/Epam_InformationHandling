package yan.epam.task2.exception;

public class DataFileException extends Exception
{

    public DataFileException(String msg, String fileName)
    {
        super(msg+fileName);
    }

    public DataFileException(String msg)
    {
        super(msg);
    }
}