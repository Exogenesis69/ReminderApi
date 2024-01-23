package com.sukhdmi.reminderapi.controller;

import com.sukhdmi.reminderapi.dto.ReminderDTO;
import com.sukhdmi.reminderapi.entity.Reminder;
import com.sukhdmi.reminderapi.entity.User;
import com.sukhdmi.reminderapi.service.ReminderService;
import com.sukhdmi.reminderapi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//указывает,что класс является контроллером веб-службы RESTful. Он объединяет аннотации  @Controller
//и @ResponseBody,что означает,что каждый метод в контроллере возвращает данные, которые будут преобразованы в формат ответа HTTP

@RequestMapping("/api/v1/reminder")//указывает базовый путь для всех методов в контроллере.

@AllArgsConstructor//генерирует конструктор, который принимает все поля класса в качестве аргументов.
public class ReminderController {
    private final ReminderService reminderService;
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Reminder> create(@RequestBody ReminderDTO dto){
        return mappingResponseReminder(reminderService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<Reminder>> readAll(){
        return mappingResponseListReminder(reminderService.readAll());
    }

    @GetMapping("/user{user_id}")
    public ResponseEntity<List<Reminder>> readByUserId(@PathVariable Long user_id){
        return mappingResponseListReminder(reminderService.readByUserId(user_id));
    }

    @PutMapping
    public ResponseEntity<Reminder> update(@RequestBody Reminder reminder){
        return mappingResponseReminder(reminderService.update(reminder));
    }

    @DeleteMapping({"/delete/id"})
    public HttpStatus delete(@PathVariable Long id){
        reminderService.delete(id);
        return HttpStatus.OK;
    }

    private ResponseEntity<Reminder> mappingResponseReminder(Reminder reminder) {
        return new ResponseEntity<>(reminder, HttpStatus.OK);
    }

    private ResponseEntity<List<Reminder>> mappingResponseListReminder(List<Reminder> reminders) {
        return new ResponseEntity<>(reminders, HttpStatus.OK);
    }
}
//контроллер, который обрабатывает запросы, связанные с созданием, чтением,
//обновлением и удалением напоминаний через соответствующие методы,используя ReminderService для выполнения бизнес-логики.