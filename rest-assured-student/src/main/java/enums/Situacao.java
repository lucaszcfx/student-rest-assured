package enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Situacao {
	@JsonProperty("post")
	POST,
	
	@JsonProperty("put")
	PUT,
	
	@JsonProperty("get")
	GET,
	
	@JsonProperty("delete")
	DELETE
}
