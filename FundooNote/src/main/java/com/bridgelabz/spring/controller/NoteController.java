package com.bridgelabz.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.spring.model.Note;
import com.bridgelabz.spring.service.NoteService;

@RestController
public class NoteController {
	@Autowired
	private NoteService noteService;

	@RequestMapping(value = "/createnote", method = RequestMethod.POST)
	public ResponseEntity<String> createNote(@RequestBody Note note, HttpServletRequest request) {
		try {
			if (noteService.create(note, request))
				return new ResponseEntity<String>("Successfully Registered", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("There was a issue raised cannot register", HttpStatus.CONFLICT);
		}
		return new ResponseEntity<String>("There was a issue raised cannot register", HttpStatus.CONFLICT);
	}
	
	@RequestMapping(value = "/retrieve", method = RequestMethod.GET)
	public ResponseEntity<?> createNote(HttpServletRequest request) {
		List<Note> listOfNote = noteService.retrieve(request);
		if (!listOfNote.isEmpty()) {
			return new ResponseEntity<List<Note>>(listOfNote, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<String>("Email incorrect. Please enter valid email address present in database",
					HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/updatenote", method = RequestMethod.POST)
	public ResponseEntity<?> updateUser(@RequestParam("id") int id, @RequestBody Note note,
			HttpServletRequest request) {

		Note note2 = noteService.updateNote(id, note, request);
		if (note2 != null) {
			return new ResponseEntity<Note>(note2, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<String>("Email incorrect. Please enter valid email address present in database",
					HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/deletenote", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@RequestParam("id") int id, HttpServletRequest request) {

		Note note = noteService.deleteNote(id, request);
		if (note != null) {
			return new ResponseEntity<Note>(note, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<String>("Email incorrect. Please enter valid email address present in database",
					HttpStatus.NOT_FOUND);
		}
	}

}
