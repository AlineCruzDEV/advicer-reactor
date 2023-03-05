package br.com.ada.adviser.config;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.ada.adviser.web.dto.response.AdviceSlipResponse;

@Component
public class AdviceSlipResponseMessageConverter extends AbstractHttpMessageConverter<AdviceSlipResponse> {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public AdviceSlipResponseMessageConverter() {
		this(StandardCharsets.UTF_8);
	}
	
	public AdviceSlipResponseMessageConverter(Charset defaultCharset) {
		super(defaultCharset, MediaType.TEXT_HTML);
	}
	
	@Override
	protected boolean supports(Class<?> clazz) {
		return AdviceSlipResponse.class == clazz;
	}

	@Override
	protected AdviceSlipResponse readInternal(Class<? extends AdviceSlipResponse> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		return objectMapper.readValue(inputMessage.getBody(), clazz);
	}

	@Override
	protected void writeInternal(AdviceSlipResponse t, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		objectMapper.writeValue(outputMessage.getBody(), t);
	}
	
}
