package hu.futureofmedia.task.contactsapi;

import hu.futureofmedia.task.contactsapi.entities.Kapcsolattarto;
import hu.futureofmedia.task.contactsapi.enums.StatusEnum;
import hu.futureofmedia.task.contactsapi.repositories.CompanyRepository;
import hu.futureofmedia.task.contactsapi.repositories.KapcsolattartoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static hu.futureofmedia.task.contactsapi.DBTestUtils.*;
import static org.junit.jupiter.api.Assertions.*;

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
        kapcsolattartoRepository.saveAndFlush(TEST_KAPCSOLATTARTO);

        Optional<Kapcsolattarto> kapcsolattarto = kapcsolattartoRepository.findById(1L);
        if(kapcsolattarto.isPresent()){
            assertAll(
                    () -> assertEquals(1L, kapcsolattarto.get().getId()),
                    () -> assertEquals("Dummy", kapcsolattarto.get().getFirstName()),
                    () -> assertEquals("User", kapcsolattarto.get().getLastName()),
                    () -> assertEquals(companyRepository.findById(1L).get(), kapcsolattarto.get().getCompany()),
                    () -> assertEquals("dummy@testcompany.com", kapcsolattarto.get().getEmail()),
                    () -> assertEquals("+36001234123", kapcsolattarto.get().getPhone()),
                    () -> assertEquals("nocomment", kapcsolattarto.get().getComment()),
                    () -> assertEquals(StatusEnum.ACTIVE, kapcsolattarto.get().getStatus()),
                    () -> assertEquals(LocalDateTime.of(2020, 01, 01, 01, 01), kapcsolattarto.get().getCreationTime())
            );
        } else {
            fail("Nincs ilyen kapcsolattartó!");
        }
    }

    @Test
    @Transactional
    @DisplayName("Should only return active kapcsolattarto")
    public void should_only_return_active_kapcsolattarto(){
        companyRepository.save(TEST_COMPANY);
        kapcsolattartoRepository.saveAndFlush(TEST_KAPCSOLATTARTO);
        kapcsolattartoRepository.saveAndFlush(TEST_INACTIVE_KAPCSOLATTARTO);

        List<Kapcsolattarto> kapcsolattartok = (List<Kapcsolattarto>) kapcsolattartoRepository.findAll();
        System.out.println(kapcsolattartok.size());
        assertEquals(1, kapcsolattartok.size());
    }
}
