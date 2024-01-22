package com.sukhdmi.reminderapi.service;

import com.sukhdmi.reminderapi.dto.ReminderDTO;
import com.sukhdmi.reminderapi.entity.Reminder;
import com.sukhdmi.reminderapi.repository.ReminderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//этот класс представляет сервис, который обрабатывает операции, связанные с сущностью  Reminder .
@AllArgsConstructor//генерирует конструктор, который принимает все поля класса в качестве аргументов.
public class ReminderService {

    private final ReminderRepository reminderRepository;

    public Reminder create(ReminderDTO dto) {
        return reminderRepository.save(Reminder.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .remind(dto.getRemind())
                .user_id(dto.getUser_id())
                .build());
    }

    public List<Reminder>readAll(){
        return reminderRepository.findAll();
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