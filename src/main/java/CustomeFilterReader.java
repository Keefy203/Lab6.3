import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class CustomeFilterReader extends FilterReader
{
    private char key;

    public char decypt (char input)
    {
        return (char) (input+(key-1));
    }

    CustomeFilterReader(Reader in, char key)
    {
        super(in);
        this.key=key;
    }
    @Override
    public int read(char[] output) throws IOException
    {
        int temp=super.read(output);
        int i=0;
        while(i<output.length)
        {
            output[i]=decypt(output[i]);
            i++;
        }
        return temp;
    }
}
