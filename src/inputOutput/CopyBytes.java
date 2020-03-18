package inputOutput;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream(".\\files\\image.png");
            out = new FileOutputStream(".\\files\\image copy.png");
            int c;

            while ((c = in.read()) >= 0) {
                out.write(c);
            }
        } finally { // falls das in.close zuerst wäre und eine exception throwen würde, dann würde das out.close nicht mehr ausgeführt werden
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
            }

        }
    }
}
