package petstore.controller;

/**
 * Created by ChristanV on 2017/07/31.
 */

import java.util.List;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import petstore.model.Pet;
import petstore.services.PetStoreService;
@Api(basePath = "/pets", value = "petstore", description = "Operations with petstore", produces = "application/json")
@RestController
@RequestMapping("api/v1/")
public class PetStoreController {

    @Autowired
    private PetStoreService petStoreService;

    @RequestMapping(method = RequestMethod.GET, value = "pets")
    public List<Pet> getAllPets() {
        return petStoreService.getPets();
    }

    @RequestMapping(method = RequestMethod.POST, value = "pets")
    public Pet addPet(@RequestBody Pet pet){
        return petStoreService.addPet(pet);
    }

    @RequestMapping(method=RequestMethod.PUT,value="pets/{id}")
    public Pet updatePet(@RequestBody Pet pet, @PathVariable String id) {
        return petStoreService.updatePets(pet, id);
    }

    @RequestMapping(method = RequestMethod.GET, value= "pets/{id}")
    public Pet findPet(@PathVariable String id) {
        return petStoreService.findPet(id);
    }

    @RequestMapping(method = RequestMethod.GET,value = "pets/bystatus/{status}")
    public List<Pet> getPetByStatus(@PathVariable boolean status) {
        return petStoreService.getPetsWithStatus(status);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/pets/image/{id}")
    public Pet uploadImage(@PathVariable String id, @RequestBody String imageurl){
        return petStoreService.uploadImage(id, imageurl);
    }

    @RequestMapping(method =RequestMethod.GET, value = "/pets/status/{status}")
    public int getPetsByStatus(@PathVariable boolean status){
        return petStoreService.getNumberPetsWithStatus(status);
    }

}
