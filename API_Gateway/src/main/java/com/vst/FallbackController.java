//package com.vst;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import reactor.core.publisher.Mono;
//
//@RestController
//public class FallbackController {
//	
//	@RequestMapping("/orderFallBack")
//	public Mono<String> orderServiceFallback(){
//		return Mono.just("Order Service is Taking To Long to Respond or is Down. Please Try Again Later");
//	}
// 
//	@RequestMapping("/paymentFallBack")
//	public Mono<String> paymentServiceFallback(){
//		return Mono.just("Payment Service Is Taking to Long to Respond or is Down. Pleasse Try Again Later");
//	}
//}
