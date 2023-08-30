package com.chatgpt.repository;

import com.chatgpt.dto.AdminDB;
import com.chatgpt.model.Role;
import com.chatgpt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    List<User> findByRole(Role role);

    User findByUserName(String userName);

    @Query("SELECT DISTINCT u FROM User u WHERE u.balance.balance = 0 AND u.id IN (SELECT r.user.id FROM Record r)")
    List<User> findUsersWithZeroBalanceAndRecords();

    @Query("SELECT DISTINCT q.user, q FROM Question q " +
            "WHERE q.user.role.role = 'ADMIN' " +
            "AND EXISTS (SELECT r FROM Record r WHERE r.user = q.user AND r.question = q)")
    List<Object[]> findAdminUsersWithQuestionsAndRecords();
}
