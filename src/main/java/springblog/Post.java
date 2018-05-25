package springblog;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Post {
	private final Long id;
	private final String message;
	private final Date date;
	private final Double latitude;
	private final Double longitude;
	
	public Post(String message, Date date, Double latitude, Double longitude) {
		super();
		this.id = null;
		this.message = message;
		this.date = date;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Long getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public Date getDate() {
		return date;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}
	
	@Override
	public boolean equals(Object that) {
		return EqualsBuilder.reflectionEquals(this, that , new String[]{"id", "date"});		
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, new  String[]{"id", "date"});
	}
}
