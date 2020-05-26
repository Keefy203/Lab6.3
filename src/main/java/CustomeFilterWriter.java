import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class CustomeFilterWriter extends FilterWriter
{
    private char key;

    private char encrypt(char input)
    {
        return (char)(input -key+ 1);
    }

    public CustomeFilterWriter (Writer out, char key)
    {
        super(out);
        this.key=key;
    }
    @Override
    public void write(char[] input) throws IOException
    {
        int i=0;
        while (i<input.length)
        {
            input[i]=encrypt(input[i]);
            i++;
        }
        super.write(input);
    }
}
