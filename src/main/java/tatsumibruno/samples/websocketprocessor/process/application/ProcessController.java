package tatsumibruno.samples.websocketprocessor.process.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tatsumibruno.samples.websocketprocessor.Sala;
import tatsumibruno.samples.websocketprocessor.process.CreatedProcess;
import tatsumibruno.samples.websocketprocessor.process.domain.ProcessorService;
import java.time.LocalDateTime;

@CrossOrigin
@RestController
@RequestMapping(path = "/api")
public class ProcessController {

	@Autowired
	private ProcessorService service;

	@PutMapping
	public ResponseEntity<CreatedProcess> execute(@RequestBody Sala sala) {		
		service.execute(sala);

		return ResponseEntity.ok().body(new CreatedProcess(LocalDateTime.now()));
	}
}
