package ru.vsu.amm.common;

import ru.vsu.amm.dao.impl.UserDaoTmpImpl;
import ru.vsu.amm.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainApp {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        UserDaoTmpImpl userDaoTmp =
                (UserDaoTmpImpl)context.getBean("userDaoTmpImpl");

        System.out.println("------Records Creation--------" );
        userDaoTmp.insert(new User(7, "qw", "qw", "qw", "qw"));

        System.out.println("------Listing Multiple Records--------" );
        List<User> users = userDaoTmp.getAll();

        for (User record : users) {
            System.out.print("ID : " + record.getUserId() );
            System.out.print(", fio : " + record.getFio() );
            System.out.println(", email : " + record.getEmail());
        }

        System.out.println("----Updating Record with ID = 7 -----" );
        userDaoTmp.update(new User(7, "qw", "qwerty", "qw", "qw"));

        System.out.println("----Listing Record with ID = 1 -----" );
        User user = userDaoTmp.findById(1);
        System.out.print("ID : " + user.getUserId() );
        System.out.print(", fio : " + user.getFio() );
        System.out.println(", email : " + user.getEmail());
    }
}
