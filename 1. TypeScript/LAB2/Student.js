import { Person } from "./Person.js";
class Student extends Person {
    classVTI;
    testScore;
    constructor(id, name, address, classVTI, core) {
        super(id, name, address);
        this.classVTI = classVTI;
        this.testScore = core;
    }
    //   CTRL + SHIFT + P
    /**
     * Getter classVTI
     * @return {string}
     */
    getClassVTI() {
        return this.classVTI;
    }
    /**
     * Getter testScore
     * @return {number}
     */
    getTestScore() {
        return this.testScore;
    }
    /**
     * Setter classVTI
     * @param {string} value
     */
    setClassVTI(value) {
        this.classVTI = value;
    }
    /**
     * Setter testScore
     * @param {number} value
     */
    setTestScore(value) {
        this.testScore = value;
    }
    //   Viết hàm hiển thị thông tin của Student, bao gồm cả thông tin của Person
    showInfo_Student() {
        // Gọi hàm showInfo() của Person để hiển thị thông tin cơ bản
        super.showInfo();
        // Hiển thị thêm thông tin của Student
        console.log(`Thông tin Student: classVTI=${this.classVTI}, testScore=${this.testScore}`);
    }
}
export { Student };
