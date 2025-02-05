package com.app.TodoList.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

@Entity
@Table(name = "tbl_task")
public class Task {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int id;
    public String name;
    public boolean status;
    public boolean isCompleted;
    
    public void setCompleted(boolean b) {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }
}
