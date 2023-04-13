package com.dewi.jones.cucumber.definitions;

import com.dewi.jones.dtos.response.PersonResponseDTO;
import com.dewi.jones.services.interfaces.IPersonService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;



public class PersonAgeStepDefinitions {
    private LocalDateTime today;
    private PersonResponseDTO person;
    private Long actualAgeAnswer;

    @Autowired
    IPersonService personService;

    @Given("today is {string}  and Persons dob is {string}")
    public void today_is(String today, String personDob) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        this.today = LocalDateTime.parse(today, formatter);
        var personResponseDTO = new PersonResponseDTO();
        personResponseDTO.setDob(LocalDateTime.parse(personDob, formatter));
    }

    @When("I ask their age")
    public void i_ask_whether_it_s_Friday_yet() {
        actualAgeAnswer = personService.getAgeInYears(today, person);
    }

    @Then("I should be told {string}")
    public void i_should_be_told(Long expectedAnswer) {
        assertEquals(expectedAnswer, actualAgeAnswer);
    }
}