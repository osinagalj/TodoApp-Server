package com.todoList.app.configurations;
import org.springframework.http.HttpMethod;

public class SecurityPublicEndpoints {
	
	public static PublicEndpoint[] getPublicEndpoints() {
		return new PublicEndpoint[] {

				new PublicEndpoint("/folders/", HttpMethod.GET), // list of public endpoints.
				new PublicEndpoint("/login", HttpMethod.GET),
		};
	}

	public static class PublicEndpoint {

		private String		endpointMatcher;
		private HttpMethod	method;

		public PublicEndpoint(String endpointMatcher, HttpMethod method) {
			this.endpointMatcher = endpointMatcher;
			this.method = method;
		}

		public String getEndpointMatcher() {
			return endpointMatcher;
		}

		public HttpMethod getMethod() {
			return method;
		}

	}

}
