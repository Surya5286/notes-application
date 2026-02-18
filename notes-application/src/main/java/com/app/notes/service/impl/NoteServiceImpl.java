package com.app.notes.service.impl;

import com.app.notes.model.Note;
import com.app.notes.repository.NoteRepository;
import com.app.notes.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    @Override
    public Note createNoteForUser(String userName, String content) {
        Note note = Note.builder()
                        .content(content)
                        .ownerUsername(userName)
                        .build();
        Note savedNote = noteRepository.save(note);
        return savedNote;
    }

    @Override
    public Note updateNoteForUser(Long noteId, String content, String username) {
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new RuntimeException("Note not found"));
        note.setContent(content);
        Note updatedNote = noteRepository.save(note);
        return updatedNote;
    }

    @Override
    public void deleteNoteForUser(Long noteId, String username) {
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new RuntimeException("Note not found"));
        noteRepository.delete(note);
    }

    @Override
    public List<Note> getNotesForUser(String username) {
        List<Note> personalNotes = noteRepository.findByOwnerUsername(username);
        return personalNotes;
    }
}