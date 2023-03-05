package br.com.ada.adviser.config;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.codec.Decoder;

@Configuration
public class FeignResponseDecoderConfig {
	@Autowired
	private AdviceSlipResponseMessageConverter adviceSlipResponseMessageConverter;

	@Bean
	public Decoder feignDecoder() {
		ObjectFactory<HttpMessageConverters> messageConverters = () -> {
			HttpMessageConverters converters = new HttpMessageConverters(adviceSlipResponseMessageConverter);
			return converters;
		};
		return new SpringDecoder(messageConverters);
	}
}
