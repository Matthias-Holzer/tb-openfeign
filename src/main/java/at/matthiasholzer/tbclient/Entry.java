package at.matthiasholzer.tbclient;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class Entry {
    private Long id;
    private Long project_person_id;
    private Long project_kam_id;
    private Long position_id;
    private Long project_id;
    private Long project_number;
    private Date due_date;
    private String last_status;
}
