class Account {
    // Khai báo các thuộc tính.
    id;
    email;
    userName;
    fullName;
    department;
    position;
    createDate;
    // Khai báo constructor.
    constructor(id, email, userName, fullName, department, position, createDate) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.fullName = fullName;
        this.department = department;
        this.position = position;
        this.createDate = createDate;
    }
    getId() {
        return this.id;
    }
    getEmail() {
        return this.email;
    }
    getUserName() {
        return this.userName;
    }
    getFullName() {
        return this.fullName;
    }
    getDepartment() {
        return this.department;
    }
    getPosition() {
        return this.position;
    }
    getCreateDate() {
        return this.createDate;
    }
    setId(id) {
        this.id = id;
    }
    setEmail(email) {
        this.email = email;
    }
    setUserName(userName) {
        this.userName = userName;
    }
    setFullName(fullName) {
        this.fullName = fullName;
    }
    setDepartment(department) {
        this.department = department;
    }
    setPosition(position) {
        this.position = position;
    }
    setCreateDate(createDate) {
        this.createDate = createDate;
    }
}
// Hàm in thông tin Account, viết bên ngoài class
function printInforAccount(account) {
    console.log("ID: " + account.getId() + " UserName: " + account.getUserName() + " Fullname: " + account.getFullName() + " Department: " + account.getDepartment().getName() + " Position: " + account.getPosition().getName());
}
// Export Account và hàm printInforAccount sang class khác để sử dụng.
export { Account, printInforAccount };
