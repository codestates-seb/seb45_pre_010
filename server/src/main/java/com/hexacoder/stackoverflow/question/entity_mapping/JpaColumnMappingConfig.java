//package com.hexacoder.stackoverflow.question.entity_mapping;
//
//import com.hexacoder.stackoverflow.question.entity.Question;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//
//@Configuration
//public class JpaColumnMappingConfig {
//    private EntityManager em;
//    private EntityTransaction tx;
//
//    @Bean
//    public CommandLineRunner testJpaSingleMappingRunner(EntityManagerFactory emFactory){
//        this.em = emFactory.createEntityManager();
//        this.tx = em.getTransaction();
//
//        return args -> {
//           testTitleNotNull();
//           testContentNotNull();
//        };
//    }
//
//    private void testTitleNotNull() {
//        tx.begin();
//        em.persist(new Question());
//        tx.commit();
//    }
//    private void testContentNotNull() {
//        tx.begin();
//        em.persist(new Question());
//        tx.commit();
//    }
//}
