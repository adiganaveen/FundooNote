package com.bridgelabz.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bridgelabz.spring.model.Note;
import com.bridgelabz.spring.model.User;

@Repository
public class NoteDaoImpl implements NoteDao {

	@Autowired
	private SessionFactory sessionFactory;

	public int create(Note note) {
		int noteId = 0;
		Session session = sessionFactory.getCurrentSession();
		noteId = (Integer) session.save(note);
		return noteId;

	}

	public Note getNoteById(int id) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Note where id= :id");
		query.setInteger("id", id);
		Note note = (Note) query.uniqueResult();
		if (note != null) {
			session.close();
			return note;
		} else {
			return null;
		}
	}

	public void updateNote(int id, Note note) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(note);
		transaction.commit();
		session.close();
	}

	public void deleteNote(int id) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("DELETE from Note u where u.id= :id");
		query.setInteger("id", id);
		query.executeUpdate();
		session.close();
	}

	public List<Note> retrieve() {
		Session session = sessionFactory.openSession();
		List<Note> listOfNote = session.createQuery("from Note").list();
		return listOfNote;
	}

}