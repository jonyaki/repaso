package com.example.repaso;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/service")
public class RestTestController {
	
	@DeleteMapping("/deleteMarca/{idMarca}")
	public ResponseEntity<String> delete(@PathVariable Long idMarca) {		
		if(idMarca.equals(1L)) {
			return new ResponseEntity<>(idMarca.toString(), HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(idMarca.toString(), HttpStatus.NOT_FOUND);
		}
	} 
	
	@GetMapping("/getMarcaxId/{idMarca}")
	public ResponseEntity<String> getMarcaxId(@PathVariable Long idMarca){
		if(idMarca.equals(1L)) {
			return new ResponseEntity<>(idMarca.toString(), HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(idMarca.toString(), HttpStatus.NOT_FOUND);
		}

	}

}
