/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deitel.jhtp.jpa;

/**
 *
 * @author superlamer
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DisplayAuthors {
    public static void main(String[] args) {
        // create an Entity Manager Factory for that persistence unit
        EntityManagerFactory entityManagerFactory = 
                Persistence.createEntityManagerFactory("BooksDatabaseExamplePU");
        
        // create and EntityManager for interacting with the persistence unit
        EntityManager entityManager = 
                entityManagerFactory.createEntityManager();
        
        // create dynamic TypedQuery<Authors> that selects all authors
        TypedQuery<Authors> findAllAuthors = entityManager.createQuery(
                "SELECT author FROM Authors AS author", Authors.class);
                
        // display list of Authors
        System.out.printf("Authors Table of Books Database: %n%n");
        System.out.printf("%-12s%-13s%s%n",
                "Author ID", "First Name", "Last Name");
        
        // get all authors, create a stream and display each author
        findAllAuthors.getResultList().stream().
                forEach((author) -> {
                    System.out.printf("%-12s%-13s%s%n", author.getAuthorid(),
                            author.getFirstname(), author.getLastname());
                });
    }
}
