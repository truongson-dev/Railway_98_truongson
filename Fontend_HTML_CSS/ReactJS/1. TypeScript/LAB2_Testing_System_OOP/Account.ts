import { Department } from "./Department.js";
import { Possition } from "./Possition.js";

class Account {
    // Khai báo các thuộc tính.
    private id: number;
    private email: string;
    private userName: string;
    private fullName: string;
    private department: Department;
    private position: Possition;
    createDate: Date;
    // Khai báo constructor.
    constructor(id: number, email: string, userName: string, fullName: string, department: Department, position: Possition, createDate: Date) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.fullName = fullName;
        this.department = department;
        this.position = position;
        this.createDate = createDate;
    }
    getId(): number {
        return this.id;
    }
    getEmail(): string {
        return this.email;
    }
    getUserName(): string {
        return this.userName;
    }
    getFullName(): string {
        return this.fullName;
    }
    getDepartment(): Department {
        return this.department;
    }
    getPosition(): Possition {
        return this.position;
    }
    getCreateDate(): Date {
        return this.createDate;
    }
    setId(id: number): void {
        this.id = id;
    }
    setEmail(email: string): void {
        this.email = email;
    }
    setUserName(userName: string): void {
        this.userName = userName;
    }
    setFullName(fullName: string): void {
        this.fullName = fullName;
    }
    setDepartment(department: Department): void {
        this.department = department;
    }
    setPosition(position: Possition): void {
        this.position = position;
    }
    setCreateDate(createDate: Date): void {
        this.createDate = createDate;
    }
}
// Hàm in thông tin Account, viết bên ngoài class
function printInforAccount(account: Account): void {
    console.log("ID: " + account.getId() + " UserName: " + account.getUserName() + " Fullname: " + account.getFullName() + " Department: " + account.getDepartment().getName() + " Position: " + account.getPosition().getName());
}
// Export Account và hàm printInforAccount sang class khác để sử dụng.
export { Account, printInforAccount }
