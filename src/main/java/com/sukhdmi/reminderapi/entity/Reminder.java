package com.sukhdmi.reminderapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Entity//указывает, что класс является сущностью, которая будет отображаться в базе данных.
//Каждый объект этого класса будет представлять отдельную запись в таблице базы данных.

@Data//генерирует стандартные методы, такие как геттеры, сеттеры,
//методы  equals ,  hashCode  и  toString , для всех полей класса.

@Builder//генерирует паттерн проектирования "Строитель" (Builder pattern).
//Она позволяет создавать объекты класса с помощью паттерна "Строитель", что делает код более читаемым
//и гибким при создании экземпляров класса с большим количеством полей.

@NoArgsConstructor//генерирует конструктор без аргументов, который используется,
//когда требуется создать объект класса без передачи аргументов.

@AllArgsConstructor//генерирует конструктор, который принимает все поля класса в качестве аргументов.
//Он используется, когда требуется создать объект класса и передать значения для всех его полей.

public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//Уникальный идентификатор

    @NotNull
    @Size(min=1, max = 255)
    private String title;//Краткое описание

    @NotNull
    @Size(min=1, max = 4096)
    private String description;//Полное описание

    @JsonFormat(pattern = "yyyy-MM-ddTHH:mm:ss.SSSZ")//при сериализации и десериализации объекта в формат JSON,
    //значение поля remind будет отформатировано в соответствии с указанным шаблоном.
    private LocalDateTime remind;//Дата и время напоминания в формате ISO

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
//класс  Reminder  является сущностью, которая будет отображаться в базе данных.
