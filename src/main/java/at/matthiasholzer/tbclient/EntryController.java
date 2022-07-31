package at.matthiasholzer.tbclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

@Controller
public class EntryController {

    private final EntryService entryService;
    private ArrayList<Entry> arrayList;

    @Autowired
    public EntryController(EntryService entryService){
        this.entryService = entryService;
        this.arrayList = entryService.getEntries();
    }

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("a",arrayList);
        return "entries";
    }

    @GetMapping("/entries_all.csv")
    public void downloadCSVAll(HttpServletResponse response) throws IOException {
        File file = CustomConverter.getCSVSemicolon(arrayList);
        //send file
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename"+file.getName();

        response.setHeader(headerKey,headerValue);
        ServletOutputStream outputStream = response.getOutputStream();
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        byte[] buffer = new byte[8192]; //8kB
        int bytesRead = -1;

        while ((bytesRead = inputStream.read(buffer)) != -1){
            outputStream.write(buffer, 0, bytesRead);
        }
        inputStream.close();
        outputStream.close();
    }
    @GetMapping("/entries_open_deadline.csv")
    public void downloadCSVOpenDeadline(HttpServletResponse response) throws IOException {
        ArrayList<Entry> al = new ArrayList<>();
        for(int i = 0; i<arrayList.size(); i++){
            if(arrayList.get(i).getDue_date().after(Date.valueOf(LocalDate.now()))){
                al.add(arrayList.get(i));
            }
        }
        File file = CustomConverter.getCSVSemicolon(al);
        //send file
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename"+file.getName();

        response.setHeader(headerKey,headerValue);
        ServletOutputStream outputStream = response.getOutputStream();
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        byte[] buffer = new byte[8192]; //8kB
        int bytesRead = -1;

        while ((bytesRead = inputStream.read(buffer)) != -1){
            outputStream.write(buffer, 0, bytesRead);
        }
        inputStream.close();
        outputStream.close();
    }
    @GetMapping("/entries_exceeded_deadline.csv")
    public void downloadCSVExceededDeadline(HttpServletResponse response) throws IOException {
        ArrayList<Entry> al = new ArrayList<>();
        for(int i = 0; i<arrayList.size(); i++){
            if(arrayList.get(i).getDue_date().before(Date.valueOf(LocalDate.now()))){
                al.add(arrayList.get(i));
            }
        }
        File file = CustomConverter.getCSVSemicolon(al);
        //send file
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename"+file.getName();

        response.setHeader(headerKey,headerValue);
        ServletOutputStream outputStream = response.getOutputStream();
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        byte[] buffer = new byte[8192]; //8kB
        int bytesRead = -1;

        while ((bytesRead = inputStream.read(buffer)) != -1){
            outputStream.write(buffer, 0, bytesRead);
        }
        inputStream.close();
        outputStream.close();
    }
/*
    @GetMapping("/download.xlsx")
    public void downloadXlsx(HttpServletResponse response) throws Exception {
        File file = CustomConverter.getXLSX();

        //send file
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename"+file.getName();

        response.setHeader(headerKey,headerValue);
        ServletOutputStream outputStream = response.getOutputStream();
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        byte[] buffer = new byte[8192]; //8kB
        int bytesRead = -1;

        while ((bytesRead = inputStream.read(buffer)) != -1){
            outputStream.write(buffer, 0, bytesRead);
        }
        inputStream.close();
        outputStream.close();
    }
     */
}
