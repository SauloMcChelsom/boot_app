package com.app.boot_app.projection;

public interface UserProjection {
    Long getId();
	String getTitle();
	Integer getGameYear();
	String getImgUrl();
	String getShortDescription();
	Integer getPosition();
}