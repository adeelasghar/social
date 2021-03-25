/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mentoringminds.haris.social.model;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author muham
 */

@XmlRootElement
@Entity
@NamedQueries({
        @NamedQuery(name = "Message.findById",
                query = "SELECT m.message FROM Message m WHERE m.id = :id")
})
public class Message implements Serializable {
@Id
private int id;
private String message;
private String author;

public Message() {}
public Message(int id,String message,String author) {
	this.id=id;
	this.message=message;

	
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}

public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}

}
