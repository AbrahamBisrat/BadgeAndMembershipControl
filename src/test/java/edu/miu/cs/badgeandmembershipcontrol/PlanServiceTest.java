package edu.miu.cs.badgeandmembershipcontrol;

import edu.miu.cs.badgeandmembershipcontrol.controller.PlanController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.client.RestOperations;

import static org.hamcrest.MatcherAssert.assertThat;

/*@SpringBootTest
        //(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PlanServiceTest {
create llocation list of
    @Autowired
    private PlanController planController;

    @Test
    public void shouldPassIfStringMatches() throws Exception {
        RestOperations restTemplate = null;
        assertThat(restTemplate.getForObject("http://localhost:9080").contains("Hello World from Spring Boot"));
    }
}

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;
    @Autowired
    @InjectMocks
    private ProductServiceImpl productService;
    private Product product1;
    private Product product2;
    List<Product> productList;
    @BeforeEach
    public void setUp() {
    productList = new ArrayList<>();
    product1 = new Product(1, "bread",20);
    product2 = new Product(2, "jam",200);
    productList.add(product1);
    productList.add(product2);
    }
    @AfterEach
    public void tearDown() {
    product1 = product2 = null;
    productList = null;
    }*/


/*@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;
    @Autowired
    @InjectMocks
    private ProductServiceImpl productService;
    private Product product1;
    private Product product2;
    List<Product> productList;
    @BeforeEach
    public void setUp() {
    productList = new ArrayList<>();
    product1 = new Product(1, "bread",20);
    product2 = new Product(2, "jam",200);
    productList.add(product1);
    productList.add(product2);
    }
    @AfterEach
    public void tearDown() {
    product1 = product2 = null;
    productList = null;
    }*/

/*[INFO]
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.example.demo.PatientRecordControllerTest
[INFO] Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.504 s - in com.example.demo.PatientRecordControllerTest
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 8, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  5.633 s
[INFO] Finished at: 2021-05-25T19:51:24+02:00
[INFO] ------------------------------------------------------------------------*/

/*@Test
public void GivenGetAllUsersShouldReturnListOfAllUsers(){
     productRepository.save(product2);
    //stubbing mock to return specific data
    when(productRepository.findAll()).thenReturn(productList);
    List<Product> productList1 =productService.getAllProducts();
    assertEquals(productList1,productList);
    verify(productRepository,times(1)).save(product2);
    verify(productRepository,times(1)).findAll();
}*/