package learnk8s.io.knoteapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Controller
public class KNoteController {

    @Autowired
    private NoteRepository noteRepository;

    @GetMapping("/")
    public String index(Model model) {
        System.out.println("KNoteController.index");
        getAllNotes(model);
        return "index";
    }


    @PostMapping("/note")
    public String saveNotes(@RequestParam("image") MultipartFile file,
                            @RequestParam String description,
                            @RequestParam(required = false) String publish,
                            @RequestParam(required = false) String upload,
                            Model model) throws IOException {

        if (publish != null && publish.equals("Publish")) {
            saveNote(description, model);
            getAllNotes(model);
            return "redirect:/";
        }
        // After save fetch all notes again
        return "index";
    }

    private void getAllNotes(Model model) {
        List<Note> notes = noteRepository.findAll();
        Collections.reverse(notes);
        model.addAttribute("notes", notes);
    }

    private void saveNote(String description, Model model) {
        if (description != null && !description.trim().isEmpty()) {
            noteRepository.save(new Note(null, description.trim()));
            // cleaning up the text area
            model.addAttribute("description", "");
        }
    }

}
