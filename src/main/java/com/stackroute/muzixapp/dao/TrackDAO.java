package com.stackroute.muzixapp.dao;


import java.util.List;

import com.stackroute.muzixapp.model.Track;

public interface TrackDAO {

	boolean saveTrack(Track track);

	String getTrackById(int id);
   
}