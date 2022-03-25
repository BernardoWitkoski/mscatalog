package Service;

import Dto.VariationsDTO;
import Dto.VariationsFormDTO;
import Entity.Variations;
import Repository.VariationsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VariationsServiceImpl implements VariationsService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private VariationsRepository repository;

    @Override
    public VariationsDTO save(VariationsFormDTO body) {
        Variations variations = this.repository.save(mapper.map(body, Variations.class));
        return mapper.map(variations, VariationsDTO.class);
    }

    @Override
    public VariationsDTO update(String id, VariationsFormDTO body) {
        Variations variations = this.repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Variation not found"));
        variations.setColor(body.getColor());
        variations.setSize(body.getSize());
        variations.setPrice(body.getPrice());
        variations.setQuantity(body.getQuantity());
        Variations updatedVariations = this.repository.save(variations);
        return mapper.map(updatedVariations, VariationsDTO.class);
    }

    @Override
    public void delete(String id) {
        Variations variations = this.repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Variation not found"));
        this.repository.delete(variations);
    }
}
