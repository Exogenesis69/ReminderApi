package com.sukhdmi.reminderapi.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReminderDTO {
    private String title;
    private String description;
    private LocalDateTime remind;
    private Long userId;

}
//используется для передачи данных между различными компонентами приложения или между самим приложением
// и внешними системами. Он представляет собой простой контейнер данных, который содержит поля (атрибуты)
// и соответствующие геттеры и сеттеры для доступа к этим полям.