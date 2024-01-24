package com.map;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	
	public static void main(String []args) {
		Configuration cfg=new Configuration();
		cfg.configure("com/tut/HibernateProjectOne/hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		
		// creating question
		Question q1=new Question();
		int Qid = Integer.parseInt(JOptionPane.showInputDialog("Enter the Question Id"));
		q1.setQuestionId(Qid);
		String q = JOptionPane.showInputDialog("Enter the Question");
        q1.setQuestion(q);
		
        
        
		// creating answer
        // many answer creating
		Answer ans=new Answer();
		int aId = Integer.parseInt(JOptionPane.showInputDialog("Enter the Answer Id 1"));
		ans.setAnswerId(aId);
		String a  = JOptionPane.showInputDialog("Enter the Answer 1");
		ans.setAnswer(a);
		ans.setQuestion(q1);
		
		
		
		Answer an1=new Answer();
		int aId1 = Integer.parseInt(JOptionPane.showInputDialog("Enter the Answer Id 2"));
		an1.setAnswerId(aId1);
		String a1  = JOptionPane.showInputDialog("Enter the Answer 2");
		an1.setAnswer(a1);
		an1.setQuestion(q1);
		
		
		Answer an2=new Answer();
		int aId2 = Integer.parseInt(JOptionPane.showInputDialog("Enter the Answer Id"));
		an2.setAnswerId(aId2);
		String a2  = JOptionPane.showInputDialog("Enter the Answer 3");
		an2.setAnswer(a2);
		an2.setQuestion(q1);
		
		
 	
		List<Answer>list=new ArrayList<Answer>();
		list.add(ans);
		list.add(an1);
		list.add(an2);
		 
		
		q1.setAnswers(list);

		
		
		// session creating
		Session s=factory.openSession();
		Transaction tx=s.beginTransaction();
		
		// save
		s.save(q1);
	    s.save(ans);
	    s.save(an1);
	    s.save(an2);
	    

		tx.commit();
		
		
		// fetching.......
//		int qid = Integer.parseInt(JOptionPane.showInputDialog("Enter the question Id"));
//		Question newQ=s.load(Question.class, qid);
//		System.out.println(newQ.getQuestion());
//		 for(Answer a : q1.getAnswer()) {
//			 System.out.println(a.getAnswer());
//		 }
		
		
		s.close();
		factory.close();
	}
}
