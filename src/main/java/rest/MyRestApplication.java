package rest;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
// javax.ws 是 rest 套件
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class MyRestApplication extends Application {
	
	// 註冊有哪些 rest 服務
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new LinkedHashSet<>();
		// 註冊
		classes.add(HelloService.class); // HelloService 是一個 rest 服務程式
		return classes;
	}
	
	
	
}
