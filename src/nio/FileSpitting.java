package nio;

import java.io.*;

public class FileSpitting {
    public static void main(String[] args) throws IOException {
        File file = new File(".\\files\\people.csv");
        boolean directoryCreated = file.mkdir();
        if(directoryCreated){
            System.out.println("Directory created");
        }

        //Try in-case we can't find the people.csv file
        try (BufferedReader br = new BufferedReader(new FileReader(".\\files\\people.csv"))) {
            String line;
            BufferedWriter bw = null;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                FileWriter fw = new FileWriter(".\\files\\people.split" + values[1].charAt(0) + ".split", true);
                bw = new BufferedWriter(fw);
                bw.write(line+System.lineSeparator());
                bw.flush();
            }
            bw.close();
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("people.csv can't be found");
        }
    }
}
