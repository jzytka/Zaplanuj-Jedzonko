package pl.coderslab.model;

import pl.coderslab.dao.AdminDao;
import pl.coderslab.dao.PlanDao;
//import pl.coderslab.dao.PlanDao;

import java.util.Collections;
import java.util.List;

public class AdminTest {
    public static void main(String[] args) {
       int wynik =  PlanDao.countPlans(1);
        System.out.println(wynik);

    }
}
