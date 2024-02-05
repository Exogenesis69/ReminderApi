package com.sukhdmi.reminderapi.service;

import com.sukhdmi.reminderapi.dto.ReminderDTO;
import com.sukhdmi.reminderapi.entity.Reminder;
import com.sukhdmi.reminderapi.repository.ReminderRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//этот класс представляет сервис, который обрабатывает операции, связанные с сущностью  Reminder .
@AllArgsConstructor//генерирует конструктор, который принимает все поля класса в качестве аргументов.
public class ReminderService {

    private final ReminderRepository reminderRepository;
    private final UserService userService;

    public Reminder create(ReminderDTO dto) {
        return reminderRepository.save(Reminder.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .remind(dto.getRemind())
                .user(userService.readById(dto.getUserId()))
                .build());
    }

    public List<Reminder>readAll(){
        return reminderRepository.findAll();
    }
    public Page<Reminder> readAll(Pageable page){
        return reminderRepository.findAll(page);
    }

    public List<Reminder> readByUserId(Long user_id) {
        return reminderRepository.findByUserId(user_id);
    }

    public Reminder update(Reminder reminder){
        return reminderRepository.save(reminder);
    }

    public void delete(Long id){
        reminderRepository.deleteById(id);
    }

}
//инкапсулирует бизнес-логику, связанную с сущностью  Reminder , и предоставляет методы
//для выполнения операций создания, чтения, обновления и удаления напоминаний. Он использует  ReminderRepository
//для доступа к базе данных и выполнения операций сущности  Reminder.
