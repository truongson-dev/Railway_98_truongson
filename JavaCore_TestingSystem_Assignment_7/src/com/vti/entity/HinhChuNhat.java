package com.vti.entity;

public class HinhChuNhat extends HinhHoc {
    
    public HinhChuNhat(float chieuDai, float chieuRong) throws HinhHocException {
        super(chieuDai, chieuRong);
    }

    @Override
    public float tinhChuVi() {
        return 2 * (a + b);
    }

    @Override
    public float tinhDienTich() {
        return a * b;
    }
}