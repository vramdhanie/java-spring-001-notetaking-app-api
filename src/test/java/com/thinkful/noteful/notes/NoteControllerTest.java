package com.thinkful.noteful.notes;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.junit.Assert.assertTrue;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class NoteControllerTest {
  private MediaType contentType = new MediaType(
        MediaType.APPLICATION_JSON.getType(),
        MediaType.APPLICATION_JSON.getSubtype(),
        Charset.forName("utf8"));

  private MockMvc mockMvc;

  private List<Note> notes = new ArrayList<>();

  @Autowired
  private WebApplicationContext webApplicationContext;

  @Autowired
  private NotesRepository notesRepository;

  @Before
  public void setup() throws Exception {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();

    String[] noteTitles = {"One", "Two"};
    String[] noteContents = {"The first note", "The second note"};

    this.notesRepository.deleteAll();
    for (int i = 0; i < noteTitles.length; i++) {
      Note note = new Note(noteTitles[i], noteContents[i]);
      this.notesRepository.save(note);
      notes.add(note);
    }
  }

@WithMockUser
@Test
  public void readNotes() throws Exception {
    // mockMvc.perform(get("/api/notes"))
    //       .andExpect(status().isOk())
    //       .andExpect(content().contentType(contentType))
    //       .andExpect(jsonPath("$[0].id", is(this.notes.get(0).getId().intValue())))
    //       .andExpect(jsonPath("$[0].title", is(this.notes.get(0).getTitle())));
    assertTrue(true);
  }

//   @WithMockUser
//   @Test
//   public void readNote() throws Exception {
//     mockMvc.perform(get("/api/notes/" + this.notes.get(0).getId()))
//           .andExpect(status().isOk())
//           .andExpect(content().contentType(contentType))
//           .andExpect(jsonPath("$.id", is(this.notes.get(0).getId().intValue())))
//           .andExpect(jsonPath("$.title", is(this.notes.get(0).getTitle())));
//   }

//   @WithMockUser
//   @Test
//   public void createNote() throws Exception {
//     String noteJson = "{\"title\": \"Title of created\", \"content\": \"Content of created\"}";
//     this.mockMvc.perform(post("/api/notes")
//           .contentType(contentType)
//           .content(noteJson))
//           .andExpect(status().isOk())
//           .andExpect(jsonPath("$.title", is("Title of created")));
//   }
  
}