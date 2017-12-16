package ru.javawebinar.topjava.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.*;
import static ru.javawebinar.topjava.MealTestData.*;
import static ru.javawebinar.topjava.UserTestData.ADMIN_ID;
import static ru.javawebinar.topjava.UserTestData.USER_ID;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class MealServiceImplTest {

    static {
        SLF4JBridgeHandler.install();
    }

    @Autowired
    private MealService service;

    @Test
    public void get() throws Exception {
        assertEquals(service.get(USER_MEAL_ID, USER_ID), MEAL1);
    }
    @Test(expected = NotFoundException.class)
    public void getNotFoundException() throws Exception {
        service.get(USER_MEAL_ID, USER_ID);
    }

    @Test
    public void delete() throws Exception {
        service.delete(USER_MEAL_ID, USER_ID);
        assertMatch(service.getAll(USER_ID), MEAL6,MEAL5,MEAL4,MEAL3,MEAL2);
    }
    @Test
    public void getBetweenDateTimes() throws Exception {
        assertMatch(service.getBetweenDateTimes(LocalDateTime.of(2015,6, 1,00,00),
                LocalDateTime.of(2015,6,2,00,00), USER_ID),MEAL3, MEAL2,MEAL1);
    }

    @Test
    public void getAll() throws Exception {
        assertMatch(service.getAll(USER_ID), MEALS);

    }

    @Test
    public void update() throws Exception {
        Meal actual = new Meal(USER_MEAL_ID, LocalDateTime.of(2015, Month.JUNE, 01, 10, 00), "update", 510);
        assertEquals(service.update(actual, USER_ID), actual);
    }

    @Test
    public void create() throws Exception {
        Meal actual = new Meal(LocalDateTime.now(), "new", 11);
        assertEquals(service.create(actual,USER_ID), actual);
    }

}