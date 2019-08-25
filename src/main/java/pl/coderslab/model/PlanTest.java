package pl.coderslab.dao;

import pl.coderslab.model.Plan;

import java.util.List;

public class PlanTest {
    public static void main(String[] args) {


        Plan plan = new Plan();
        PlanDao planDao = new PlanDao();
        //plan = planDao.read(1);

        //planDao.create(new Plan("Plan otyły", "Opis planu otyłego", 1));
        //planDao.delete(13);



        String x = plan.toString();
        System.out.println(x);
        System.out.println();
        System.out.println();

        List<Plan> pl = planDao.findAll();
        for(Plan p : pl) {
            System.out.println(p.toString());
        }


    }



}
