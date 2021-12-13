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
    	String URLresposta = "/statusProcessor";
    	   	
    	
        try {
        	
        	if(validaNumPlayers(sala.getNumPlayers())) {
       		 URLresposta = "/statusProcessor" + sala.getId().toString();
        	} 
        	
            Thread.sleep(1000L);
            
            template.convertAndSend(URLresposta, gerarMensagem(1) 
            		+ " Sala Número: " + sala.getId() 
            		+"Num Player: " + sala.getNumPlayers());
        
        } catch (InterruptedException e) {
            log.error("Erro durante o procesamento.", e);
        }
    }

    private String gerarMensagem(int etapa) {
        return String.format("Executada a etapa %s às %s", etapa,
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
    }
    
//    private String gerarURL(Mensagem mensagem) {
//    	mensagem.setId(1L);
//    	 String URL = ServletUriComponentsBuilder.fromCurrentContextPath().path("/statusProcessor")
//    			 .path(mensagem.getId().toString()).toUriString();
//    	 return URL;
//    	
//    }
    
    private Boolean validaNumPlayers(Integer numeroPlayers) {
    	if(numeroPlayers > 6) {
    		return false;
    	}
    	return true;
    }
    
}
