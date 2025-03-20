package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomUtils {
    private final Faker fakerRu = new Faker(new Locale("ru"));
    private final Faker fakerEn = new Faker(new Locale("en"));

    public String getRandomMobilePhoneNumber() {
        return fakerRu.phoneNumber().phoneNumber();
    }

    public String getRandomPhoneNumberWithLength(int value) {
        return fakerEn.phoneNumber().subscriberNumber(value);
    }

    public String getRandomEmailAddress() {
        return fakerEn.internet().emailAddress();
    }

    public String getRandomPassword() {
        return fakerEn.internet().password();
    }
}