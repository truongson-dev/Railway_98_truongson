package com.vti.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileUtils {
    public static final String FILE_EXISTS = "File đã tồn tại!";
    public static final String FILE_NOT_EXISTS = "File không tồn tại!";
    public static final String FOLDER_EXISTS = "Folder đã tồn tại!";
    public static final String FOLDER_NOT_EXISTS = "Folder không tồn tại!";
    public static final String PATH_NOT_FOLDER = "Đường dẫn không phải là folder!";
    public static final String SOURCE_FILE_NOT_EXISTS = "File nguồn không tồn tại!";
    public static final String DESTINATION_FILE_EXISTS = "File đích đã tồn tại!";
    public static final String CREATE_FILE_SUCCESS = "Tạo file thành công!";
    public static final String CREATE_FILE_FAIL = "Tạo file thất bại!";
    public static final String DELETE_FILE_SUCCESS = "Xóa file thành công!";
    public static final String DELETE_FILE_FAIL = "Xóa file thất bại!";

    public static boolean isFileExists(String path) {
        return new File(path).exists();
    }

    public static boolean isFolderExists(String path) {
        File file = new File(path);
        return file.exists() && file.isDirectory();
    }

    public static void createNewFile(String path) throws IOException {
        File file = new File(path);
        if (file.exists()) {
            throw new IOException(FILE_EXISTS);
        }
        if (file.createNewFile()) {
            System.out.println(CREATE_FILE_SUCCESS);
        } else {
            System.out.println(CREATE_FILE_FAIL);
        }
    }

    public static void createNewFile(String path, String fileName) throws IOException {
        createNewFile(path + File.separator + fileName);
    }

    public static void deleteFile(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            throw new IOException(FILE_NOT_EXISTS);
        }
        if (file.delete()) {
            System.out.println(DELETE_FILE_SUCCESS);
        } else {
            System.out.println(DELETE_FILE_FAIL);
        }
    }

    public static boolean isFolder(String path) {
        return new File(path).isDirectory();
    }

    public static String[] getAllFileName(String path) {
        File folder = new File(path);
        if (!folder.isDirectory()) {
            System.out.println(PATH_NOT_FOLDER);
            return null;
        }
        return folder.list();
    }

    public static void copyFile(String sourceFile, String destinationPath) throws IOException {
        File source = new File(sourceFile);
        File dest = new File(destinationPath);
        
        if (!source.exists()) {
            throw new IOException(SOURCE_FILE_NOT_EXISTS);
        }
        if (dest.exists()) {
            throw new IOException(DESTINATION_FILE_EXISTS);
        }
        
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    public static void renameFile(String pathFile, String newName) throws IOException {
        File oldFile = new File(pathFile);
        File newFile = new File(newName);
        
        if (!oldFile.exists()) {
            throw new IOException(FILE_NOT_EXISTS);
        }
        if (newFile.exists()) {
            throw new IOException("Tên file mới đã tồn tại!");
        }
        
        if (oldFile.renameTo(newFile)) {
            System.out.println("Đổi tên file thành công!");
        } else {
            System.out.println("Đổi tên file thất bại!");
        }
    }

    public static void createNewFolder(String path) throws IOException {
        File folder = new File(path);
        if (folder.exists()) {
            throw new IOException(FOLDER_EXISTS);
        }
        if (folder.mkdir()) {
            System.out.println("Tạo folder thành công!");
        } else {
            System.out.println("Tạo folder thất bại!");
        }
    }
}