package petstore.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import petstore.model.Pet;

/**
 * Created by ChristanV on 2017/08/01.
 */
@Service
public class PetStoreService {

    private static Map<String, Pet> pets = new HashMap<String, Pet>();
    private static int petIndex = 3;

    //populate pets
    static {
        Pet a = new Pet("1", "Pet1","/");
        pets.put("1",a);
        Pet b = new Pet("2", "Pet2","/");
        pets.put("2",b);
        Pet c = new Pet("3", "Pet3","/");
        pets.put("3",c);
    }

    public static List<Pet> getPets() {
        return new ArrayList<Pet>(pets.values());
    }

    public static Pet addPet(Pet pet){
        petIndex += 1;
        pet.setPetId(String.valueOf(petIndex));
        pets.put(String.valueOf(petIndex), pet);
        return pet;
    }

    public static Pet updatePets(Pet pet, String id){
        Pet updatedPet = pets.get(id);
        if (updatedPet != null) {
            pet.setPetId(updatedPet.getPetId());
            pets.put(id, pet);
        }
        return pets.get(id);
    }

    public static Pet findPet(String id){
        List<Pet> petsList = getPets();
        return petsList.stream().filter(p -> p.getPetId().equals(id)).findFirst().get();
    }

    public static List<Pet> getPetsWithStatus(boolean petstatus) {
        List<Pet> petsList = getPets();
        return  petsList.stream().filter(p -> p.getPetStatus() == (petstatus)).collect(Collectors.toList());
    }

    public static Pet uploadImage(String id, String imageurl){
        Pet updatedPet = pets.get(id);
        if (updatedPet != null) {
            updatedPet.setImage(imageurl);
            pets.put(id, updatedPet);
        }
        return pets.get(id);
    }

    public static int getNumberPetsWithStatus(boolean petstatus) {
        List<Pet> petsList = getPets();
        return (int) petsList.stream().filter(p -> p.getPetStatus() == (petstatus)).count();
    }




}
