package nio;

import java.io.*;

public class CeasarCipher {
    public static void main(String[] args) throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream(".\\files\\crypting.csv");
            out = new FileOutputStream(".\\files\\cryptingEncrypted.csv");
            int c;
            int x = 3;

            while ((c = in.read()) >= 0) {
                if (c != 32) {
                    out.write(c + (x % 26)); // für unicode % 256 sein, (c + x) % 256
                } else {
                    out.write(32);
                }
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
