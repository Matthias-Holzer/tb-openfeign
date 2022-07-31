package at.matthiasholzer.tbclient;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@FeignClient(name = "feignEntryClient", url = "http://localhost:6666")
public interface EntryService {
    @GetMapping
    ArrayList<Entry> getEntries();
}
