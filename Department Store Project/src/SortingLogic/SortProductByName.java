 package SortingLogic;
import java.util.Comparator;
import com.jspiders.Product;

public class SortProductByName implements Comparator<Product> {
	@Override
	public int compare(Product x, Product y) {
		return x.getName().compareTo(y.getName());	
	}
}
