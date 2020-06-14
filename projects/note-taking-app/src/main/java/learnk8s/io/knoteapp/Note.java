package learnk8s.io.knoteapp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "notes")
public class Note {

    private String id;
    private String description;

    @Override
    public String toString() {
        return "Note{" +
                "description='" + description + '\'' +
                '}';
    }
}
