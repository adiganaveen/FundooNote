package com.bridgelabz.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bridgelabz.spring.model.Label;
import com.bridgelabz.spring.model.Note;
import com.bridgelabz.spring.model.User;

@Repository
public class NoteDaoImpl implements NoteDao {

	@Autowired
	private SessionFactory sessionFactory;

	public int createNote(Note note) {
		int noteId = 0;
		Session session = sessionFactory.getCurrentSession();
		noteId = (Integer) session.save(note);
		return noteId;

	}

	public Note getNoteById(int id) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Note where noteId= :noteId");
		query.setInteger("noteId", id);
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
		Query query = session.createQuery("DELETE from Note u where u.noteId= :noteId");
		query.setInteger("noteId", id);
		query.executeUpdate();
		session.close();
	}

	public List<Note> retrieveNote(int id) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Note where userId= :userId");
		query.setInteger("userId", id);
		List<Note> listOfNote =query.list();
		return listOfNote;
	}
	
	
	public int createLabel(Label label) {
		int noteId = 0;
		Session session = sessionFactory.getCurrentSession();
		noteId = (Integer) session.save(label);
		return noteId;

	}

	public Label getLabelById(int id) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Label where labelId= :labelId");
		query.setInteger("labelId", id);
		Label label = (Label) query.uniqueResult();
		if (label != null) {
			session.close();
			return label;
		} else {
			return null;
		}
	}

	public void updateLabel(int id, Label label) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(label);
		transaction.commit();
		session.close();
	}

	public void deleteLabel(int id) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("DELETE from Label u where u.labelId= :labelId");
		query.setInteger("labelId", id);
		query.executeUpdate();
		session.close();
	}

	public List<Label> retrieveLabel(int id) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Label where userId= :userId");
		query.setInteger("userId", id);
		List<Label> listOfLabel =query.list();
		return listOfLabel;
	}

}
