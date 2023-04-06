package com.liruilong.hros.model;

/**
 * @Description :

 * @Date: 2020/2/18 12:25
 */
public class EmailModel {

    private Employee employee;

    private String title;

    private String content;

    private String path;

    private String toEmail;


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public EmailModel() {
    }

    public EmailModel(Employee employee, String title, String content, String path) {
        this.employee = employee;
        this.title = title;
        this.content = content;
        this.path = path;
    }
    public EmailModel(Employee employee, String title, String path) {
        this.employee = employee;
        this.title = title;
        this.path = path;
    }

    public EmailModel(String title, String content, String path,String toEmail) {
        this.title = title;
        this.content = content;
        this.path = path;
        this.toEmail = toEmail;
    }

    @Override
    public String toString() {
        return "EmailModel{" +
                "employee=" + employee +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
