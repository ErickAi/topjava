package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;

public class MealTestData {
    public static final int ADMIN_MEAL_ID = START_SEQ + 8;
    public static final int USER_MEAL_ID = START_SEQ + 2;
    public static final Meal MEAL1 = new Meal(USER_MEAL_ID, LocalDateTime.of(2015, Month.JUNE, 01, 10, 00), "breakfast", 510);
    public static final Meal MEAL2 = new Meal(USER_MEAL_ID + 1, LocalDateTime.of(2015, Month.JUNE, 01, 16, 00), "lunch", 1500);
    public static final Meal MEAL3 = new Meal(USER_MEAL_ID + 2, LocalDateTime.of(2015, Month.JUNE, 01, 19, 00), "dinner", 500);
    public static final Meal MEAL4 = new Meal(USER_MEAL_ID + 3, LocalDateTime.of(2015, Month.JUNE, 02, 10, 00), "breakfast", 500);
    public static final Meal MEAL5 = new Meal(USER_MEAL_ID + 4, LocalDateTime.of(2015, Month.JUNE, 02, 16, 00), "lunch", 1500);
    public static final Meal MEAL6 = new Meal(USER_MEAL_ID + 5, LocalDateTime.of(2015, Month.JUNE, 02, 19, 00), "dinner", 500);
//    public static final Meal ADMIN_MEAL1 = new Meal(ADMIN_MEAL_ID, LocalDateTime.of(2015, Month.JUNE, 01, 14, 00), "Админ ланч", 510);
//    public static final Meal ADMIN_MEAL2 = new Meal(ADMIN_MEAL_ID, LocalDateTime.of(2015, Month.JUNE, 01, 19, 00), "Админ ужин", 1500);

    public static final List<Meal> MEALS = Arrays.asList(MEAL6, MEAL5, MEAL4, MEAL3, MEAL2, MEAL1);

    public static void assertMatch(Meal actual, Meal expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "registered", "roles");
    }

    public static void assertMatch(Iterable<Meal> actual, Meal... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Meal> actual, Iterable<Meal> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("registered", "roles").isEqualTo(expected);
    }

}
