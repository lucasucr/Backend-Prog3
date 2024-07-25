package ucema.prog3.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucema.prog3.app.model.Cancion;
import ucema.prog3.app.services.CancionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/song")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CancionController {

    @Autowired
    private CancionService cancionService;

    @PostMapping(value = "")
    public Cancion createCancion(@RequestBody Cancion cancion){
        return cancionService.createCancion(cancion);
    }

    @PutMapping(value = "")
    public Cancion updateCancion(@RequestBody Cancion cancion){
        return cancionService.updateCancion(cancion);
    }

    @DeleteMapping(value = "")
    public boolean deleteCancion(@RequestBody Cancion cancion){
        return cancionService.deleteCancion(cancion);
    }

    @GetMapping(value = "/all")
    public List<Cancion> getAll(){
        return cancionService.getAll();
    }
}
