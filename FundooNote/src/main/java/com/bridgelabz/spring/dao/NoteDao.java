package com.bridgelabz.spring.dao;

import java.util.List;

import com.bridgelabz.spring.model.Note;
	
public interface NoteDao {
	public int create(Note note);

	public List<Note> retrieve();

	public Note getNoteById(int id);

	public void updateNote(int id, Note note);

	public void deleteNote(int id);

}
