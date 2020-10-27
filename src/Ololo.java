import java.io.*;

/*Вариант 3
Переписать в результирующий файл слова, начинающиеся с согласных букв. */
public class Ololo {
    private static String gw = "вв";
    private static int i;

    public static boolean checkchar( char w ) {
        char[] gl = gw.toCharArray();
        for (int i = 0; i < gl.length; i++) {
            if (gl[i] == w) {
                return true;
            }
        } return false;
    }

    public static boolean checkString(String str) {
        char w = str.charAt(0);
        char[] gl = gw.toCharArray();
        for (int i = 0; i < gl.length; i++ ); {
            if (gl[i] == w) {
                return true;
            }
        } return false;
    }

    public static boolean checkStringLongerFive(String string) {

        return (string.length() > 5);
    }

    public static void main(String[] args) throws IOException {
        InputStream in = null;
        Reader file = null;
        BufferedReader buf = null;
        OutputStream out = null;
        Writer wr = null;

        try {
            in = new FileInputStream("C:\\Users\\admin\\IdeaProjects\\LabSix\\src\\in.txt");
            file = new InputStreamReader(in, "cp1251");
            buf = new BufferedReader(file);

            File f1 = new File("C:\\Users\\admin\\IdeaProjects\\LabSix\\src\\out.txt");
            f1.createNewFile();

            if (f1.exists()) {
                out = new FileOutputStream(f1);
                wr = new OutputStreamWriter(out, "Unicode");

                String line = "";
                String[] words;
                int num_line = 1;

                while ((line = buf.readLine()) !=null) {
                    wr.write(num_line);
                    words = line.split( " ");
                    System.out.println("Lenght of line " + words.length);
                    int count = 0;
                    for (int i = 0; i < words.length; i++) {
                        if (checkString(words[i])) {
                            wr.append(words[i] + " ");
                        }
                        if (checkchar(words[i].charAt(0))) {
                            wr.append(words[i] + " ");
                        }
                    }
                    wr.append(count + "\n");
                }
            }
        } catch (IOException ie) {
            System.out.println("Error " + ie);
        } finally {
            in.close();
            file.close();
            buf.close();
            wr.flush();
            wr.close();
            out.close();
        }
    }
}
