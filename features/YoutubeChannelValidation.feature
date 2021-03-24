@UATTesting
Feature: Youtube channel name validation
Scenario: Youtube channel name validations
	Given Open Chrome browser with URL
	When Search channel name
	And Click on channel name
	Then Validate channel name 