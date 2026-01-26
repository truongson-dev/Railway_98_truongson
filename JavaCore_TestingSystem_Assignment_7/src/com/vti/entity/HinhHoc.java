package com.vti.entity;

public abstract class HinhHoc {
    protected float a;
    protected float b;
    public static int COUNT = 0;

    public abstract float tinhChuVi();
    public abstract float tinhDienTich();

    public HinhHoc(float a, float b) throws HinhHocException {
        COUNT++;
        if (COUNT > Config.SO_LUONG_HINH_TOI_DA) {
            throw new HinhHocException();
        }
        this.a = a;
        this.b = b;
    }
}