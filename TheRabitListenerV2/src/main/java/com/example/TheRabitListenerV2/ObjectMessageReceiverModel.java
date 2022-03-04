package com.example.TheRabitListenerV2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//must be like entityToSendClass from sender
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObjectMessageReceiverModel {

    private String name;

    private String description;
}
