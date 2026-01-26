package com.vti.backend;

import com.vti.entity.*;
import com.vti.utils.ScannerUtils;
import java.util.*;
import java.time.LocalDate;

public class Exercise1 {
    private List<Student> listStudent;
    private Stack<Student> stackStudent;
    private Queue<Student> queueStudent;
    private Set<Student> studentSet;
    private Map<Integer, String> studentMap;
    private int mapCount = 1;
    
    public Exercise1() {
        listStudent = new ArrayList<>();
        stackStudent = new Stack<>();
        queueStudent = new LinkedList<>();
        studentSet = new HashSet<>();
        studentMap = new HashMap<>();
    }
    
    // ========== QUESTION 1: LIST ==========
    public void question1() {
        while (true) {
            System.out.println("\n=== QUẢN LÝ STUDENT (LIST) ===");
            System.out.println("1. In tổng số phần tử");
            System.out.println("2. Lấy phần tử thứ 4");
            System.out.println("3. In phần tử đầu và cuối");
            System.out.println("4. Thêm phần tử đầu/cuối");
            System.out.println("5. Thêm phần tử cuối");
            System.out.println("6. Đảo ngược danh sách");
            System.out.println("7. Tìm kiếm theo ID");
            System.out.println("8. Tìm kiếm theo tên");
            System.out.println("9. In student trùng tên");
            System.out.println("10. Xóa tên student ID=2");
            System.out.println("11. Xóa student ID=5");
            System.out.println("12. Tạo bản copy");
            System.out.println("13. Thêm 3 student trùng tên (mặc định)");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");
            
            int choice = ScannerUtils.inputInt();
            
            switch (choice) {
                case 1:
                    System.out.println("Tổng số student: " + listStudent.size());
                    printList();
                    break;
                case 2:
                    if (listStudent.size() >= 4) {
                        System.out.println("Phần tử thứ 4: " + listStudent.get(3));
                    } else {
                        System.out.println("Không đủ phần tử!");
                    }
                    break;
                case 3:
                    if (!listStudent.isEmpty()) {
                        System.out.println("Phần tử đầu: " + listStudent.get(0));
                        System.out.println("Phần tử cuối: " + listStudent.get(listStudent.size()-1));
                    }
                    break;
                case 4:
                    System.out.print("Nhập tên student: ");
                    String name = ScannerUtils.inputString();
                    System.out.print("Thêm vào đầu (1) hay cuối (2): ");
                    int pos = ScannerUtils.inputInt();
                    if (pos == 1) {
                        listStudent.add(0, new Student(name));
                    } else {
                        listStudent.add(new Student(name));
                    }
                    System.out.println("Đã thêm thành công!");
                    break;
                case 5:
                    System.out.print("Nhập tên student: ");
                    String name5 = ScannerUtils.inputString();
                    listStudent.add(new Student(name5));
                    System.out.println("Đã thêm vào cuối!");
                    break;
                case 6:
                    Collections.reverse(listStudent);
                    System.out.println("Đã đảo ngược danh sách!");
                    printList();
                    break;
                case 7:
                    System.out.print("Nhập ID cần tìm: ");
                    int id = ScannerUtils.inputInt();
                    boolean found = false;
                    for (Student s : listStudent) {
                        if (s.getId() == id) {
                            System.out.println("Tìm thấy: " + s);
                            found = true;
                        }
                    }
                    if (!found) System.out.println("Không tìm thấy!");
                    break;
                case 8:
                    System.out.print("Nhập tên cần tìm: ");
                    String searchName = ScannerUtils.inputString();
                    for (Student s : listStudent) {
                        if (s.getName().equals(searchName)) {
                            System.out.println("Tìm thấy: " + s);
                        }
                    }
                    break;
                case 9:
                    System.out.println("Student trùng tên:");
                    Map<String, Integer> nameCount = new HashMap<>();
                    for (Student s : listStudent) {
                        nameCount.put(s.getName(), nameCount.getOrDefault(s.getName(), 0) + 1);
                    }
                    for (Student s : listStudent) {
                        if (nameCount.get(s.getName()) > 1) {
                            System.out.println(s);
                        }
                    }
                    break;
                case 10:
                    for (Student s : listStudent) {
                        if (s.getId() == 2) {
                            s.setName(null);
                            System.out.println("Đã xóa tên student ID=2");
                        }
                    }
                    break;
                case 11:
                    listStudent.removeIf(s -> s.getId() == 5);
                    System.out.println("Đã xóa student ID=5");
                    break;
                case 12:
                    List<Student> copy = new ArrayList<>(listStudent);
                    System.out.println("Bản copy:");
                    for (Student s : copy) {
                        System.out.println(s);
                    }
                    break;
                case 13:
                    listStudent.add(new Student("Student Name"));
                    listStudent.add(new Student("Student Name"));
                    listStudent.add(new Student("Student Name"));
                    System.out.println("Đã thêm 3 student trùng tên!");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
    
    private void printList() {
        System.out.println("Danh sách student:");
        for (Student s : listStudent) {
            System.out.println(s);
        }
    }
    
    // ========== QUESTION 2: STACK & QUEUE ==========
    public void question2() {
        while (true) {
            System.out.println("\n=== STACK & QUEUE ===");
            System.out.println("1. Thêm student vào Stack");
            System.out.println("2. In Stack (sớm -> muộn)");
            System.out.println("3. Lấy student muộn nhất từ Stack");
            System.out.println("4. Thêm student vào Queue");
            System.out.println("5. In Queue (sớm -> muộn)");
            System.out.println("6. Lấy student từ Queue");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");
            
            int choice = ScannerUtils.inputInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Nhập tên student: ");
                    String name = ScannerUtils.inputString();
                    stackStudent.push(new Student(name));
                    System.out.println("Đã thêm vào Stack!");
                    break;
                case 2:
                    System.out.println("Stack (sớm nhất -> muộn nhất):");
                    for (Student s : stackStudent) {
                        System.out.println(s);
                    }
                    break;
                case 3:
                    if (!stackStudent.isEmpty()) {
                        System.out.println("Student muộn nhất: " + stackStudent.peek());
                        System.out.println("Lấy ra từ muộn -> sớm:");
                        while (!stackStudent.isEmpty()) {
                            System.out.println(stackStudent.pop());
                        }
                    } else {
                        System.out.println("Stack rỗng!");
                    }
                    break;
                case 4:
                    System.out.print("Nhập tên student: ");
                    String nameQ = ScannerUtils.inputString();
                    queueStudent.add(new Student(nameQ));
                    System.out.println("Đã thêm vào Queue!");
                    break;
                case 5:
                    System.out.println("Queue (sớm nhất -> muộn nhất):");
                    for (Student s : queueStudent) {
                        System.out.println(s);
                    }
                    break;
                case 6:
                    System.out.println("Lấy từ Queue:");
                    while (!queueStudent.isEmpty()) {
                        System.out.println(queueStudent.poll());
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
    
    // ========== QUESTION 3: SET ==========
    public void question3() {
        while (true) {
            System.out.println("\n=== SET OPERATIONS ===");
            System.out.println("1. Thêm student vào Set");
            System.out.println("2. In tổng số phần tử");
            System.out.println("3. Lấy phần tử thứ 4");
            System.out.println("4. In phần tử đầu và cuối");
            System.out.println("5. Thêm phần tử vào cuối");
            System.out.println("6. Tìm kiếm theo ID");
            System.out.println("7. Tìm kiếm theo tên");
            System.out.println("8. Xóa theo ID");
            System.out.println("9. Xóa tên theo ID");
            System.out.println("10. Tạo bản copy Set");
            System.out.println("11. In tất cả Set");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");
            
            int choice = ScannerUtils.inputInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Nhập tên student: ");
                    String name = ScannerUtils.inputString();
                    studentSet.add(new Student(name));
                    System.out.println("Đã thêm vào Set!");
                    break;
                case 2:
                    System.out.println("Tổng số phần tử: " + studentSet.size());
                    break;
                case 3:
                    if (studentSet.size() >= 4) {
                        Iterator<Student> it = studentSet.iterator();
                        for (int i = 0; i < 3; i++) it.next();
                        System.out.println("Phần tử thứ 4: " + it.next());
                    }
                    break;
                case 4:
                    if (!studentSet.isEmpty()) {
                        Iterator<Student> it = studentSet.iterator();
                        System.out.println("Phần tử đầu: " + it.next());
                        Student last = null;
                        for (Student s : studentSet) last = s;
                        System.out.println("Phần tử cuối: " + last);
                    }
                    break;
                case 5:
                    System.out.print("Nhập tên student: ");
                    String name5 = ScannerUtils.inputString();
                    studentSet.add(new Student(name5));
                    System.out.println("Đã thêm!");
                    break;
                case 6:
                    System.out.print("Nhập ID cần tìm: ");
                    int id = ScannerUtils.inputInt();
                    for (Student s : studentSet) {
                        if (s.getId() == id) {
                            System.out.println("Tìm thấy: " + s);
                        }
                    }
                    break;
                case 7:
                    System.out.print("Nhập tên cần tìm: ");
                    String searchName = ScannerUtils.inputString();
                    for (Student s : studentSet) {
                        if (s.getName().equals(searchName)) {
                            System.out.println("Tìm thấy: " + s);
                        }
                    }
                    break;
                case 8:
                    System.out.print("Nhập ID cần xóa: ");
                    int delId = ScannerUtils.inputInt();
                    studentSet.removeIf(s -> s.getId() == delId);
                    System.out.println("Đã xóa!");
                    break;
                case 9:
                    System.out.print("Nhập ID cần xóa tên: ");
                    int delNameId = ScannerUtils.inputInt();
                    for (Student s : studentSet) {
                        if (s.getId() == delNameId) {
                            s.setName(null);
                        }
                    }
                    System.out.println("Đã xóa tên!");
                    break;
                case 10:
                    Set<Student> copySet = new HashSet<>(studentSet);
                    System.out.println("Bản copy Set:");
                    for (Student s : copySet) {
                        System.out.println(s);
                    }
                    break;
                case 11:
                    System.out.println("Toàn bộ Set:");
                    for (Student s : studentSet) {
                        System.out.println(s);
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
    
    // ========== QUESTION 4 & 5: SET KHÔNG TRÙNG TÊN ==========
    public void question4_5() {
        Set<StudentQues45> studentSet45 = new HashSet<>();
        
        while (true) {
            System.out.println("\n=== SET KHÔNG TRÙNG TÊN ===");
            System.out.println("1. Thêm student (không trùng tên)");
            System.out.println("2. In danh sách");
            System.out.println("3. Sắp xếp theo tên");
            System.out.println("4. In số lượng");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");
            
            int choice = ScannerUtils.inputInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Nhập ID: ");
                    int id = ScannerUtils.inputInt();
                    System.out.print("Nhập tên: ");
                    String name = ScannerUtils.inputString();
                    studentSet45.add(new StudentQues45(id, name));
                    System.out.println("Đã thêm!");
                    break;
                case 2:
                    System.out.println("Danh sách student:");
                    for (StudentQues45 s : studentSet45) {
                        System.out.println(s);
                    }
                    break;
                case 3:
                    List<StudentQues45> sortedList = new ArrayList<>(studentSet45);
                    Collections.sort(sortedList);
                    System.out.println("Danh sách sau khi sắp xếp:");
                    for (StudentQues45 s : sortedList) {
                        System.out.println(s);
                    }
                    break;
                case 4:
                    System.out.println("Số lượng student: " + studentSet45.size());
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
    
    // ========== QUESTION 6 & 7: MAP ==========
    public void question6_7() {
        while (true) {
            System.out.println("\n=== MAP OPERATIONS ===");
            System.out.println("1. Thêm student vào Map");
            System.out.println("2. In tất cả keys");
            System.out.println("3. In tất cả values");
            System.out.println("4. Sắp xếp theo tên");
            System.out.println("5. Chuyển Map sang Set");
            System.out.println("6. In toàn bộ Map");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");
            
            int choice = ScannerUtils.inputInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Nhập tên student: ");
                    String name = ScannerUtils.inputString();
                    studentMap.put(mapCount++, name);
                    System.out.println("Đã thêm với ID: " + (mapCount-1));
                    break;
                case 2:
                    System.out.println("Tất cả keys:");
                    for (Integer key : studentMap.keySet()) {
                        System.out.println(key);
                    }
                    break;
                case 3:
                    System.out.println("Tất cả values:");
                    for (String value : studentMap.values()) {
                        System.out.println(value);
                    }
                    break;
                case 4:
                    System.out.println("Sắp xếp theo tên:");
                    List<Map.Entry<Integer, String>> list = 
                        new ArrayList<>(studentMap.entrySet());
                    Collections.sort(list, Map.Entry.comparingByValue());
                    for (Map.Entry<Integer, String> entry : list) {
                        System.out.println("ID: " + entry.getKey() + 
                                         ", Name: " + entry.getValue());
                    }
                    break;
                case 5:
                    Set<Map.Entry<Integer, String>> entrySet = studentMap.entrySet();
                    System.out.println("Entry Set:");
                    for (Map.Entry<Integer, String> entry : entrySet) {
                        System.out.println(entry);
                    }
                    break;
                case 6:
                    System.out.println("Toàn bộ Map:");
                    for (Map.Entry<Integer, String> entry : studentMap.entrySet()) {
                        System.out.println("ID: " + entry.getKey() + 
                                         ", Name: " + entry.getValue());
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}