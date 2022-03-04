package com.example.SenderWithRabitV2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//must be like objectReceiver class from the listener
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntityToSend {

    private String name;

    private String description;
}
