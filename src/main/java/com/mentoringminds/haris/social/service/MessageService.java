/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mentoringminds.haris.social.service;

import com.mentoringminds.haris.social.model.Message;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
//import javax.persistence.TypedQuery;
import javax.persistence.Query;

public class MessageService {
	
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("Message");

	
	 public static Message save(Message message) {
	        // The EntityManager class allows operations such as create, read, update, delete
	        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
	        // Used to issue transactions on the EntityManager
	        EntityTransaction et = null;
	 
	        try {
	            // Get transaction and start
	            et = em.getTransaction();
	            et.begin();
	 
	            // Create and set values for new customer
	            Message m= new Message(); 
	            m.setId(message.getId());
	            m.setMessage(message.getMessage());
	            m.setAuthor(message.getAuthor());
	 
	            // Save the customer object
	            em.persist(m);
	            et.commit();
	            return m;
	        
	        } catch (Exception ex) {
	            // If there is an exception rollback changes
	            if (et != null) {
	                et.rollback();
	            }
	            ex.printStackTrace();
	        } finally {
	            // Close EntityManager
	            em.close();
	        }
			return null;
	 }
	 
	 public static List<Message> getAllRecords() {
	        // The EntityManager class allows operations such as create, read, update, delete
	        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
	        // Used to issue transactions on the EntityManager
	        String strquery= "SELECT m from Message m where m.id IS NOT NULL";
	        Query q = em.createQuery(strquery,Message.class );
	        List <Message> message;
	        try {
	        	message=q.getResultList();
	        	return message;
	        }catch(NoResultException ex) {
	    		ex.printStackTrace();
	    	}
	    	finally {
	    		em.close();
	    	}
			return null;
	        
	        
	 }
         
         public static Message findById(int id){
          EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
              Message message = em.createNamedQuery("Message.findById", Message.class)
                .setParameter("id", id)
                .getSingleResult();
            return message;
         }
	 
	 
	 public static Message update(Message m) {
	        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
	        EntityTransaction et = null;
	        Message message=new Message();
	        
	        try {
	        	
	        	et = em.getTransaction();
	            et.begin();
	            message.setMessage(m.getMessage());
	            message.setAuthor(m.getAuthor());
	            message.setId(m.getId());
	            // Get transaction and start
	            
	            em.merge(message);
	            et.commit();
	            return message;
	        } catch (Exception ex) {
	            // If there is an exception rollback changes
	            if (et != null) {
	                et.rollback();
	            }
	            ex.printStackTrace();
	        } finally {
	            // Close EntityManager
	            em.close();
	        }
			return null;
		
	    }
	 
	 
	 public static void delete(int id) {
	    	EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
	        EntityTransaction et = null;
	       Message message = null;
	 
	        try {
	            et = em.getTransaction();
	            et.begin();
	             message= em.find(Message.class,id);
	            em.remove(message);
	            et.commit();
	        } catch (Exception ex) {
	            // If there is an exception rollback changes
	            if (et != null) {
	                et.rollback();
	            }
	            ex.printStackTrace();
	        } finally {
	            // Close EntityManager
	            em.close();
	        }
	    }
	 
}
	
	
	
	
	

