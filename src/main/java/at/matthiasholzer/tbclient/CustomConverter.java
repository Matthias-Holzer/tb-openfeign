package at.matthiasholzer.tbclient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CustomConverter {
    public static File getCSV(ArrayList<Entry> arrayList) throws IOException {
        File file = new File("src/main/resources/download.csv");
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write("id,project_person_id,project_kam_id,position_id,project_id,project_number,due_date,last_status");
        bw.newLine();
        for (int i = 0; i < arrayList.size(); i++) {
            Entry e = arrayList.get(i);
            bw.write(
                    e.getId() + "," +
                            e.getProject_person_id() + "," +
                            e.getProject_kam_id() + "," +
                            e.getPosition_id() + "," +
                            e.getProject_id() + "," +
                            e.getProject_number() + "," +
                            e.getDue_date() + "," +
                            e.getLast_status()
            );
            bw.newLine();
        }
        bw.close();
        fw.close();
        return file;
    }
    public static File getCSVSemicolon(ArrayList<Entry> arrayList) throws IOException {
        File file = new File("src/main/resources/download.csv");
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write("id;project_person_id;project_kam_id;position_id;project_id;project_number;due_date;last_status");
        bw.newLine();
        for (int i = 0; i < arrayList.size(); i++) {
            Entry e = arrayList.get(i);
            bw.write(
                    e.getId() + ";" +
                            e.getProject_person_id() + ";" +
                            e.getProject_kam_id() + ";" +
                            e.getPosition_id() + ";" +
                            e.getProject_id() + ";" +
                            e.getProject_number() + ";" +
                            e.getDue_date() + ";" +
                            e.getLast_status()
            );
            bw.newLine();
        }
        bw.close();
        fw.close();
        return file;
    }
}
