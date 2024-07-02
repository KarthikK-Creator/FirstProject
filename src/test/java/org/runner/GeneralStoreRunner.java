package org.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\hp\\eclipse-workspace\\GeneralStoreApplication\\src\\test\\resources\\FeatureFiles\\GeneralStore.feature",glue="org.step")
public class GeneralStoreRunner {

}
