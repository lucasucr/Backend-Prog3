package ucema.prog3.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ucema.prog3.app.model.Cancion;
import ucema.prog3.app.repositories.CancionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CancionServiceImpl implements CancionService{

    @Autowired
    private CancionRepository cancionRepository;

    @Override
    @Transactional
    public Cancion createCancion(Cancion cancion) {
        this.cancionRepository.save(cancion);
        return cancion;
    }

    @Override
    @Transactional
    public Cancion updateCancion(Cancion cancion) {
        return this.cancionRepository.save(cancion);
    }

    @Override
    @Transactional
    public boolean deleteCancion(Cancion cancion) {
        if(cancion == null || cancion.getId() == null){
            return false;
        }
        try{
            this.cancionRepository.delete(cancion);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cancion> getAll() {
        return (List<Cancion>) this.cancionRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cancion> getByNombre(String nombre) {
        return this.cancionRepository.findByNombre(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Cancion> getByArtista(String artista) {
        return this.cancionRepository.findByArtista(artista);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cancion> getByAlbum(String album) {
        return this.cancionRepository.findByAlbum(album);
    }
}
