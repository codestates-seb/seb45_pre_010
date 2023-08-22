//package com.hexacoder.stackoverflow.question.entity_mapping;
//
//import com.hexacoder.stackoverflow.question.entity.Question;
//import com.hexacoder.stackoverflow.user.entity.UserEntity;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//
//@Configuration
//public class JpaManyToOneUniDirectionConfig {
//    private EntityManager em;
//    private EntityTransaction tx;
//
//    @Bean
//    public CommandLineRunner testJpaManyToOneRunner(EntityManagerFactory emFactory) {
//        this.em = emFactory.createEntityManager();
//        this.tx = em.getTransaction();
//
//        return args -> {
//            mappingManyToOneUniDirection();
//        };
//    }
//    private void mappingManyToOneUniDirection() {
//        tx.begin();
//        UserEntity user = new UserEntity(1L, "hgd@gmail.com", "1234", "nickname");
//
//
//        em.persist(user);
//
//        Question question = new Question();
//        question.addUser(user);
//        em.persist(question);
//
//        tx.commit();
//
//
//        Question findQuestion = em.find(Question.class, 1L);
//
//        // 질문에 해당하는 회원 정보를 가져올 수 있다.
//        System.out.println("findQuestion: " + findQuestion.getUser().getUserId() +
//                ", " + findQuestion.getUser().getNickname());
//    }
//}
