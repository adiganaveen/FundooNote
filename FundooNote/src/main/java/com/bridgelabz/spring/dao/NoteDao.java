package com.bridgelabz.spring.dao;

import java.util.List;

import com.bridgelabz.spring.model.Label;
import com.bridgelabz.spring.model.Note;

public interface NoteDao {
	int createNote(Note note);

	List<Note> retrieveNote(int id);

	Note getNoteById(int id);

	void updateNote(Note note);

	void deleteNote(int id);

	int createLabel(Label label);

	List<Label> retrieveLabel(int id);

	Label getLabelById(int id);

	void updateLabel(Label label);

	void deleteLabel(int id);

}
