package com.vti.entity.ex4_ques4;

public class Book extends Document {
	private String authorName;
	private int numPage;

	public Book(int id, String publisher, int numRelease, String authorName, int numPage) {
		super(id, publisher, numRelease);
		this.authorName = authorName;
		this.numPage = numPage;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getNumPage() {
		return numPage;
	}

	public void setNumPage(int numPage) {
		this.numPage = numPage;
	}

	@Override
	public String toString() {
		return super.toString() + ", authorName='" + authorName + "', numPage=" + numPage + ", type=Book}";
	}
}