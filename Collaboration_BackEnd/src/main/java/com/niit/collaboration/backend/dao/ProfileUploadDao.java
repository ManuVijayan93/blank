package com.niit.collaboration.backend.dao;

import com.niit.collaboration.backend.model.ProfilePicture;

public interface ProfileUploadDao {
void save(ProfilePicture profilePicture);
ProfilePicture getProfilePic(String username);
}