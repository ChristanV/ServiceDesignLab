package petstore;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import petstore.controller.PetStoreController;
import petstore.model.Pet;
import petstore.services.PetStoreService;


import static org.junit.Assert.assertEquals;
/**
 * Created by ChristanV on 2017/08/07.
 */
public class PetStoreControllerTest {

    @InjectMocks
    private PetStoreController pc;

    @Mock
    private PetStoreService petStoreService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_PetStore_Add(){
        Pet a = new Pet("Pet4","/vdvsv");
        pc.addPet(a);
        assertEquals(a, pc.findPet("4"));
    }

    @Test
    public void test_PetStore_number_pets_Adoptable(){
        int actual =  pc.getPetsByStatus(false);
        assertEquals(3, actual);
    }
}
