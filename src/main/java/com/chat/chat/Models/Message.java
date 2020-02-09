package com.chat.chat.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String textMsg;
    private String senderName;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Room room;
    private Date date;

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", textMsg='" + textMsg + '\'' +
                ", senderName='" + senderName + '\'' +
                ", date=" + date +
                '}';
    }
}
