package tatsumibruno.samples.websocketprocessor.process.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import tatsumibruno.samples.websocketprocessor.Mensagem;
import tatsumibruno.samples.websocketprocessor.Sala;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
public class ProcessorService {

	private SimpMessagingTemplate template;

	@Autowired
	public ProcessorService(SimpMessagingTemplate template) {
		this.template = template;
	}

	@Async
	public void execute(Sala sala) {
		String URLresposta = "/statusProcessor" + sala.getId().toString();

		try {

			template.convertAndSend(URLresposta, gerarMensagem() 
					+ "\n: Sala Número: " + sala.getId()
					+ " \nUsuário: " + sala.getUsuario() 
					+ "\nMensagem: " + sala.getMensagem()

			);

		} catch (Exception e) {
			log.error("Erro durante o procesamento.", e);
		}
	}

	private String gerarMensagem() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	}

//    private String gerarURL(Sala sala) {
//    	mensagem.setId(1L);
//    	 String URL = ServletUriComponentsBuilder.fromCurrentContextPath().path("/statusProcessor")
//    			 .path(mensagem.getId().toString()).toUriString();
//    	 return URL;
//    	
//    }

}
