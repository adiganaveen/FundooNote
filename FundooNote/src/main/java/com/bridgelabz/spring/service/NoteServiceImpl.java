package com.bridgelabz.spring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.spring.Utility.TokenGenerator;
import com.bridgelabz.spring.dao.NoteDao;
import com.bridgelabz.spring.dao.UserDao;
import com.bridgelabz.spring.model.Note;
import com.bridgelabz.spring.model.User;



@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NoteDao noteDao;

	@Autowired
	private TokenGenerator tokenGenerator;

	@Transactional
	public boolean create(Note note, HttpServletRequest request) {
		int id = noteDao.create(note);
		if (id > 0) {
			 String token = tokenGenerator.generateToken(String.valueOf(id));
			 System.out.println(token);
			return true;
		}
		return false;
	}

	@Transactional
	public Note updateNote(int id, Note note,HttpServletRequest request) {
		Note note2 = noteDao.getNoteById(id);
		if (note2 != null) {
			note2.setTitle(note.getTitle());
			note2.setDiscription(note.getDiscription());
			note2.setArchive(note.isArchive());
			note2.setPinned(note.isPinned());
			note2.setInTrash(note.isInTrash());
			noteDao.updateNote(id, note2);
		}
		return note2;
	}

	@Transactional
	public Note deleteNote(int id,HttpServletRequest request) {
		Note note2 = noteDao.getNoteById(id);
		if (note2 != null) {
			noteDao.deleteNote(id);
		}
		return note2;
	}

	@Transactional
	public List<Note> retrieve(HttpServletRequest request) {
		List<Note> listOfNote = noteDao.retrieve();
		if (!listOfNote.isEmpty()) {
			return listOfNote;
		}
		return null;
	}

}
