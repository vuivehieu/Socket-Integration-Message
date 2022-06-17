package com.example.socketintegrationapp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_message")
public class MessageEntity {
    @Id
    private Long id;
    @Column(name = "msg_content")
    private String messageContent;
    @Column(name = "sender")
    private Long sender;
    @Column(name = "msg_status")
    private Boolean messageStatus;
    @CreationTimestamp
    @Column(name = "createdTime")
    private Timestamp createdTime;
}
