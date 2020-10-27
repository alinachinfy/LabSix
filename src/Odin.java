import java.io.*;

public class Odin {
    public static void main(String[] args) throws IOException {
        Reader in=null;
        Writer out=null;

        try {
            in= new FileReader("MyFile1.txt");
            out= new FileWriter("MyFile2.txt");
            int oneByte;
            while ((oneByte = in.read()) != -1) {
                out.write((char)oneByte);
                out.append((char)oneByte);
                System.out.print((char)oneByte);
            }
        } catch (IOException e) {
            System.out.println("Ошибка!!!!");
        } finally {
            in.close();
            out.close();
        }
    }
}