
import androidx.lifecycle.MutableLiveData
import com.example.api.ProductsAPI
import com.example.model.Products
import com.example.retrofit1.network.NetworkResult

class ProductRepository(private  val productsAPI: ProductsAPI) {

    private val productLiveData=MutableLiveData<Products>()
    suspend fun getProduct(): NetworkResult<Products> {
        val response=productsAPI.getProducts()
        return  if (response.isSuccessful){
            val responseBody=response.body()
            if (responseBody!= null){
                NetworkResult.Success(responseBody)
            }else{
                NetworkResult.Error("Something went wrong")
            }
        }else{
            NetworkResult.Error("Something went wrong")
        }
    }
}