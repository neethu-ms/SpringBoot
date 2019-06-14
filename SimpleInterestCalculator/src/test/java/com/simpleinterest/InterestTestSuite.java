package com.simpleinterest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.simpleinterest.controller.InterestControllerTest;

import com.simpleinterest.repository.InterestRepositoryTest;
import com.simpleinterest.service.InterestServiceTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({InterestControllerTest.class,InterestServiceTest.class,InterestRepositoryTest.class})
public class InterestTestSuite {
   
}
