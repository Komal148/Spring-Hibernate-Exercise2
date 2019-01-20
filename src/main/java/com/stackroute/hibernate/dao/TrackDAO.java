package com.stackroute.hibernate.dao;


import com.stackroute.hibernate.model.Track;

public interface TrackDAO {

	boolean saveTrack(Track track);

	String getTrackById(int id);
   
}