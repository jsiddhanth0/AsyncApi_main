package com.example.demo12.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo12.services.serv;


@RestController
public class controller1 {
	
	@Autowired
	public serv serv1;
//	@Async
//	@GetMapping("/hello")
//	public CompletableFuture<String> Hello() throws InterruptedException
//	{ 
//		return CompletableFuture.supplyAsync(() ->{
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("I take 10 seconds to complete on a Thread named : " + Thread.currentThread().getName());
//		return "hello world" ;
//		});
//	}
	@GetMapping("/")
	public CompletableFuture<String> H(){
		return CompletableFuture.completedFuture("hiiiii from the build");
	}
//	"?"
	@GetMapping("/hello")
	public CompletableFuture<String> Helloooo(@RequestBody String query){
		return serv1.Hello(query);
	}
//	public CompletableFuture<String> Hello(@RequestBody String query) throws InterruptedException
//	{ 
////		return CompletableFuture.supplyAsync(() ->{
////		try {
////			Thread.sleep(20000);
////		} catch (InterruptedException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		System.out.println("I take 5 seconds to complete on a Thread named : " + Thread.currentThread().getName());
////		return "hello world and your query is: "+query  ;
////		});
//	}
//	
//	@GetMapping("/sync")
//	public String syncHello() throws InterruptedException {
//	    Thread.sleep(5000); // Simulate long-running task
//	    return "Hello from the main thread!";
//	}
//	
//	@Async
//	@GetMapping("/async")
//	public CompletableFuture<String> asyncHello() throws InterruptedException {
//	    return CompletableFuture.supplyAsync(() -> {
//	        try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} // Simulate long-running task
//	        return "Hello from a separate thread!";
//	    });
//	}
//	
//	
//	@GetMapping("/hello")
//	public String Hello(@RequestBody String query)
//	{ 
//		
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("I take 5 seconds to complete on a Thread named : " + Thread.currentThread().getName());
//		return "hello world and your query is: "+query  ;
//		
//	}
}
