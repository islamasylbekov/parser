package org.example.models;

import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@MappedSuperclass
public abstract class BaseModel  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
