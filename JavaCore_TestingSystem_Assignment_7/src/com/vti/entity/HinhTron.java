package com.vti.entity;

public class HinhTron extends HinhHoc {
    
    public HinhTron(float banKinh) throws HinhHocException {
        super(banKinh, 0);
    }

    @Override
    public float tinhChuVi() {
        return 2 * a * Config.PI;
    }

    @Override
    public float tinhDienTich() {
        return a * a * Config.PI;
    }
}