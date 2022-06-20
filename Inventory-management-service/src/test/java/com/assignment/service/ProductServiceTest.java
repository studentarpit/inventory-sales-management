/*
package service;

import com.assignment.entity.ProductEntity;
import com.assignment.entity.StockDetailsEntity;
import com.assignment.interfaces.repository.IProductRepository;
import com.assignment.interfaces.repository.IStockRepository;
import com.assignment.service.ProductService;
import com.assignment.service.StockDetailService;
import helper.ProductHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static helper.ProductHelper.getProduct;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    @InjectMocks
    ProductService productService;

    @Mock
    IProductRepository productRepository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    ProductService productServiceMock = mock(ProductService.class);
    StockDetailService stockDetailServiceMock = mock(StockDetailService.class);

    @Test
    public void test_updateProductIfAvailable(){
       when(productRepository.findByNameAndColorAndCategory(anyString(), anyString(), anyString())).thenReturn(Optional.of(ProductHelper.getProductEntity()));
        productService.addOrUpdateProduct(getProduct());
    }

    @Test
    public void test_addProductIfNotAvailable(){
        when(productRepository.findByNameAndColorAndCategory(anyString(), anyString(), anyString())).thenReturn(Optional.empty());
        productService.addOrUpdateProduct(getProduct());
    }

    @Test
    public void test_dontdeleteProductAndRespondGracefullyIfNotAvailable(){
        when(productRepository.findByNameAndColorAndCategory(anyString(), anyString(), anyString())).thenReturn(Optional.empty());
        productService.deleteProduct(getProduct());
    }

    @Test
    public void test_deleteProductIfAvailable(){
        when(productRepository.findByNameAndColorAndCategory(anyString(), anyString(), anyString())).thenReturn(Optional.of(ProductHelper.getProductEntity()));
        productService.deleteProduct(getProduct());
    }

    @Test
    public void test_addProduct(){
        doNothing().when(productServiceMock).addOrUpdateProduct(getProduct());
        doNothing().when(stockDetailServiceMock).updateAvailableStock(getProduct());
        productService.addProduct(getProduct());
    }

    @Test
    public void test_removeProduct(){
        doNothing().when(productServiceMock).deleteProduct(getProduct());
        doNothing().when(stockDetailServiceMock).removeAvailableStock(getProduct());
        productService.removeProduct(getProduct());
    }

    @Test
    public void test_reduceProduct(){
        when(productRepository.findByNameAndColorAndCategory(anyString(), anyString(), anyString())).thenReturn(Optional.of(ProductHelper.getProductEntity()));
        doNothing().when(stockDetailServiceMock).reduceAvailableStock(getProduct());
        productService.reduceProduct(getProduct());
    }
}
*/
