package tatsumibruno.samples.websocketprocessor.process.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tatsumibruno.samples.websocketprocessor.Mensagem;
import tatsumibruno.samples.websocketprocessor.process.CreatedProcess;
import tatsumibruno.samples.websocketprocessor.process.domain.ProcessorService;

import javax.websocket.server.PathParam;
import java.time.LocalDateTime;

@CrossOrigin
@RestController
@RequestMapping(path = "/api")
public class ProcessController {

    private ProcessorService service;

    @Autowired
    public ProcessController(ProcessorService service) {
        this.service = service;
    }

    @PutMapping
    public ResponseEntity<CreatedProcess> execute(@RequestBody Mensagem mensagem) {
        service.execute(mensagem);
        return ResponseEntity.ok().body(new CreatedProcess(LocalDateTime.now()));
    }
}
