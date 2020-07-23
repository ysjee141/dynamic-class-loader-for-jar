package com.tidesquare.DynamicLoader;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class LoaderProjectApp {

	public static void main(String[] args) throws Exception {

		File file = new File("D:\\01-WorkSpace\\99-Sample\\DynamicLoadJar\\LoaderProject\\SimpleJar.jar");
		URL url = file.toURI().toURL();

		URLClassLoader classLoader = new URLClassLoader(
				new URL[]{url},
				ClassLoader.getSystemClassLoader()
		);

		Class<?> clazz = Class.forName("com.tidesquare.DynamicLoader.SimpleClass", true, classLoader);
		Method method = clazz.getDeclaredMethod("getName");
		Object instance = clazz.newInstance();
		System.out.println(method.invoke(instance));

	}

}
