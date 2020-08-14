package br.com.contmatic.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ EmpresaServiceTest.class, MongoEmbedded.class })
public class TestAllService {

}