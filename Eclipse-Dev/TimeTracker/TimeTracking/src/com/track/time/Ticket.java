/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.track.time;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author superlamer
 */
@Entity
@Table(name = "TICKET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t")
    , @NamedQuery(name = "Ticket.findByNumber", query = "SELECT t FROM Ticket t WHERE t.number = :number")
    , @NamedQuery(name = "Ticket.findByDescription", query = "SELECT t FROM Ticket t WHERE t.description = :description")
    , @NamedQuery(name = "Ticket.findByComments", query = "SELECT t FROM Ticket t WHERE t.comments = :comments")
    , @NamedQuery(name = "Ticket.findByHours", query = "SELECT t FROM Ticket t WHERE t.hours = :hours")
    , @NamedQuery(name = "Ticket.findByDay", query = "SELECT t FROM Ticket t WHERE t.day = :day")})
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NUMBER")
    private String number;
    @Lob
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "HOURS")
    private Integer hours;
    @Column(name = "DAY")
    @Temporal(TemporalType.DATE)
    private Date day;
    @Lob
    @Column(name = "COMMENTS")
    private String comments;

    public Ticket() {
    }

    public Ticket(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (number != null ? number.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.number == null && other.number != null) || (this.number != null && !this.number.equals(other.number))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.track.time.Ticket[ number=" + number + " ]";
    }
    
}
