package com.bridgelabz.spring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestHeader;

import com.bridgelabz.spring.model.Label;
import com.bridgelabz.spring.model.Note;

public interface NoteService {
	public boolean createNote(String token, Note note, HttpServletRequest request);

	public List<Note> retrieveNote(String token, HttpServletRequest request);

	public Note updateNote(String token, int id, Note note, HttpServletRequest request);

	public Note deleteNote(String token, int id, HttpServletRequest request);

	public boolean createLabel(String token, Label label, HttpServletRequest request);

	public List<Label> retrieveLabel(String token, HttpServletRequest request);

	public Label updateLabel(String token, int id, Label label, HttpServletRequest request);

	public Label deleteLabel(String token, int id, HttpServletRequest request);
	
	public boolean addNoteLabel(String token,int noteId,int labelId,HttpServletRequest request);
	
	public boolean removeNoteLabel(String token,int noteId, int labelId, HttpServletRequest request);
}
