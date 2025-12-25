package com.vti.entity.ex6;

public class VietnamesePhone extends Phone {

	@Override
	public void insertContact(String name, String phone) {
		contacts.add(new Contact(name, phone));
		System.out.println("Đã thêm contact: " + name + " - " + phone);
	}

	@Override
	public void removeContact(String name) {
		contacts.removeIf(contact -> contact.getName().equals(name));
		System.out.println("Đã xóa contact: " + name);
	}

	@Override
	public void updateContact(String name, String newPhone) {
		for (Contact contact : contacts) {
			if (contact.getName().equals(name)) {
				contact.setPhone(newPhone);
				System.out.println("Đã cập nhật contact: " + name + " - " + newPhone);
				return;
			}
		}
		System.out.println("Không tìm thấy contact: " + name);
	}

	@Override
	public void searchContact(String name) {
		for (Contact contact : contacts) {
			if (contact.getName().equals(name)) {
				System.out.println("Tìm thấy: " + contact);
				return;
			}
		}
		System.out.println("Không tìm thấy contact: " + name);
	}

	public void printContacts() {
		if (contacts.isEmpty()) {
			System.out.println("Danh bạ trống!");
		} else {
			System.out.println("Danh sách contacts:");
			for (Contact contact : contacts) {
				System.out.println("  " + contact);
			}
		}
	}
}