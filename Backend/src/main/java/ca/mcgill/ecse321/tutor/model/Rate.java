package ca.mcgill.ecse321.cooperator.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Rate {
    private Integer rate;
    

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    @Id
    public Integer getRate() {
        return this.rate;
    }

  