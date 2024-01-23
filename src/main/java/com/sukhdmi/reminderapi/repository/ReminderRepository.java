package com.sukhdmi.reminderapi.repository;

import com.sukhdmi.reminderapi.entity.Reminder;
import com.sukhdmi.reminderapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository//используется для пометки класса как репозитория,
//который обеспечивает доступ к данным и выполняет операции с базой данных.
public interface ReminderRepository extends JpaRepository<Reminder, Long> {
    List<Reminder> findByUserId(Long user_id);
}
//предоставляет методы для выполнения операций CRUD с сущностью  Reminder в базе данных, используя
//тип  Long  в качестве идентификатора.
