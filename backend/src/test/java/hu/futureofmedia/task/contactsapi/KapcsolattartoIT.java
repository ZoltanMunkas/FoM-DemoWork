package hu.futureofmedia.task.contactsapi;

import hu.futureofmedia.task.contactsapi.entities.Kapcsolattarto;
import hu.futureofmedia.task.contactsapi.enums.StatusEnum;
import hu.futureofmedia.task.contactsapi.repositories.CompanyRepository;
import hu.futureofmedia.task.contactsapi.repositories.KapcsolattartoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

import static hu.futureofmedia.task.contactsapi.DBTestUtils.TEST_COMPANY;
import static hu.futureofmedia.task.contactsapi.DBTestUtils.TEST_KAPCSOLATTARTO;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {ContactsApiApplication.class})
public class KapcsolattartoIT {

    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    KapcsolattartoRepository kapcsolattartoRepository;

    @Test
    @Transactional
    @DisplayName("Should save kapcsolattarto to db and read the values")
    public void should_save_kapcsolattarto_to_db_and_read_the_values(){
        companyRepository.save(TEST_COMPANY);
        kapcsolattartoRepository.save(TEST_KAPCSOLATTARTO);

        Optional<Kapcsolattarto> kapcsolattarto = kapcsolattartoRepository.findById(1L);
        kapcsolattarto.ifPresent(value -> assertAll(
                () -> assertEquals(1L, value.getId()),
                () -> assertEquals("Dummy", value.getFirstName()),
                () -> assertEquals("User", value.getLastName()),
                () -> assertEquals(companyRepository.findById(1L).get(), value.getCompany()),
                () -> assertEquals("dummy@testcompany.com", value.getEmail()),
                () -> assertEquals("+36001234123", value.getPhone()),
                () -> assertEquals("nocomment", value.getComment()),
                () -> assertEquals(StatusEnum.ACTIVE, value.getStatus()),
                () -> assertEquals(LocalDateTime.MIN, value.getCreationTime())
        ));
    }
}
