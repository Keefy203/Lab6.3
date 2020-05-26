import org.junit.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class WriteTest
{
    @Test
    void read() throws IOException
    {
        char[] Array={'k','e','e','f','y'};
        char[] encryption= new char[5];
        String expected="gaabu";

        CustomeFilterWriter customewriter = new CustomeFilterWriter(new FileWriter("file_test1.txt"),(char)5);
        customewriter.write(Array);
        customewriter.close();

        FileReader filereader = new FileReader("file_test1.txt");
        filereader.read(encryption);

        StringBuilder stringbuilder= new StringBuilder();
        stringbuilder.append(encryption);
        String actual= stringbuilder.toString();

        assertEquals(actual, expected);

    }
}
