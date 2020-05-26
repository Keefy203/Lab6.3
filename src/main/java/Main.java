import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException {
        char[] encryption={'e','x','a','m','p','e'};
        char[] decryption = new char[10];

        System.out.println(String.valueOf(encryption));
        try(CustomeFilterWriter customwriter = new CustomeFilterWriter(new FileWriter("Test.txt"),'5'))
        {
            customwriter.write(encryption);
            customwriter.flush();
        }
        catch (IOException io)
        {
            io.printStackTrace();
        }
        FileReader filereader= new FileReader("Test.txt");
        char[] encypt = new char[10];
        filereader.read(encypt);

        try(CustomeFilterReader customefilterreader = new CustomeFilterReader(new FileReader("Test.txt"),'5'))
        {
            customefilterreader.read(decryption);
            FileWriter filewriter= new FileWriter("Test2.txt");
            filewriter.write(decryption);
            filewriter.flush();
            filewriter.close();
        }
        catch (IOException io)
        {
            io.printStackTrace();
        }
        System.out.println("Result");
        System.out.println(String.valueOf(encryption));
        System.out.println(String.valueOf(encypt));
        System.out.println(String.valueOf(decryption));
    }
}
