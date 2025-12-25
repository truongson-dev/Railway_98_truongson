package com.vti.entity.ex4_ques4;

public class Document {
	private int id;
	private String publisher;
	private int numRelease;

	public Document(int id, String publisher, int numRelease) {
		this.id = id;
		this.publisher = publisher;
		this.numRelease = numRelease;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getNumRelease() {
		return numRelease;
	}

	public void setNumRelease(int numRelease) {
		this.numRelease = numRelease;
	}

	@Override
	public String toString() {
		return "Document{id=" + id + ", publisher='" + publisher + "', numRelease=" + numRelease + "}";
	}
}