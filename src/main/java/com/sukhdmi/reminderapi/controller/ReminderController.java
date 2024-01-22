package com.sukhdmi.reminderapi.controller;

import com.sukhdmi.reminderapi.dto.ReminderDTO;
import com.sukhdmi.reminderapi.entity.Reminder;
import com.sukhdmi.reminderapi.service.ReminderService;
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

    @PostMapping("/create")
    public ResponseEntity<Reminder> create(@RequestBody ReminderDTO dto){
        return new ResponseEntity<>(reminderService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Reminder>> readAll(){
        return new ResponseEntity<>(reminderService.readAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Reminder> update(@RequestBody Reminder reminder){
        return new ResponseEntity<>(reminderService.update(reminder), HttpStatus.OK);
    }

    @DeleteMapping({"/delete/id"})
    public HttpStatus delete(@PathVariable Long id){
        reminderService.delete(id);
        return HttpStatus.OK;
    }
}
//контроллер, который обрабатывает запросы, связанные с созданием, чтением,
//обновлением и удалением напоминаний через соответствующие методы,используя ReminderService для выполнения бизнес-логики.