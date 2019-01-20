package com.stackroute.hibernate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.hibernate.model.Track;

@Repository
@Transactional
public class TrackDAOImpl implements TrackDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public TrackDAOImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean saveTrack(Track track) {
		try {

			sessionFactory.getCurrentSession().save(track);
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	@Override
	public String getTrackById(int id) {
		Query query = sessionFactory.getCurrentSession().createQuery("select name from Track where id ='"+id+"'");
		List<String> name = query.list();
		return name.get(0);
	}

}
