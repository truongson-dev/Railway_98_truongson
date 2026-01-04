package com.vti.entity;

public class Contestant {
	private static int COUNT = 0;
	private int id;
	private String name;
	private String address;
	private int priority;
	private Block block;

	public Contestant(String name, String address, int priority, Block block) {
		COUNT++;
		this.id = COUNT;
		this.name = name;
		this.address = address;
		this.priority = priority;
		this.block = block;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public int getPriority() {
		return priority;
	}

	public Block getBlock() {
		return block;
	}

	@Override
	public String toString() {
		return "ID: " + id + ", Name: " + name + ", Address: " + address + ", Priority: " + priority + ", Block: "
				+ block.getName() + ", Subjects: " + block.getSubject();
	}
}