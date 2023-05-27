package com.springproject.springproject.Entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
public class Salesman {

    @Override
    public String toString() {
        return "Salesman [salesman_id=" + salesman_id + ", name=" + name + ", area=" + area + ", commission_rate="
                + commission_rate + "]";
    }
    private int salesman_id;
    private String name;
    private String area;
    private int commission_rate;

}

