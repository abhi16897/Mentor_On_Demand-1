package com.cts.training.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import com.cts.training.service.model.MentorDetails;
import com.cts.training.service.model.MentorSkills;
import com.cts.training.service.model.StudentDetails;
import com.cts.training.service.model.Technology;
import com.cts.training.service.model.Training;
import com.cts.training.service.repository.StudentDetailsRepository;
import com.cts.training.service.repository.TrainingRepository;
import com.cts.training.service.service.TrainingService;

@SpringBootTest
public class TrainingServiceApplicationTests {

	@InjectMocks
	TrainingService trainingservice;

	@Mock
	TrainingRepository trainingRepository;

	@Mock
	StudentDetailsRepository studentDetailsRepository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testgetProposal() {

		Training training = new Training();

		training.setId(1);
		training.setRating(7);
		training.setAmount(1500);
		training.setProgress("Hello");
		training.setStatus("Yes");

		MentorDetails mentordetails = new MentorDetails();
		mentordetails.setId(1);
		mentordetails.setUserName("Hello");
		mentordetails.setEmail("hello@gmail.com");
		mentordetails.setPassword("Hello");
		mentordetails.setFirstName("Hello");
		mentordetails.setLastName("Hello");
		mentordetails.setContact("8978799788");
		mentordetails.setExperience(4);
		mentordetails.setActive(false);
		mentordetails.setLinkedInUrl("http://linkedin.com");
		mentordetails.setImage("hello");

		MentorSkills mentorskills = new MentorSkills();
		mentorskills.setId(1);
		mentorskills.setMentorDetails(mentordetails);
		mentorskills.setFacilities("Have it");
		mentorskills.setExperience(2);
		mentorskills.setRating(9);
		mentorskills.setTrainings(25);

		Technology technology = new Technology();
		technology.setId(1);
		technology.setDuration(2);
		technology.setName("SAP");
		technology.setPrerequisites("Books");

		mentorskills.setTechnologies(technology);
		Set<MentorSkills> setmentorskills = new LinkedHashSet<>();
		setmentorskills.add(mentorskills);

		technology.setMentorSkills(setmentorskills);
		mentordetails.setMentorSkills(setmentorskills);

		StudentDetails student = new StudentDetails();
		student.setUserName("Hello");
		student.setEmail("hello@gmail.com");
		student.setPassword("hello");
		student.setFirstName("hello");
		student.setLastName("hi");
		student.setContact("8978799788");

		training.setMentorDetails(mentordetails);
		training.setMentorSkills(mentorskills);
		training.setStudentDetails(student);

		List<Training> listTraining = new ArrayList<>();
		listTraining.add(training);

		when(trainingRepository.findByStudentDetails(studentDetailsRepository.findByUserName("Hello")))
				.thenReturn(listTraining);
		List<Training> testlistTraining = trainingRepository
				.findByStudentDetails(studentDetailsRepository.findByUserName("Hello"));
		for (Training trainingDetails : testlistTraining) {
			assertEquals("Hello", trainingDetails.getMentorDetails().getFirstName());
		}
	}

	@Test
	public void testgetProposalFailure() {

		Training training = new Training();

		training.setId(1);
		training.setRating(7);
		training.setAmount(1500);
		training.setProgress("Hello");
		training.setStatus("Yes");

		MentorDetails mentordetails = new MentorDetails();
		mentordetails.setId(1);
		mentordetails.setUserName("Hello");
		mentordetails.setEmail("hello@gmail.com");
		mentordetails.setPassword("Hello");
		mentordetails.setFirstName("Hello");
		mentordetails.setLastName("Hello");
		mentordetails.setContact("8978799788");
		mentordetails.setExperience(4);
		mentordetails.setActive(false);
		mentordetails.setLinkedInUrl("http://linkedin.com");
		mentordetails.setImage("hello");

		MentorSkills mentorskills = new MentorSkills();
		mentorskills.setId(1);
		mentorskills.setMentorDetails(mentordetails);
		mentorskills.setFacilities("Have it");
		mentorskills.setExperience(2);
		mentorskills.setRating(9);
		mentorskills.setTrainings(25);

		Technology technology = new Technology();
		technology.setId(1);
		technology.setDuration(2);
		technology.setName("SAP");
		technology.setPrerequisites("Books");

		mentorskills.setTechnologies(technology);
		Set<MentorSkills> setmentorskills = new LinkedHashSet<>();
		setmentorskills.add(mentorskills);

		technology.setMentorSkills(setmentorskills);
		mentordetails.setMentorSkills(setmentorskills);

		StudentDetails student = new StudentDetails();
		student.setUserName("Hello");
		student.setEmail("hello@gmail.com");
		student.setPassword("hello");
		student.setFirstName("hello");
		student.setLastName("hi");
		student.setContact("8978799788");

		training.setMentorDetails(mentordetails);
		training.setMentorSkills(mentorskills);
		training.setStudentDetails(student);

		List<Training> listTraining = new ArrayList<>();
		listTraining.add(training);

		when(trainingRepository.findByStudentDetails(studentDetailsRepository.findByUserName("Hello")))
				.thenReturn(listTraining);
		List<Training> testlistTraining = trainingRepository
				.findByStudentDetails(studentDetailsRepository.findByUserName("Hello"));
		for (Training trainingDetails : testlistTraining) {
			assertEquals("Heello", trainingDetails.getMentorDetails().getFirstName());
		}
	}
}
