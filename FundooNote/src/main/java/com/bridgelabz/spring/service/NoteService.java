package com.bridgelabz.spring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bridgelabz.spring.model.Note;

public interface NoteService {
	public boolean create(Note note, HttpServletRequest request);
	
	public List<Note> retrieve(HttpServletRequest request);
	
	public Note updateNote(int id, Note note,HttpServletRequest request);

	public Note deleteNote(int id,HttpServletRequest request);
}