package com.annotations;

public class AnnotationExample {
	
	public static void main(String[] args) {
		multipleSubjectsTest();
	}

	@Override
	@CustomAnnotation(name = "Aakash", subjects = {"Maths"}, id = 2)
	public String toString() {
		return "Overriden toString method";
	}

	@CustomAnnotation(subjects = {"CHEM"})
	public static void defaultValueMethod() {
		System.out.println("This method uses default annoation values");
	}

	@CustomAnnotation(name = "TestUser", subjects = {"Maths", "Physics"}, id = 9)
	public static void multipleSubjectsTest() {
		System.out.println("This method uses multiple annoation values for subjects property");
		defaultValueMethod();
	}
}
