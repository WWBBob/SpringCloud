package com.bob.cloud.provider.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.Subscription;

public class HelloWorldHystrixCommand extends HystrixCommand<Observable> {
	
	private String name;

	public HelloWorldHystrixCommand(String groupName) {
		super(HystrixCommandGroupKey.Factory.asKey(groupName));
		this.name = groupName;
	}

	@Override
	protected Observable run() throws Exception {
		System.out.println(Thread.currentThread().getName());
		return Observable.create(new OnSubscribe<Object>(){

			@Override
			public void call(Subscriber<? super Object> server) {
				server.onCompleted();
			}
		});
	}
	
	@Override
	protected Observable getFallback() {
		return Observable.create(new OnSubscribe<Object>(){

			@Override
			public void call(Subscriber<? super Object> server) {
				server.onCompleted();
			}
		});
	}
	
	abstract class SubscriberAdapter<T> extends Subscriber<T>{

		@Override
		public void onError(Throwable e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onNext(T t) {
			
		}
		
	}

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		HelloWorldHystrixCommand com = new HelloWorldHystrixCommand("TEST");
		Observable ob = com.execute();
		Subscription sb = ob.subscribe(com.new SubscriberAdapter<Object>() {

			@Override
			public void onCompleted() {
				System.out.println("start=============");
				System.out.println(Thread.currentThread().getName());
				System.out.println("END=============");
			}
		});
		sb.unsubscribe();
		System.out.println("+++++++++++++++++++++++++");
	}

}
