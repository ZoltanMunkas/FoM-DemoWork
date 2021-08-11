package hu.futureofmedia.task.contactsapi;

import hu.futureofmedia.task.contactsapi.entities.Company;
import hu.futureofmedia.task.contactsapi.entities.Kapcsolattarto;
import hu.futureofmedia.task.contactsapi.enums.StatusEnum;

import java.time.LocalDateTime;

public class DBTestUtils {

    public static Company TEST_COMPANY = Company.builder()
            .id(1L)
            .name("testcompany")
            .build();

    public static Kapcsolattarto TEST_KAPCSOLATTARTO = Kapcsolattarto.builder()
            .id(1L)
            .firstName("Dummy")
            .lastName("User")
            .company(TEST_COMPANY)
            .email("dummy@testcompany.com")
            .phone("+36001234123")
            .comment("nocomment")
            .status(StatusEnum.ACTIVE)
            .creationTime(LocalDateTime.of(2020, 01, 01, 01, 01))
            .build();


    public static Kapcsolattarto TEST_INACTIVE_KAPCSOLATTARTO = Kapcsolattarto.builder()
            .id(2L)
            .firstName("Dummy")
            .lastName("User")
            .company(TEST_COMPANY)
            .email("dummy@testcompany.com")
            .phone("+36001234123")
            .comment("nocomment")
            .status(StatusEnum.ARCHIVED)
            .creationTime(LocalDateTime.of(2020, 01, 01, 01, 01))
            .build();
}
