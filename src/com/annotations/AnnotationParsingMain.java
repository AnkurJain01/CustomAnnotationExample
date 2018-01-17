package com.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationParsingMain {

	public static void main(String[] args) {
		try {
			for (Method method : AnnotationParsingMain.class.getClassLoader()
					.loadClass(("com.annotations.AnnotationExample")).getMethods()) {
				// checks if CustomAnnotation annotation is present for the
				// method
				if (method.isAnnotationPresent(com.annotations.CustomAnnotation.class)) {
					try {
						// iterates all the annotations available in the method
						for (Annotation anno : method.getDeclaredAnnotations()) {
							System.out.println("Annotation in Method '" + method + "' : " + anno);
						}
						CustomAnnotation methodAnno = method.getAnnotation(CustomAnnotation.class);
						System.out.println("NAME:" + methodAnno.name());
						System.out.print("SUBJECTS:");
						for (String subject : methodAnno.subjects()) {
							System.out.print("\t" + subject);
						}
						System.out.println("\nID:" + methodAnno.id());

					} catch (Throwable ex) {
						ex.printStackTrace();
					}
				}
			}
		} catch (SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
